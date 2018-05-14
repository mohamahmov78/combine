import java.util.LinkedList;

public class Hand {
    private LinkedList<Card> HandCards = new LinkedList<>();
    public void addHandCard (Card card) {HandCards.add(card);}
    public boolean removeHandCard (Card card)
    {
        if (HandCards.contains(card)) {
            HandCards.remove(card);
            return true;
        }
        return false;
    }
    public LinkedList<Card> getHandCards () {return HandCards;}
}
