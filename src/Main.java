import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Play play = new Play();
        Print print = new Print();
        print.setPlay(play);
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        d: while (true) //beginning Game
        {
            
            //game
            String Input;
            b:while (true) //after game
            {
                print.print(texts.EndFight_Help());
                Input = input.nextLine();
                if (Input.equals("Help"))
                {
                    print.print(texts.EndFight_Help());
                    continue;
                }
                if (Input.equals("Again"))
                {
                    System.out.println(print.getLastPrints());
                    continue;
                }
                if (Input.equals("Enter Shop"))
                {
                    print.setInShop(true);
                    a:do //in Shop
                    {
                        print.print("---Shop");
                        Input = input.nextLine();
                        if (Input.equals("Card Shop"))
                            do //in card shop
                            {
                                System.out.println("------Card Shop");
                                print.print(texts.CardShop(shop.getShopCards(),play.player1.getPlayerCards(),play.player1.getDeck()));
                                Input = input.nextLine();
                                if (Input.equals("Help")) {
                                    print.print(texts.CardShop_Help());
                                    continue;
                                }
                                if (Input.startsWith("Buy"))
                                {
                                    String cardName = Input.substring(4);
                                    System.out.println("How many " + cardName + " cards do you want to buy?");
                                    int cardNumber = input.nextInt();
                                    input.nextLine();
                                    if (shop.getCard(cardName).getCost() * cardNumber <= play.player1.getGil()) {
                                        if (shop.removeShopCard(cardName, cardNumber)) { //cards bought
                                            play.player1.addPlayerCard(shop.getCard(cardName),cardNumber);
                                            System.out.println("Successfully bought " + cardNumber + " of \"" + cardName + "\"!");
                                            play.player1.subtractGil(shop.getCard(cardName).getCost()*cardNumber);
                                        }
                                    }
                                    else System.out.println("Not enough Gil!");
                                    continue;
                                }
                                if (Input.startsWith("Sell"))
                                {
                                    String cardName = Input.substring(5);
                                    System.out.println("How many " + cardName + " cards do you want to sell?");
                                    int cardNumber = input.nextInt();
                                    input.nextLine();
                                    if (play.player1.getCardNumber(cardName) - play.player1.getDeck().getCardNumber(cardName) >= cardNumber)
                                    {
                                        play.player1.removePlayerCard(cardName,cardNumber);
                                        play.player1.addGil(play.player1.getCard(cardName).getCost() * cardNumber / 2);
                                        shop.addShopCard(play.player1.getCard(cardName),cardNumber);
                                        System.out.println("Successfully sold " + cardNumber + " of \"" + cardName + "\"!");
                                    }
                                    else System.out.println("Not enough cards out of deck!");
                                    continue;
                                }
                                if (Input.startsWith("Info"))
                                {
                                    String cardName = Input.substring(5);
                                    print.print(texts.CardInfo(shop.getCard(cardName)));
                                    continue;
                                }
                                if (Input.equals("Again"))
                                {
                                    System.out.println(print.getLastPrints());
                                    continue;
                                }
                                if (Input.equals("Exit")) {
                                    continue a;
                                }

                            }while (true);
                        if (Input.equals("Item Shop"))
                            do //in item shop
                            {
                                System.out.println("------Item Shop");
                                print.print(texts.ItemShop(shop.getItems(),play.player1.getPlayerItems()));
                                Input = input.nextLine();
                                if (Input.equals("Help"))
                                {
                                    print.print(texts.ItemShop_Help());
                                    continue;
                                }
                                if (Input.startsWith("Buy"))
                                {
                                    String itemName = Input.substring(4);
                                    System.out.println("How many " + itemName + " items do you want to buy?");
                                    int itemNumber = input.nextInt();
                                    input.nextLine();
                                    if (play.player1.subtractGil(shop.getItem(itemName).getCost()*itemNumber))
                                    {
                                        System.out.println("Successfully bought " + itemNumber + " of \"" + itemName + "\"!");
                                        play.player1.addPlayerItem(shop.getItem(itemName),itemNumber);
                                    }
                                    else {
                                        System.out.println("Not enough Gil!");
                                    }
                                    continue;
                                }
                                if (Input.startsWith("Sell"))
                                {
                                    String itemName = Input.substring(5);
                                    System.out.println("How many " + itemName + " items do you want to sell?");
                                    int itemNumber = input.nextInt();
                                    input.nextLine();
                                    if (play.player1.removePlayerItem(itemName,itemNumber))
                                    {
                                        play.player1.addGil(play.player1.getItem(itemName).getCost() * itemNumber / 2);
                                        System.out.println("Successfully sold " + itemNumber + " of \"" + itemName + "\"!");
                                    }
                                    else System.out.println("Not enough items!");
                                    continue;
                                }
                                if (Input.startsWith("Info"))
                                {
                                    String itemName = Input.substring(5);
                                    print.print("\"" + itemName + "\" Info:\n" + shop.getItem(itemName).getItemDetails() + "\n");
                                    continue;
                                }
                                if (Input.equals("Again"))
                                {
                                    System.out.println(print.getLastPrints());
                                    continue;
                                }
                                if (Input.equals("Exit"))
                                {
                                    continue a;
                                }
                            }while (true);
                        if (Input.equals("Amulet Shop"))
                            do //in Amulet Shop
                            {
                                System.out.println("------Amulet Shop");
                                print.print(texts.AmuletShop(shop.getAmulets(),play.player1));
                                Input = input.nextLine();
                                if (Input.equals("Help"))
                                {
                                    print.print(texts.AmuletShop_Help());
                                    continue;
                                }
                                if (Input.startsWith("Buy"))
                                {
                                    String amuletName = Input.substring(4);
                                    if (play.player1.getAmulet(amuletName) == null)
                                    {
                                        if (play.player1.subtractGil(shop.getAmulet(amuletName).getCost()))
                                        {
                                            play.player1.addAmulet(shop.getAmulet(amuletName));
                                            System.out.println("Successfully bought \"" + amuletName + "\" amulet!");
                                        }
                                        else System.out.println("Not enough Gil!");
                                    }
                                    else System.out.println("You already have this amulet!");
                                    continue;
                                }
                                if (Input.startsWith("Sell"))
                                {
                                    String amuletName = Input.substring(5);
                                    if (play.player1.getAmulet(amuletName) != null)
                                    {
                                        if ((play.player1.getEquippedAmulet() == null)||(!play.player1.getEquippedAmulet().getName().equals(amuletName)))
                                        {
                                            play.player1.removeAmulet(amuletName);
                                        }
                                        else {
                                            System.out.println("You can't sell your equipped amulet!");
                                        }
                                        continue;
                                    }
                                    else {
                                        System.out.println("You don't have such an amulet!");
                                    }
                                    continue;
                                }
                                if (Input.startsWith("Info"))
                                {
                                    String amuletName = Input.substring(5);
                                    print.print("\"" + amuletName + "\" :\n" + shop.getAmulet(amuletName).getAmuletDetails() + "\n");
                                    continue;
                                }
                                if (Input.equals("Again"))
                                {
                                    System.out.println(print.getLastPrints());
                                    continue;
                                }
                                if (Input.equals("Exit"))
                                {
                                    continue a;
                                }
                            }while (true);
                        if (Input.equals("Help"))
                            print.print(texts.EnterShop_Help());
                        if (Input.equals("Exit")) {
                            print.setInShop(false);
                            continue b;
                        }
                    }while (true);
                }
                if (Input.equals("Edit Inventory"))
                {
                    c:do //in Edit Inventory
                    {
                        print.print("---Inventory");
                        Input = input.nextLine();
                        if (Input.equals("Help"))
                        {
                            print.print(texts.EditInventory_Help());
                        }
                        if (Input.equals("Edit Deck"))
                        {
                            do {
                                print.print(texts.EditDeck_Help());
                                Input = input.nextLine();
                                if (Input.startsWith("Add"))
                                {
                                    String cardName = Input.substring(4,Input.length() - Input.split(" ")[Input.split(" ").length - 1].length() - 1);
                                    int cardNumber = Integer.valueOf(Input.split(" ")[Input.split(" ").length - 1]);
                                    if (play.player1.getDeck().addDeckCard(play.player1.getCard(cardName),cardNumber))
                                        System.out.println(cardNumber + " \"" + cardName + "\" were added to deck!");
                                    else System.out.println("Only 30 Cards could be places in deck!");
                                    continue;
                                }
                                if (Input.startsWith("Remove"))
                                {
                                    String cardName = Input.substring(7).split(" ")[0];
                                    int cardNumber = Integer.valueOf(Input.substring(7).split(" ")[1]);
                                    if (play.player1.getDeck().removeDeckCard(cardName,cardNumber))
                                    {
                                        System.out.println(cardNumber + " \"" + cardName + "\" were removed from deck!");
                                    }
                                    else System.out.println("Not enough cards in deck to be removed!");
                                    continue;
                                }
                                if (Input.equals("Help"))
                                {
                                    System.out.println(print.getLastPrints());
                                }
                                if (Input.equals("Again"))
                                {
                                    System.out.println(print.getLastPrints());
                                    continue;
                                }
                                if (Input.equals("Exit"))
                                {
                                    continue c;
                                }
                            }while (true);
                        }
                        if (Input.equals("Card Inventory"))
                        {
                            do {
                                print.print(texts.CardInventory(play.player1));
                                Input = input.nextLine();
                                if (Input.startsWith("Info"))
                                {
                                    String cardName = Input.substring(5);
                                    print.print(texts.CardInfo(play.player1.getCard(cardName)));
                                    continue;
                                }
                                if (Input.equals("Help"))
                                    System.out.println("Type Info \"Card Name\" to see the information.");
                                if (Input.equals("Again"))
                                    System.out.println(print.getLastPrints());
                                if (Input.equals("Exit"))
                                    continue c;
                            }while (true);
                        }
                        if (Input.equals("Item Inventory"))
                        {
                            do {
                                print.print(texts.ItemInventory(play.player1.getPlayerItems()));
                                Input = input.nextLine();
                                if (Input.startsWith("Info"))
                                {
                                    String itemName = Input.substring(5);
                                    print.print(play.player1.getItem(itemName) + " Info:\n" + play.player1.getItem(itemName).getItemDetails() + "\n");
                                    continue;
                                }
                                if (Input.equals("Help"))
                                    System.out.println("Type Info \"Item Name\" to see the information.");
                                if (Input.equals("Again"))
                                    System.out.println(print.getLastPrints());
                                if (Input.equals("Exit"))
                                    continue c;
                            }while (true);
                        }
                        if (Input.equals("Amulet Inventory"))
                        {
                            do {
                                print.print(texts.AmuletInventory(play.player1.getAmuletBag()));
                                Input = input.nextLine();
                                if (Input.startsWith("Info"))
                                {
                                    String amuletName = Input.substring(5);
                                    print.print("\"" + play.player1.getAmulet(amuletName) + "\":\n" + play.player1.getAmulet(amuletName).getAmuletDetails() + "\n");
                                    continue;
                                }
                                if (Input.equals("Help"))
                                    System.out.println("Type Info \"Amulet Name\" to see the information.");
                                if (Input.equals("Again"))
                                    System.out.println(print.getLastPrints());
                                if (Input.equals("Exit"))
                                    continue c;
                            }while (true);
                        }
                        if (Input.equals("Edit Amulets"))
                        {
                            do {
                                System.out.println();
                                print.print(texts.EditAmulet_Help());
                                Input = input.nextLine();
                                if (Input.startsWith("Equip"))
                                {
                                    String amuletName = Input.substring(6);
                                    if (play.player1.getEquippedAmulet() == null)
                                    {
                                        play.player1.setEquippedAmulet(play.player1.getAmulet(amuletName));
                                        System.out.println("\"" + amuletName + "\" was equipped on the player.");
                                    }
                                    else {
                                        System.out.println("Player is already equipped with an amulet.");
                                    }
                                    continue;
                                }
                                if (Input.startsWith("Remove"))
                                {
                                    if (play.player1.getEquippedAmulet() != null)
                                    {
                                        String amuletName = play.player1.getEquippedAmulet().getName();
                                        play.player1.setEquippedAmulet(null);
                                        System.out.println("\"" + amuletName + "\" was removed.");
                                    }
                                    else {
                                        System.out.println("Player is not equipped with an amulet.");
                                    }
                                    continue;
                                }
                                if (Input.equals("Exit"))
                                {
                                    continue c;
                                }
                            }while (true);
                        }
                        if (Input.equals("Again"))
                        {
                            System.out.println(print.getLastPrints());
                        }
                        if (Input.equals("Exit"))
                        {
                            continue b;
                        }
                    }while (true);
                }
                if (Input.equals("Next"))
                {

                }
            }

        }
    }
}
