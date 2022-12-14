package com.coe.PhoneBookProducer.Controller;


import com.coe.PhoneBookProducer.model.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("phonebook/produce")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, PhoneBook> kafkaUserTemplate;
    @Autowired
    private KafkaTemplate<String, Integer> kafkaIdPhoneBookTemplate;

    @PostMapping("")
    public String saveCustomer(@RequestBody PhoneBook phoneBook) {
        kafkaUserTemplate.send("phonebook-save-topic", phoneBook);
        return "PhoneBook published successfully";
    }

    @PutMapping("")
    public String updatePhoneBook(@RequestBody PhoneBook phoneBook) {
        if (phoneBook.getId() <= 0)
            return "PhoneBook Id cannot be null or 0";
        kafkaUserTemplate.send("phonebook-update-topic", phoneBook);
        return "PhoneBook upload published successfully";
    }

    @DeleteMapping("/{idPhonebook}")
    public String deletePhoneBook(@PathVariable("idPhonebook") int idPhoneBook) {
        kafkaIdPhoneBookTemplate.send("phonebook-delete-topic", idPhoneBook);
        return "PhoneBook delete published successfully";
    }
}
