package br.com.bank.entity;

import br.com.bank.enumeration.AddressTypeEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "number")
    private Integer number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "neighborhood")
    private String neighborhood;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_address")
    private AddressTypeEnum typeAddress;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}