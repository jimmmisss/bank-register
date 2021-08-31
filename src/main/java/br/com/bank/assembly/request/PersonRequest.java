package br.com.bank.assembly.request;

import br.com.bank.enumeration.CardTypeEnum;
import br.com.bank.enumeration.GenderEnum;
import br.com.bank.enumeration.MaritalStatusEnum;
import br.com.bank.enumeration.SchoolingEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class PersonRequest {

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

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;
    @Enumerated(EnumType.STRING)
    private SchoolingEnum schooling;
    @Enumerated(EnumType.STRING)
    private CardTypeEnum cardType;
}
