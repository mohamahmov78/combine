public class ItemCollection {
    private Item item;
    private int number;
    public ItemCollection (Item item, int number)
    {
        this.item = item;
        this.number = number;
    }
    public int getNumber () {return number;}
    public Item getItem() {return item;}
    public void addNumber (int number) {this.number += number;}
    public boolean subtractNumber (int number)
    {
        if (this.number >= number) {
            this.number -= number;
            return true;
        }
        return false;
    }
}
