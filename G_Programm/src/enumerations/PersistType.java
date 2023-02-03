package enumerations;

import exception.GraphenException;

public enum PersistType{
    CSV("csv", "Comma-Seperated-File"),
    TXT("txt", "Text-File"),
    SER("ser", "Serialization");

    private String kurz;
    private String lang;

    private PersistType(String kurz, String lang){
        this.kurz = kurz;
        this.lang = lang;

    }

    public String getKurz(){
        return this.kurz;
    }


    public String getLang(){
        return this.lang;
    }

}
