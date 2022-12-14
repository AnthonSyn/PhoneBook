package com.coe.coePhoneBook.kafkaproducer.model;

import com.coe.coePhoneBook.entity.Customer;
import com.coe.coePhoneBook.entity.PhoneBookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PhoneBook implements Serializable {

    private int id;

    private Customer customerId;

    private Customer myContactId;

    private String nickName;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    @JsonFormat(pattern= "yyyy-MMM-dd hh:mm:ss")
    private Date updateDate;

    public PhoneBook(){

    }

    public PhoneBook(PhoneBookEntity entity){
        this.id = entity.getId();
        this.myContactId = entity.getMyContactId();
        this.customerId = entity.getCustomerId();
        this.nickName = entity.getNickname();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Customer getMyContactId() {
        return myContactId;
    }

    public void setMyContactId(Customer myContactId) {
        this.myContactId = myContactId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", myContactId=" + myContactId +
                ", nickName='" + nickName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
