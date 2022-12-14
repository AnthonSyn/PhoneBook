package com.coe.coePhoneBook.entity;
import com.coe.coePhoneBook.kafkaproducer.model.PhoneBook;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="phone_book")
public class PhoneBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="my_contact_id", referencedColumnName = "id", nullable = false)
    private Customer myContactId;

    @Column(name="nickname")
    private String nickname;

    @Column(name="create_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;

    @Column(name="update_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateDate;


    public PhoneBookEntity(){

    };

    public PhoneBookEntity(PhoneBook phoneBook){
        this.id = phoneBook.getId();
        this.customerId = phoneBook.getCustomerId();
        this.myContactId = phoneBook.getMyContactId();
        this.nickname = phoneBook.getNickName();
        this.createDate = phoneBook.getCreateDate();
        this.updateDate = phoneBook.getUpdateDate();
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        return "PhoneBookEntity{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", myContactId=" + myContactId +
                ", nickname='" + nickname + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }


    public void updateEntity(PhoneBook phoneBook){
        this.nickname = phoneBook.getNickName();
        this.updateDate = phoneBook.getCreateDate();
        this.createDate = phoneBook.getUpdateDate();

    }
}
