import java.util.LinkedList;

public class Shop
{
    private LinkedList<CardCollection> shopCards = new LinkedList<>();
    private LinkedList<Item> items = new LinkedList<>();
    private LinkedList<Amulet> amulets = new LinkedList<>();
    public LinkedList<CardCollection> getShopCards() {return shopCards;}
    public void addShopCard (Card card, int number) {
        boolean isAlreadyInShopCards = false;
        for (int i = 0; i < shopCards.size(); i++) {
            if (shopCards.get(i).getCard().equals(card)) {
                shopCards.get(i).addNumber(number);
                isAlreadyInShopCards = true;
                break;
            }
        }
        if (!isAlreadyInShopCards)
            shopCards.add(new CardCollection(card,number));
    }
    public boolean removeShopCard (String cardName, int number) {
        if (getCardCollection(cardName).subtractNumber(number))
        {
            if (getCardNumber(cardName) == 0)
                shopCards.remove(getCardCollection(cardName));
            return true;
        }
        return false;
    }
    public int getCardNumber (String cardName) {
        for (int i = 0; i < shopCards.size(); i++)
            if (shopCards.get(i).getCard().getName().equals(cardName))
                return shopCards.get(i).getNumber();
        return 0;
    }
    public Card getCard (String cardName) {
        for (int i = 0; i < shopCards.size(); i++)
        {
            if (shopCards.get(i).getCard().getName().equals(cardName))
                return shopCards.get(i).getCard();
        }
        return null;
    }
    public CardCollection getCardCollection (String cardName) {
        for (int i = 0; i < shopCards.size(); i++)
        {
            if (shopCards.get(i).getCard().getName().equals(cardName))
                return shopCards.get(i);
        }
        return null;
    }
    public LinkedList<Item> getItems() {return items;}
    public Item getItem (String itemName) {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(itemName))
                return items.get(i);
        }
        return null;
    }
    public LinkedList<Amulet> getAmulets() {return amulets;}
    public Amulet getAmulet (String amuletName) {
        for (int i = 0; i < amulets.size(); i++)
        {
            if (amulets.get(i).getName().equals(amuletName))
                return amulets.get(i);
        }
        return null;
    }
}
