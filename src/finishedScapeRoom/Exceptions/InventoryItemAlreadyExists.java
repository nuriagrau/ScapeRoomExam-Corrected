package finishedScapeRoom.Exceptions;

public class InventoryItemAlreadyExists extends RuntimeException{

    public InventoryItemAlreadyExists(String message) {
        super(message);
    }
}
