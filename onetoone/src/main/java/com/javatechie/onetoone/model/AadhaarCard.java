package com.javatechie.onetoone.model;


import jakarta.persistence.*;

@Entity
@Table(name = "aadhaar_card")
public class AadhaarCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 12)
    private String aadhaarNumber;


    @Column(nullable = false, length = 50)
    private String address;


    public AadhaarCard() {}


    public AadhaarCard(String aadhaarNumber, String address) {
        this.aadhaarNumber = aadhaarNumber;
        this.address = address;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
