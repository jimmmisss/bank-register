package br.com.bank.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contact_detail")
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
