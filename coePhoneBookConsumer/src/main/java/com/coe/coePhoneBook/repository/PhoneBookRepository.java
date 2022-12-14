package com.coe.coePhoneBook.repository;

import com.coe.coePhoneBook.entity.PhoneBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Integer> {
}
