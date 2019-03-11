package net.marco27.api.customerxml.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@JacksonXmlRootElement(localName = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty
    @Column(name = "firstname")
    private String firstname;

    @JacksonXmlProperty
    @Column(name = "lastname")
    private String lastname;

    @JacksonXmlProperty
    @Column(name = "age")
    private int age;

    public Customer() {
    }

    public Customer(Long id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
