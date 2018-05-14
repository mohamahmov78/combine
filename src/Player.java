import java.util.LinkedList;

public class Player {
    private int MagicPoint;
    private int HealthPoint;
    private Hand hand = new Hand();
    private GraveYard graveYard = new GraveYard();
    private PlayField playField = new PlayField();
    private int Gil;
    private LinkedList<CardCollection> playerCards = new LinkedList<>();
    private LinkedList<ItemCollection> playerItems = new LinkedList<>();
    private LinkedList<Amulet> amuletBag = new LinkedList<>();
    private Amulet equippedAmulet;
    private Deck deck = new Deck();
    public LinkedList<Amulet> getAmuletBag() {return amuletBag;}
    public Amulet getEquippedAmulet() {return equippedAmulet;}
    public void setEquippedAmulet (Amulet amulet) {equippedAmulet = amulet;}
    public Amulet getAmulet (String amuletName) {
        for (int i = 0; i < amuletBag.size(); i++)
        {
            if (amuletBag.get(i).getName().equals(amuletName))
                return amuletBag.get(i);
        }
        return null;
    }
    public void addAmulet (Amulet amulet) {
        if (getAmulet(amulet.getName()) == null)
            amuletBag.add(amulet);
    }
    public boolean removeAmulet (String amuletName) {
        if (getAmulet(amuletName) == null) {
            return false;
        }
        else {
            amuletBag.remove(getAmulet(amuletName));
            return true;
        }
    }
    public int getMP() {return MagicPoint;}
    public void setMP (int mp) {MagicPoint = mp;}
    public void addMP (int mp) {MagicPoint += mp;}
    public void subtractMP(int mp) {MagicPoint -= mp;}
    public int getHP () {return HealthPoint;}
    public void setHP (int HP) {HealthPoint = HP;}
    public void addHP (int HP) {HealthPoint += HP;}
    public boolean subtractHP (int HP)
    {
        if (HealthPoint > HP)
        {
            HealthPoint -= HP;
            return true;
        }
        else return false;
    }
    public int getGil () {return Gil;}
    public void setGil (int gil) {Gil = gil;}
    public boolean subtractGil (int gil)
    {
        if (Gil >= gil)
        {
            Gil -= gil;
            return true;
        }
        return false;
    }
    public void addGil (int gil) {Gil += gil;}
    public Deck getDeck() {return deck;}
    public boolean isInDeck (Card card)
    {
        for (int i = 0; i < deck.getDeckCards().size(); i++)
        {
            if (deck.getCard(card.getName()) != null)
                return true;
        }
        return false;
    }
    public LinkedList<CardCollection> getPlayerCards() {return playerCards;}
    public Card getCard (String cardName)
    {
        for (int i = 0; i < playerCards.size(); i++)
            if (playerCards.get(i).getCard().getName().equals(cardName))
                return playerCards.get(i).getCard();
        return null;
    }
    public CardCollection getCardCollection (String cardName)
    {
        for (int i = 0; i < playerCards.size(); i++)
            if (playerCards.get(i).getCard().getName().equals(cardName))
                return playerCards.get(i);
        return null;
    }
    public int getCardNumber (String cardName)
    {
        for (int i = 0; i < playerCards.size(); i++)
            if (playerCards.get(i).getCard().getName().equals(cardName))
                return playerCards.get(i).getNumber();
        return 0;
    }
    public boolean removePlayerCard (String cardName, int number)
    {
        if (getCardCollection(cardName).subtractNumber(number)) {
            if (getCardNumber(cardName) == 0)
                playerCards.remove(getCardCollection(cardName));
            return true;
        }
        return false;
    }
    public void addPlayerCard (Card card, int number)
    {
        boolean isAlreadyInPlayerCards = false;
        for (int i = 0; i < playerCards.size(); i++)
        {
            if (playerCards.get(i).getCard().equals(card))
            {
                playerCards.get(i).addNumber(number);
                isAlreadyInPlayerCards = true;
                break;
            }
        }
        if (!isAlreadyInPlayerCards)
        {
            playerCards.add(new CardCollection(card,number));
        }
    }
    public LinkedList<ItemCollection> getPlayerItems() {return playerItems;}
    public Item getItem (String itemName)
    {
        for (int i = 0; i < playerItems.size(); i++)
        {
            if (playerItems.get(i).getItem().getName().equals(itemName))
                return playerItems.get(i).getItem();
        }
        return null;
    }
    public ItemCollection getItemCollection (String itemName)
    {
        for (int i = 0; i < playerItems.size(); i++)
        {
            if (playerItems.get(i).getItem().getName().equals(itemName))
                return playerItems.get(i);
        }
        return null;
    }
    public int getItemNumber (String itemName)
    {
        for (int i = 0; i < playerItems.size(); i++)
        {
            if (playerItems.get(i).getItem().getName().equals(itemName))
                return playerItems.get(i).getNumber();
        }
        return 0;
    }
    public boolean removePlayerItem (String itemName, int number)
    {
        if (getItemCollection(itemName).subtractNumber(number))
        {
            if (getItemNumber(itemName) == 0)
                playerItems.remove(getItemCollection(itemName));
            return true;
        }
        return false;
    }
    public void addPlayerItem (Item item, int number)
    {
        boolean isAlreadyInPlayerItems = false;
        for (int i = 0; i < playerItems.size(); i++)
        {
            if (playerItems.get(i).getItem().equals(item))
            {
                isAlreadyInPlayerItems = true;
                playerItems.get(i).addNumber(number);
                break;
            }
        }
        if (!isAlreadyInPlayerItems)
            playerItems.add(new ItemCollection(item,number));
    }



}





























