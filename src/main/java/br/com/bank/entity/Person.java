package br.com.bank.entity;

import br.com.bank.enumeration.CardTypeEnum;
import br.com.bank.enumeration.GenderEnum;
import br.com.bank.enumeration.MaritalStatusEnum;
import br.com.bank.enumeration.SchoolingEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "person_biro_id")
    private Long personBiroId;
    @Column(name = "name")
    private String name;
    @Column(name = "fiscal_number")
    private String fiscalNumber;
    @Column(name = "number_id")
    private String numberId;
    @Column(name = "issuing_agency")
    private String issuingAgencyNumberId;
    @Column(name = "shipping_date")
    private String shippingDateNumberId;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "paternal_affiliation")
    private LocalDate paternalAffiliation;
    @Column(name = "maternal_affiliation")
    private LocalDate maternalAffiliation;
    @Column(name = "name_spouse")
    private LocalDate nameSpouse;
    @Column(name = "fiscal_number_spouse")
    private LocalDate fiscalNumberSpouse;
    @Column(name = "monthly_income")
    private Double monthlyIncome;
    @Column(name = "patrimony")
    private Double patrimony;
    @Column(name = "password")
    @Size(min = 6, max = 16)
    private String password;
    @Column(name = "politically_exposed")
    private Boolean politicallyExposed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatusEnum maritalStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "schooling")
    private SchoolingEnum schooling;
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardTypeEnum cardType;
}
