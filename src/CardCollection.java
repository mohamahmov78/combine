public class CardCollection {
    private Card card;
    private int number;
    public CardCollection (Card card, int number)
    {
        this.card = card;
        this.number = number;
    }
    public int getNumber() {return number;}
    public Card getCard() {return card;}
    public boolean subtractNumber (int number)
    {
        if (number <= this.number)
        {
            this.number -= number;
            return true;
        }
        return false;
    }
    public void addNumber (int number) {this.number += number;}
}
