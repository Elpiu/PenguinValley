package com.envy.penguinvalley.regex;


/**
 * Questa classe contiene le regex e i messaggi di errore per
 * i pattern delle entity @Pattern.
 */
public class REGEX {

    /****************************************************User************************************************************/
    public static final String USER_USERNAME_REGEX = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    public static final String USER_USERNAME_MESSAGES =
            "Lunghezza 8-20, non inizia e finisce con '_' e '.', nessuna ripetizione di '_' e '.' in combinazione";

    public static final String USER_PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    public static final String USER_PASSWORD_MESSAGES =
            "Minimum eight characters, at least one letter, one number and one special character:";
    /***************************************************************************************************************/



    public static final String LENGHT_2_50 = "^.{2,50}$";
    public static final String LENGHT_2_50_MESSAGES =
            "La lunghezza consentita è tra 2 e 50";


}
