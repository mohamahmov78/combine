public abstract class Card {
    private int MPcost = -1;
    private String Name = null;
    private int Cost = -1;
    public String getName () {return Name;}
    public void setName (String name) {Name = name;}
    public int getMPcost () {return MPcost;}
    public void setMPcost (int MPcost)
    {
        this.MPcost = MPcost;
        Cost = 700 * MPcost;
    }
    public void setCost (int cost) {this.Cost = cost;}
    public int getCost () {return Cost;}
    public boolean equals (Card card) {return Name.equals(card.Name);}
    @Override
    public String toString() {return Name;}
}
