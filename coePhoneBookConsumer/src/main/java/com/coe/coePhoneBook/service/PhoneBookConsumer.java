package com.coe.coePhoneBook.service;

import com.coe.coePhoneBook.entity.PhoneBookEntity;
import com.coe.coePhoneBook.kafkaproducer.model.PhoneBook;
import com.coe.coePhoneBook.repository.PhoneBookRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;


@Service
public class PhoneBookConsumer {



    @Autowired
    private PhoneBookRepository phoneBookRepository;


    @KafkaListener(topics = "phonebook-save-topic", groupId = "group-json")
    public void savePhoneBook(ConsumerRecord<Long, PhoneBook> record) throws IOException{
                PhoneBook phoneBook = record.value();
                phoneBook.setCreateDate(new Date());
                PhoneBookEntity entity = new PhoneBookEntity(phoneBook);
                phoneBookRepository.save(entity);
    }

    @KafkaListener(topics = "phonebook-update-topic", groupId = "group-json")
    public void updatePhoneBook(ConsumerRecord<Long, PhoneBook> record) throws IOException{
            PhoneBook phoneBook = record.value();
            PhoneBookEntity phoneBookEntity = phoneBookRepository.findById(phoneBook.getId()).get();
            phoneBookEntity.updateEntity(phoneBook);
            phoneBookRepository.save(phoneBookEntity);
    }

    @KafkaListener(topics = "phonebook-delete-topic", groupId = "group-json")
    public void deletePhoneBook(ConsumerRecord<Long, Integer> record) throws IOException{
        phoneBookRepository.deleteById(record.value());
    }





}












