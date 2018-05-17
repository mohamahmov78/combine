import java.util.LinkedList;

public class WillChooseMoveNonT extends Will {
    boolean destinationIsGraveyardFriendly,  destinationIsGraveyardEnemy;
    WillChooseMoveNonT (String battleCryDetails, String battleCryName, boolean destinationIsGraveyardFriendly, boolean destinationIsGraveyardEnemy)
    {
        setWillDetails(battleCryDetails);
        setWillName(battleCryName);
        this.destinationIsGraveyardEnemy = destinationIsGraveyardEnemy;
        this.destinationIsGraveyardFriendly = destinationIsGraveyardFriendly;
    }

    void doWill (LinkedList<Card> beginningFriendly, LinkedList<Card> destinationFriendly, LinkedList<Card> beginningEnemy, LinkedList<Card> destinationEnemy, boolean[] friendlyIsChosen, boolean[] enemyIsChosen)
    {
        for (int i = 0; i < friendlyIsChosen.length; i++) {
            if (friendlyIsChosen[i]) {
                if (destinationIsGraveyardFriendly && beginningFriendly.get(i) instanceof AuraSpellCard){
                    ((AuraSpellCard) beginningFriendly.get(i)).reverseAura();
                }
                destinationFriendly.add(beginningFriendly.get(i));
                beginningFriendly.remove(i);
            }
        }
        for (int i = 0; i < enemyIsChosen.length; i++) {
            if (enemyIsChosen[i]) {
                if (destinationIsGraveyardEnemy && beginningEnemy.get(i) instanceof AuraSpellCard){
                    ((AuraSpellCard) beginningEnemy.get(i)).reverseAura();
                }
                destinationEnemy.add(beginningEnemy.get(i));
                beginningEnemy.remove(i);
            }
        }
    }
}
