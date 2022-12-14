package com.coe.coePhoneBook.repository;

import com.coe.coePhoneBook.entity.PhoneBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Integer> {
    List<PhoneBookEntity> findByCustomerIdId(int customerId);
    List<PhoneBookEntity> findByCustomerIdPhoneNumber(String customerIdPhoneNumber);
}
