package finishedScapeRoom.Inventory.Object;

import finishedScapeRoom.Exceptions.InventoryItemAlreadyExists;
import finishedScapeRoom.Exceptions.TopicNotFoundException;
import finishedScapeRoom.Inventory.InventoryManager;
import finishedScapeRoom.Room.RoomManager;

import static finishedScapeRoom.Helpers.InputHelper.*;
import static finishedScapeRoom.Room.RoomManager.getRoomIndex;

public class ObjectManager {


    //TODO ClueManager see ObjectManager
    public static String addObject() {
        String roomName, name;
        int roomIndex = -1;
        double rawPrice;
        Material material = null;

        roomName = InventoryManager.selectRoomWithInventory();
        roomIndex = getRoomIndex(roomName);
        name = inputString("Enter the object name: ");
        if (RoomManager.getInventoryItemIndex(roomIndex, name) != -1) {
            throw new InventoryItemAlreadyExists("The object: " + name + " already exists in room " + roomName);
        }
        material = requireValidMaterialForNewClue();
        rawPrice = inputDouble("Enter the raw price of the object: ");
        Object newObject = new Object(name, rawPrice, material);

        return RoomManager.addInventoryItem(roomIndex, newObject);
        }


    public static Material requireValidMaterialForNewClue() {
        String inputMaterial;
        Material material = null;
        Boolean found = false;
        do {
            inputMaterial = inputString("Materials are:\n" +
                    Material.showValues() +
                    "\nEnter the object material:");
            try {
                material = Material.findByValue(inputMaterial);
                found = true;
            } catch (TopicNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (!found);
        return material;
    }

}