package ar.edu.usal.utils;

import javax.xml.bind.ValidationException;

public enum OrientacionENUM {
    NORTE("NORTE", "NORTE"),
    SUR("SUR", "SUR"),
    ESTE("ESTE", "ESTE"),
    OESTE("OESTE", "OESTE");


    private final String key;
    private final String value;

    OrientacionENUM(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static OrientacionENUM getByDescription(String description) throws ValidationException {
        for (OrientacionENUM value : OrientacionENUM.values()) {
            if (value.key.equals(description)) {
                return value;
            }
        }
        throw new ValidationException("El codigo: " + description + " es incorrecto");
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}




