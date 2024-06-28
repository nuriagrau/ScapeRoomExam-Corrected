package finishedScapeRoom.Room;

import finishedScapeRoom.Exceptions.DifficultyLevelNotFoundException;
import finishedScapeRoom.Exceptions.InventoryItemNotFound;
import finishedScapeRoom.Exceptions.RoomAlreadyExistsException;
import finishedScapeRoom.Inventory.Clue.Clue;
import finishedScapeRoom.Inventory.InventoryItem;

import java.util.ArrayList;

import static finishedScapeRoom.AppMenu.scapeRoomsList;
import static finishedScapeRoom.Helpers.InputHelper.inputString;

public class RoomManager {

    //TODO RoomManager
    public static String createANewRoom() {
        String name = "", inputlevel = "";
        boolean foundEnum = false;
        DifficultyLevel difficultyLevel = null;
        name = inputString("Enter the name of the new room: ");
        do {
            inputlevel = inputString("Enter the difficulty level (" + DifficultyLevel.showValues() + "): ");
            try {
                difficultyLevel = DifficultyLevel.findByValue(inputlevel);
                foundEnum = true;
            } catch (DifficultyLevelNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (!foundEnum);
        Room newRoom = new Room(name, difficultyLevel );
        return addRoom(newRoom);
    }

    //TODO RoomManager
    public static String addRoom(Room room) {
        int roomIndex = -1;
        String roomName = room.getName();
        if (scapeRoomsList.size() > 0) {
            roomIndex = getRoomIndex(roomName);
            if (roomIndex != -1) {
                throw new RoomAlreadyExistsException("The room: " + roomName + " already exists.");
            }
        }
        scapeRoomsList.add(room);
        return "The room " + roomName + " has been successfully created.";
    }

    //TODO RoomManager
    public static ArrayList<String> showRooms() {
        ArrayList rooms = new ArrayList<>();
        for (Room r : scapeRoomsList) {
            rooms.add(r.getName());
        }
        return rooms;
    }

    //TODO RoomManager
    public static int getRoomIndex(String name) {
        boolean found = false;
        int roomIndex = -1;
        if (scapeRoomsList.size() > 0 && !found) {
            for (int i = 0; i < scapeRoomsList.size(); i++) {
                if (scapeRoomsList.get(i).getName().equalsIgnoreCase(name)) {
                    roomIndex = i;
                    found = true;
                }
            }
        }
        return roomIndex;
    }


    //TODO RoomManager
    public static String addInventoryItem(int roomIndex, InventoryItem inventoryItem) {
        String roomName = scapeRoomsList.get(roomIndex).getName();
        scapeRoomsList.get(roomIndex).getInventory().add(inventoryItem);
        String itemType = (inventoryItem instanceof Clue)? "clue": "object";

        return "The " + itemType + " " + inventoryItem.getName() + " has been successfully created in room " + roomName ;
    }


    //TODO RoomManager
    public static String deleteInventoryItem(Room room, int inventoryItemIndex) {
        if (room.getInventory().isEmpty()) {
            throw new InventoryItemNotFound("This item does not exist.");
        }
        room.getInventory().remove(inventoryItemIndex);
        return "The item has been removed succesfully.";
    }

    public static int getInventoryItemIndex(int roomIndex, String inventoryItemName) {
        boolean found = false;
        int inventoryItemIndex = -1;
        if (!found) {
            for (int i = 0; i < scapeRoomsList.get(roomIndex).getInventory().size(); i++) {
                if (scapeRoomsList.get(roomIndex).getInventory().get(i).getName().equalsIgnoreCase(inventoryItemName)) {
                    inventoryItemIndex = i;
                    found = true;
                }
            }
        }
        return inventoryItemIndex;
    }

}
