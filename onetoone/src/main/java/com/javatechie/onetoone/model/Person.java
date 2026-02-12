package com.javatechie.onetoone.model;



import com.javatechie.onetoone.model.AadhaarCard;
import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 50)
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id", referencedColumnName = "id")
    private AadhaarCard aadhaarCard;


    public Person() {}



    public Person(String name, AadhaarCard aadhaarCard) {
        this.name = name;
        this.aadhaarCard = aadhaarCard;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public AadhaarCard getAadhaarCard() { return aadhaarCard; }
    public void setAadhaarCard(AadhaarCard aadhaarCard) { this.aadhaarCard = aadhaarCard; }
}