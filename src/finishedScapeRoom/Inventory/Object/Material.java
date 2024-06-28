package finishedScapeRoom.Inventory.Object;

import finishedScapeRoom.Exceptions.MaterialNotFoundException;


import java.util.Arrays;

public enum Material {

    WOOD("Wood"), METAL("Metal"), GLASS("Glass"), PLASTIC("Plastic"), TEXTILE("Textile"), PLANT("Plant"), CARDBOARD("Cardboard"), PAPER("Paper"), LATEX("Latex");

    private final String value;

    private Material(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    //TODO el mismo caso que en DifficulLevel
    public static Material findByValue(String value) {
        return Arrays.stream(values())
                .filter(material -> material.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new MaterialNotFoundException("Material not found for value: " + value));
    }

    public static String showValues() {
        return Arrays.toString(Material.values());
    }

}
