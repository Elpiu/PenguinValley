package com.envy.penguinvalley.regex;


/**
 * Questa classe contiene le regex e i messaggi di errore per
 * i pattern delle entity @Pattern.
 */
public class REGEX {
/****************************************************ADMIN************************************************************/
    public static final String ADMIN_USERNAME_REGEX = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    public static final String ADMIN_USERNAME_MESSAGES =
            "Lunghezza 8-20, non inizia e finisce con '_' e '.', nessuna ripetizione di '_' e '.' in combinazione";

    public static final String ADMIN_PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    public static final String ADMIN_PASSWORD_MESSAGES =
            "Minimum eight characters, at least one letter, one number and one special character:";
    /***************************************************************************************************************/

    /****************************************************UTENTE************************************************************/

    public static final String UTENTE_EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String UTENTE_EMAIL_MESSAGES =
            "L'email inserita non è del formato corretto";

    /***************************************************************************************************************/




    /****************************************************Pinguino************************************************************/
    public static final String PINGUINO_NOME_REGEX = "^[^0-9][a-zA-Z0-9_ ]+$";
    public static final String PINGUINO_NOME_MESSAGES =
            "Il nome non può iniziare con un numero";

    /***************************************************************************************************************/

    public static final String LENGHT_2_50 = "^.{2,50}$";
    public static final String LENGHT_2_50_MESSAGES =
            "La lunghezza consentita è tra 2 e 50";


}
