import java.util.LinkedList;

public class texts {
    public static String GameOver() {return "You are out of Mystic Hourglass\nGame Over!\n";}

    public static String EndFight_Help() {
        return
                "1.  Enter Shop: To enter shop and buy or sell cards, items and amulets\n" +
                        "2.  Edit Inventory: To edit your amulet or deck\n" +
                        "3.  Next: To go to deck and amulet customization\n";
    }

    public static String EnterShop_Help() {
        return "1.  Card Shop\n" +
                        "2.  Item Shop\n" +
                        "3.  Amulet Shop\n" +
                        "4.  Exit\n";
    }

    public static String CardShop(LinkedList<CardCollection> shopCards, LinkedList<CardCollection> playerCards, Deck deck) {
        StringBuilder Return = new StringBuilder();
        Return.append("  Shop List:\n");
        for (int i = 0; i < shopCards.size(); i++)
            Return.append(i+1 + ". \"" + shopCards.get(i).getCard().getName() + "\" " + shopCards.get(i).getCard().getCost() + "\n");
        Return.append("  Card Inventory:\n");
        for (int i = 0; i < playerCards.size(); i++)
            Return.append(i+1 + ". " + playerCards.get(i).getNumber() + "\"" + playerCards.get(i).getCard().getName() + "\" / " + deck.getCardNumber(playerCards.get(i).getCard().getName()) + " on deck\n");
        return Return.toString();
    }

    public static String CardShop_Help() {
        return "1.  Buy \"Card Name\" - #NumberToBuy: To buy a certain number of a card from shop\n" +
                "2.  Sell \"Card Name\" - #NumberToSell: To sell a certain number of a card from inventory\n" +
                "3.  Info \"Card Name\": To get more information about a card\n" +
                "4.  Exit: To return to shop menu\n";
    }

    public static String CardInfo(Card card) throws Exception {
        if (card instanceof MonsterCard) {
            return card.getName() + " Info:\n" +
                    "Name: " + card.getName() +
                    "\nHP: " + ((MonsterCard) card).getHP() +
                    "\nAP: " + ((MonsterCard) card).getAP() +
                    "\nMP cost: " + card.getMPcost() +
                    "\nCard Type: " + ((MonsterCard) card).getMonsterCardType() +
                    "\nCard Tribe: " + ((MonsterCard) card).getMonsterCardTribe() +
                    "\nIs Defensive: " + ((MonsterCard) card).getIsDefensive() +
                    "\nIS Nimble: " + ((MonsterCard) card).getIsNimble() + "\n" +
                    ((card instanceof SpellCasterCard) ? ("Spell Details:'\n" + ((SpellCasterCard) card).getSpellDetails() + "\n") : ("")) +
                    ((card instanceof HeroCard) ? ("Spell Details:'\n" + ((HeroCard) card).getSpellDetails() + "\n") : ("")) +
                    ((card instanceof HeroCard) ? ("BattleCry Details:'\n" + ((HeroCard) card).getBattleCryDetails() + "\n") : ("")) +
                    ((card instanceof GeneralCard) ? ("BattleCry Details:'\n" + ((GeneralCard) card).getBattleCryDetails() + "\n") : ("")) +
                    ((card instanceof GeneralCard) ? ("Will Details:'\n" + ((GeneralCard) card).getWillDetails() + "\n") : ("")) +
                    ((card instanceof HeroCard) ? ("Will Details:'\n" + ((HeroCard) card).getWillDetails() + "\n") : (""));
        } else if (card instanceof SpellCard) {
            return card.getName() + "Info: \n" +
                    "Name: " + card.getName() +
                    "\nMP cost: " + card.getMPcost() +
                    "\nCard Type: " + ((SpellCard) card).getSpellCardType() +
                    "\nSpell Details: " + ((SpellCard) card).getSpellDetails() + "\n";
        }
        throw new Exception("neither SpellCard nor MonsterCard");
    }

    public static String ItemShop(LinkedList<Item> shopItems, LinkedList<ItemCollection> playerItems) {
        StringBuilder Return = new StringBuilder();
        Return.append("  Shop List:\n");
        for (int i = 0; i < shopItems.size(); i++)
            Return.append(i+1 + ". \"" + shopItems.get(i) + "\" " + shopItems.get(i).getCost() + "\n");
        Return.append("  Item Inventory:\n");
        for (int i = 0; i < playerItems.size(); i++)
            Return.append(i+1 + ". " + playerItems.get(i).getNumber() + " \"" + playerItems.get(i).getItem() + "\"\n");
        return Return.toString();
    }

    public static String ItemShop_Help() {
        return "1.  Buy \"Item Name\" - #NumberToBuy: To buy an item from the shop\n" +
                "2.  Sell \"Item Name\" - #NumberToSell: To sell an item from your item inventory\n" +
                "3.  Info \"Item Name\": To view the full information of the item\n" +
                "4.  Exit: To exit back to the shop menu\n";
    }

    public static String AmuletShop(LinkedList<Amulet> shopAmulets, Player player) {
        StringBuilder Return = new StringBuilder();
        Return.append("  Shop List:\n");
        for (int i = 0; i < shopAmulets.size(); i++)
            Return.append(i+1 + ". \"" + shopAmulets.get(i) + "\" " + shopAmulets.get(i).getCost() + "\n");
        if (player.getEquippedAmulet() != null)
            Return.append("Equipped Amulet: \"" + player.getEquippedAmulet() + "\"\n");
        Return.append("  Amulet Inventory:\n");
        for (int i = 0; i < player.getAmuletBag().size(); i++)
            Return.append(i+1 + ".  \"" + player.getAmuletBag().get(i) + "\"\n");
        return Return.toString();
    }

    public static String AmuletShop_Help() {
        return "1. Buy \"Amulet Name\" - #NumberToBuy: To buy a number of an amulet from the shop\n" +
                "2. Sell \"Amulet Name\" - #NumberToSell: To sell a number of an amulet from amulet inventory\n" +
                "3. Info \"Amulet Name\": To get full info on an amulet\n" +
                "4. Exit: To exit to the shop menu\n";
    }

    public static String EditInventory_Help() {
        return "1. Card Inventory: To view your cards\n" +
                "2. Item Inventory: To view your items\n" +
                "3. Amulet Inventory: To view your amulets\n" +
                "4. Edit Deck: To edit your card deck\n" +
                "5. Edit Amulets: To equip or remove your amulets\n" +
                "6. Exit: To exit to previous menu\n";
    }

    public static String CardInventory(Player player) {
        StringBuilder Return = new StringBuilder();
        Return.append("Card Inventory:\n");
        for (int i = 0; i < player.getPlayerCards().size(); i++)
        {
            Return.append(i+1 + ". " + player.getPlayerCards().get(i).getNumber() + " \"" + player.getPlayerCards().get(i).getCard() + "\" / " + player.getDeck().getCardNumber(player.getPlayerCards().get(i).getCard().getName()) + " on deck\n");
        }
        return Return.toString();
    }

    public static String ItemInventory(LinkedList<ItemCollection> itemCollections) {
        StringBuilder Return = new StringBuilder();
        Return.append("Item Inventory:\n");
        for (int i = 0; i < itemCollections.size(); i++)
        {
            Return.append(i+1 + ". " + itemCollections.get(i).getNumber() + " \"" + itemCollections.get(i).getItem() + "\"\n");
        }
        return Return.toString();
    }

    public static String AmuletInventory(LinkedList<Amulet> amulets) {
        StringBuilder Return = new StringBuilder();
        Return.append("Amulet Inventory:\n");
        for (int i = 0; i < amulets.size(); i++)
        {
            Return.append(i+1 + ". \"" + amulets.get(i) + "\"\n");
        }
        return Return.toString();
    }

    public static String EditDeck_Help() {
        return "------Edit Deck\n" +
                "1. Add \"Card Name\" #CardNum: To add cards to your deck\n" +
                "2. Remove \"Card Name\" #CardNum: To remove cards from your deck\n" +
                "3. Info \"Card Name\": To get more information about a specific card\n" +
                "4. Exit: To return to the previous section\n";
    }
}
