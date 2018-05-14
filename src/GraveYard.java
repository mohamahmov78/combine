
import java.util.LinkedList;

public class GraveYard {
    private LinkedList<Card> GYCards = new LinkedList<Card>();
    public void addToGraveYard (Card card)
    {
        GYCards.add(card);
    }
    public boolean removeFromGraveYard (Card card)
    {
        if (GYCards.contains(card))
        {
            GYCards.remove(card);
            return true;
        }
        return false;
    }
}
