package ar.edu.usal.persistencia.enums;

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

    public static OrientacionENUM getByDescription(String description) throws Exception {
        for (OrientacionENUM value : OrientacionENUM.values()) {
            if (value.key.equals(description)) {
                return value;
            }
        }
        throw new Exception("La orientacion: " + description + " no es valida.");
    }

}




