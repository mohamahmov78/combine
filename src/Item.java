public class Item {
    private String name;
    private int cost;
    private String itemDetails;
    public String getName() {return name;}
    public int getCost() {return cost;}
    public String getItemDetails() {return itemDetails;}
    public boolean equals(Item item) {return name.equals(item.name);}
    @Override
    public String toString() {return name;}
}
