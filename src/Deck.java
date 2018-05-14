import java.util.LinkedList;

public class Deck
{
    private LinkedList<CardCollection> deckCards = new LinkedList<>();
    public int getCardNumber (String cardName)
    {
        for (int i = 0; i < deckCards.size(); i++) {
            if (deckCards.get(i).getCard().getName().equals(cardName))
                return deckCards.get(i).getNumber();
        }
        return 0;
    }
    public Card getCard (String cardName)
    {
        for (int i = 0; i < deckCards.size(); i++)
        {
            if (deckCards.get(i).getCard().getName().equals(cardName))
                return deckCards.get(i).getCard();
        }
        return null;
    }
    public CardCollection getCardCollection (String cardName)
    {
        for (int i = 0; i < deckCards.size(); i++)
        {
            if (deckCards.get(i).getCard().getName().equals(cardName))
                return deckCards.get(i);
        }
        return null;
    }
    public LinkedList<CardCollection> getDeckCards() {return deckCards;}
    public boolean removeDeckCard (String cardName, int number)
    {
        if (getCardCollection(cardName).subtractNumber(number))
        {
            if (getCardNumber(cardName) == 0)
                deckCards.remove(getCardCollection(cardName));
            return true;
        }
        return false;
    }
    public int deckCardNumber(String cardName)
    {
        int number = 0;
        for (int i = 0; i < deckCards.size(); i++)
        {
            if (deckCards.get(i).getCard().getName().equals(cardName))
                number += deckCards.get(i).getNumber();
        }
        return number;
    }
    public void addDeckCard (Card card, int number)
    {
        if () {
            boolean isAlreadyInDeckCards = false;
            for (int i = 0; i < deckCards.size(); i++) {
                if (deckCards.get(i).getCard().equals(card)) {
                    deckCards.get(i).addNumber(number);
                    isAlreadyInDeckCards = true;
                    break;
                }
            }
            if (!isAlreadyInDeckCards) {
                deckCards.add(new CardCollection(card, number));
            }
        }
    }
}
