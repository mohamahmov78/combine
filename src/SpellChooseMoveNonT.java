import java.util.LinkedList;

public class SpellChooseMoveNonT extends Spell {
    boolean destinationIsGraveyardFriendly, destinationIsGraveyardEnemy;
    SpellChooseMoveNonT (String battleCryDetails, String battleCryName, boolean destinationIsGraveyardEnemy, boolean destinationIsGraveyardFriendly)
    {
        setSpellDetails(battleCryDetails);
        setSpellName(battleCryName);
        this.destinationIsGraveyardEnemy = destinationIsGraveyardEnemy;
        this.destinationIsGraveyardFriendly = destinationIsGraveyardFriendly;
    }

    void doSpell (LinkedList<Card> beginningFriendly, LinkedList<Card> destinationFriendly, LinkedList<Card> beginningEnemy, LinkedList<Card> destinationEnemy, boolean[] friendlyIsChosen, boolean[] enemyIsChosen)
    {
        for (int i = 0; i < friendlyIsChosen.length; i++) {
            if (friendlyIsChosen[i]) {
                if (destinationIsGraveyardFriendly && beginningFriendly.get(i) instanceof AuraSpellCard)
                {
                    ((AuraSpellCard) beginningFriendly.get(i)).reverseAura();
                }
                destinationFriendly.add(beginningFriendly.get(i));
                beginningFriendly.remove(i);
            }
        }
        for (int i = 0; i < enemyIsChosen.length; i++) {
            if (enemyIsChosen[i]) {
                if (destinationIsGraveyardEnemy && beginningEnemy.get(i) instanceof AuraSpellCard) {
                    ((AuraSpellCard) beginningEnemy.get(i)).reverseAura();
                }
                destinationEnemy.add(beginningEnemy.get(i));
                beginningEnemy.remove(i);
            }
        }
    }
}
