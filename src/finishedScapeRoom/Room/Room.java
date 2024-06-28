package finishedScapeRoom.Room;

import finishedScapeRoom.Inventory.InventoryItem;

import java.util.ArrayList;

public class Room {

    private int roomId;
    private static int nextRoomId = 1;
    private String name;
    private DifficultyLevel difficultyLevel;
    private double totalValue;
    private ArrayList<InventoryItem> inventoryList;

    public Room(String name, DifficultyLevel difficultyLevel){
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.roomId = nextRoomId;
        nextRoomId++;
        this.inventoryList = new ArrayList<>();
    }

    public int getId() {
        return this.roomId;
    }

    public String getName() {
        return this.name;
    }

    public double getTotalValue() {
        return this.totalValue;
    }

    public ArrayList<InventoryItem> getInventory(){
        return this.inventoryList;
    }

    public DifficultyLevel getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = Enum.valueOf(DifficultyLevel.class, difficultyLevel);
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double totalValueCalculation(){
        double totalPrice = 0;
        for (InventoryItem ii : this.inventoryList) {
            totalPrice = totalPrice + ii.priceCalculation(ii.getRawPrice());
        }
        return totalPrice;
    }


    public int getElementIndex(String name) {
        boolean found = false;
        int elementIndex = -1;
        if (!inventoryList.isEmpty() && !found) {
            for (int i = 0; i < inventoryList.size(); i++) {
                if (inventoryList.get(i).getName().equalsIgnoreCase(name)) {
                    elementIndex = i;
                    found = true;
                }
            }
        }
        return elementIndex;
    }

    @Override
    public String toString() {
        return "Room [name= " + this.name + ", difficultyLevel= " + this.difficultyLevel + ", totalValue= " + this.totalValueCalculation() + "]\n";
    }


}
