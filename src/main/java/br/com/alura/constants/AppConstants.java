package br.com.alura.constants;

public abstract class AppConstants {

    private AppConstants(){}
    public static String URI_ABRIGOS = "http://localhost:8080/abrigos";
    public static String URI_PETS = "http://localhost:8080/abrigos/%s/pets";

    public static String TIT_ABRIG_CADASTR = "Abrigos cadastrados:";
    public static String TIT_PETS_CADASTR = "Pets cadastrados:";

    public static String MSG_N_ABRIG_CADASTR = "Não há abrigos cadastrados";
}
