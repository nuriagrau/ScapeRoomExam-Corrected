package finishedScapeRoom.Inventory;


public abstract class InventoryItem {

    protected int inventoryItemId;
    protected static int nextInventoryItemId;
    protected String name;
    protected double rawPrice;
    protected double price;


    public InventoryItem(String name, double rawPrice) {
        this.inventoryItemId = nextInventoryItemId;
        nextInventoryItemId++;
        this.name = name;
        this.rawPrice = rawPrice;
    }


    public int getId() {
        return this.inventoryItemId;
    }

    public String getName() {
        return this.name;
    }

    public double getRawPrice() {
        return this.rawPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setRawPricePrice(double rawPriceprice){
        this.rawPrice = rawPrice;
    }

    public abstract double priceCalculation(double rawPrice);

}
