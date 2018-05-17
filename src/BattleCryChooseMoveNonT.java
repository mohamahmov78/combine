import java.util.LinkedList;

public class BattleCryChooseMoveNonT extends BattleCry {
    boolean destinationIsGraveyardFriendly;
    boolean destinationIsGraveyardEnemy;
    BattleCryChooseMoveNonT (String battleCryDetails, String battleCryName, boolean destinationIsGraveyardFriendly, boolean destinationIsGraveyardEnemy)
    {
        this.destinationIsGraveyardFriendly = destinationIsGraveyardFriendly;
        this.destinationIsGraveyardEnemy = destinationIsGraveyardEnemy;
        setBattleCryDetails(battleCryDetails);
        setBattleCryName(battleCryName);
    }

    void doBattleCry (LinkedList<Card> beginningFriendly, LinkedList<Card> destinationFriendly, LinkedList<Card> beginningEnemy, LinkedList<Card> destinationEnemy, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
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
