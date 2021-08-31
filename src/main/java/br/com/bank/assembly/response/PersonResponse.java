package br.com.bank.assembly.response;

import br.com.bank.enumeration.CardTypeEnum;
import br.com.bank.enumeration.GenderEnum;
import br.com.bank.enumeration.MaritalStatusEnum;
import br.com.bank.enumeration.SchoolingEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class PersonResponse {

    private Long id;
    private String idNumber;
    private String name;
    private String fiscalNumber;
    private LocalDate birthDate;
    private String phoneNumberPrivate;
    private Double patrimony;
    private Boolean politicallyExposed;
    private String companyName;
    private String companyOccupation;
    private Double monthlyIncome;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;
    @Enumerated(EnumType.STRING)
    private SchoolingEnum schooling;
    @Enumerated(EnumType.STRING)
    private CardTypeEnum cardType;
}
