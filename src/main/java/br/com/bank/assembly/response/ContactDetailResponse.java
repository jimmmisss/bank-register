package br.com.bank.assembly.response;

import lombok.Data;

@Data
public class ContactDetailResponse {

    private Long id;
    private String email;
    private String emailSecondary;
    private String phone;
    private String phoneSecondary;
    private PersonResponse person;
}
