public class Amulet {
    private String name;
    private int cost;
    private String amuletDetails;
    public String getName() {return name;}
    public int getCost() {return cost;}
    public String getAmuletDetails() {return amuletDetails;}
    public boolean equals(Amulet amulet) {return name.equals(amulet.name);}
    @Override
    public String toString() {return name;}
}
