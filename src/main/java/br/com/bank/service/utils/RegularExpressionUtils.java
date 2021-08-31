package br.com.bank.service.utils;

public abstract class RegularExpressionUtils {

    private RegularExpressionUtils() {
        super();
    }

    public static String validZipCode(String zipCode) {
        String noSpaces = zipCode.replaceAll("[\\s]", "");
        return noSpaces.replaceAll("[^0-9]", "");
    }
}
