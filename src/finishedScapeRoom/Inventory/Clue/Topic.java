package finishedScapeRoom.Inventory.Clue;

import finishedScapeRoom.Exceptions.TopicNotFoundException;

import java.util.Arrays;

public enum Topic {
    STEAMPUNK("SteamPunk"),
    FUTURE("Future"),
    ESPIONAGE("Espionage");

    private final String value;

    private Topic(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static Topic findByValue(String value) {
        return Arrays.stream(values())
                .filter(topic -> topic.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new TopicNotFoundException("Topic not found for value: " + value));
    }

    public static String showValues() {
        return Arrays.toString(Topic.values());
    }

}
