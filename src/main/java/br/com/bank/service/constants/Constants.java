package br.com.bank.service.constants;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constant class");
    }

    public static final String ENTITY_IN_USE = "%s de código %d não pode ser removida, pois está em uso";
    public static final String ENTITY_NOT_FOUND = "%s não encontrado(a), ID: %d";
    public static final String USER_LOGGED_NOT_FOUND = "Não existe usuário logado";
    public static final String ENTITIES_NOT_FOUND = "%s não encontrado(a), ID: %d";

    public static final String NATURALNESS = "Naturalidade";
    public static final String ADDRESS = "Endereço";
    public static final String FILE_STORAGE = "Documento com foto";
    public static final String PHYSICAL_PERSON = "Pessoa física";
    public static final String PROFESSIONAL_DATA = "Dados profissionais";
    public static final String CONTACT_DETAIL = "Detalhe de contato";

    public static final String PERSON_PRODUCER = "PERSON";

    // MESSAGE
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

}
