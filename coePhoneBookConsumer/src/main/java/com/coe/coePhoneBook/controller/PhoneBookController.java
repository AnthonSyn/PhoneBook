package com.coe.coePhoneBook.controller;


import com.coe.coePhoneBook.entity.PhoneBookEntity;
import com.coe.coePhoneBook.kafkaproducer.model.PhoneBook;
import com.coe.coePhoneBook.repository.PhoneBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/phonebook")
public class PhoneBookController {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @GetMapping("/{idPhoneBook}")
    public PhoneBook getPhoneBookById(@PathVariable("idPhoneBook") int idPhoneBook) {
        if (idPhoneBook <= 0) {
            return null;
        }

        PhoneBookEntity phoneBookEntity = phoneBookRepository.findById(idPhoneBook).orElse(null);
        if (phoneBookEntity != null)
            return new PhoneBook(phoneBookEntity);
        return null;
    }

    @GetMapping("")
    public List<PhoneBook> getPhoneBook() {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        List<PhoneBookEntity> entities = phoneBookRepository.findAll();
        for (PhoneBookEntity entity : entities) {
            phoneBooks.add(new PhoneBook(entity));
        }
        return phoneBooks;
    }

    @GetMapping("/customer/{phoneNumber}")
    public List<PhoneBook> getPhoneBookByCustomer(@PathVariable("phoneNumber") String phoneNumber) throws IOException {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        List<PhoneBookEntity> entities = phoneBookRepository.findByCustomerIdPhoneNumber(phoneNumber);

        for (PhoneBookEntity entity : entities
        ) {
            phoneBooks.add(new PhoneBook(entity));
        }

        return phoneBooks;
    }


}
