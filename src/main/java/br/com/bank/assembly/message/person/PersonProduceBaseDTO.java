package br.com.bank.assembly.message.person;

import br.com.bank.enumeration.CardTypeEnum;
import br.com.bank.enumeration.GenderEnum;
import br.com.bank.enumeration.MaritalStatusEnum;
import br.com.bank.enumeration.SchoolingEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.LocalDateTime.ofInstant;

@Data
@SuperBuilder
@NoArgsConstructor
public class PersonProduceBaseDTO {

    private Long personBiroId;
    private String name;
    private String fiscalNumber;
    private String numberId;
    private String issuingAgencyNumberId;
    private String shippingDateNumberId;
    private LocalDate birthDate;
    private LocalDate paternalAffiliation;
    private LocalDate maternalAffiliation;
    private LocalDate nameSpouse;
    private LocalDate fiscalNumberSpouse;
    private Double monthlyIncome;
    private Double patrimony;
    private String password;
    private Boolean politicallyExposed;
    private GenderEnum gender;
    private MaritalStatusEnum maritalStatus;
    private SchoolingEnum schooling;
    private CardTypeEnum cardType;

    private String sourceOrigin;
    private String action;
    private LocalDateTime instant = ofInstant(Instant.now(), ZoneId.systemDefault());
}
