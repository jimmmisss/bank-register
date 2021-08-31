package br.com.bank.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "professional_data")
public class ProfessionalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "occupation")
    private String occupation;
    @Column(name = "company")
    private String company;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
