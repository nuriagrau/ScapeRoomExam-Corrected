package finishedScapeRoom.Inventory.Clue;

import finishedScapeRoom.Exceptions.InventoryItemAlreadyExists;
import finishedScapeRoom.Exceptions.TopicNotFoundException;
import finishedScapeRoom.Inventory.InventoryManager;
import finishedScapeRoom.Room.RoomManager;

import static finishedScapeRoom.InputHelper.*;
import static finishedScapeRoom.Room.RoomManager.getRoomIndex;

public class ClueManager {

    //TODO ClueManager
    public static String addClue() {
        String roomName = "", name = "";
        double rawPrice;
        Topic topic = null;
        int roomIndex = -1, estimatedTimeInSeconds;

        roomName = InventoryManager.selectRoomWithInventory();
        roomIndex = getRoomIndex(roomName);
        name = inputString("Enter the clue name: ");
        if (RoomManager.getInventoryItemIndex(roomIndex, name) != -1) {
            throw new InventoryItemAlreadyExists("The clue: " + name + " already exists in room " + roomName);
        }
        topic = requireValidTopicForNewClue();
        estimatedTimeInSeconds = inputInt("Enter the estimated resolution time in seconds: ");
        rawPrice = inputDouble("Enter the raw price of the clue: ");
        Clue newClue = new Clue(name, rawPrice, topic, estimatedTimeInSeconds);

        return RoomManager.addInventoryItem(roomIndex, newClue);
    }


    public static Topic requireValidTopicForNewClue() {
        String inputTopic;
        Topic topic = null;
        Boolean found = false;
        do {
            inputTopic = inputString("Topics are:\n" +
                    Topic.showValues() +
                    "\nEnter the clue topic:");
            try {
                topic = Topic.findByValue(inputTopic);
                found = true;
            } catch (TopicNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (!found);
        return topic;
    }

}
