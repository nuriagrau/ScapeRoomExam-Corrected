package finishedScapeRoom.Inventory;

import finishedScapeRoom.Exceptions.EmptyRoomException;
import finishedScapeRoom.Exceptions.InventoryItemNotFound;
import finishedScapeRoom.Exceptions.RoomNotFoundException;
import finishedScapeRoom.Room.Room;
import finishedScapeRoom.Room.RoomManager;

import static finishedScapeRoom.AppMenu.scapeRoomsList;
import static finishedScapeRoom.InputHelper.inputString;
import static finishedScapeRoom.Room.RoomManager.getRoomIndex;
import static finishedScapeRoom.Room.RoomManager.showRooms;

public class InventoryManager {

    //TODO InventoryManager.
    public static String removeInventoryItem() {
        String roomName, inventoryItemName;
        int roomIndex, inventoryItemIndex = -1;
        roomName = selectRoomWithInventory();
        roomIndex = getRoomIndex(roomName);
        Room thisRoom = scapeRoomsList.get(roomIndex);
        do {
            inventoryItemName = inputString(getInventory(roomName, roomIndex) +
                    "Enter the element name to remove: ");
            inventoryItemIndex= thisRoom.getElementIndex(inventoryItemName);
            if (inventoryItemIndex == -1) {
                throw new InventoryItemNotFound("This item does not exist in this room.");
            }
        } while ((inventoryItemIndex) == -1);

        return (RoomManager.deleteInventoryItem(thisRoom, inventoryItemIndex));
    }

    //TODO InventoryManager. Refactorizar
    public static String showInventory() {
        String roomName;
        roomName = inputString("The following rooms have been created: \n"
                + showRooms().toString() + "\nEnter the room to show its inventory: ");
        int roomIndex = getRoomIndex(roomName);
        if (roomIndex == -1) {
            throw new RoomNotFoundException("The room: " + roomName + " does not exist.");
        }
        return getInventory(roomName, roomIndex);
    }


    //TODO
    public static String selectRoomWithInventory() {
        String roomName;
        int roomIndex;

        do {
            roomName = inputString("The following rooms have been created: \n" + showRooms() + "\nEnter the room to show its inventory: ");
            roomIndex = getRoomIndex(roomName);
            if (roomIndex == -1) {
                throw new RoomNotFoundException("This room does not exist. Enter a valid room name.");
            }
        } while (roomIndex == -1);

        return roomName;

    }

    //TODO InventoryManager
    public static String getInventory(String roomName, int roomIndex) {
        String inventory = "The inventory for room " + roomName + " is:\n";
        Room thisRoom = scapeRoomsList.get(roomIndex);
        if (thisRoom.getInventory().isEmpty()) {
            //TODO exception customize
            throw new EmptyRoomException("The room " + roomName + " is empty.\n");
        }
        for (InventoryItem e : thisRoom.getInventory()){
            inventory = inventory  + e.toString();
        }
        //TODO toString()? override toString() here calls calculateTotalValue()
        return thisRoom +  inventory;
    }

}
