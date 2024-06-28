package finishedScapeRoom.Room;

import finishedScapeRoom.Exceptions.DifficultyLevelNotFoundException;
import java.util.Arrays;

public enum DifficultyLevel {

    VERYLOW("Very Low"), LOW("Low"), MEDIUM("Medium"), HIGH("High"), VERYHIGH("Very High");

    private final String value;

    private DifficultyLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DifficultyLevel findByValue(String value) {
        return Arrays.stream(values())
                .filter(difficultyLevel -> difficultyLevel.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new DifficultyLevelNotFoundException("Difficulty level not found for value: " + value));
    }

    public static String showValues() {
        return Arrays.toString(DifficultyLevel.values());
    }
}
