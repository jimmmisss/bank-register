package br.com.bank.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatusEnum {

    NOT_MARRIED, MARRIED, SEPARATE, DIVORCED, WIDOWER, STABLE_UNION;
}
