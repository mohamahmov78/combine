import java.util.LinkedList;
import java.util.Random;

public class WillRandomMoveNonT extends Will {
    private int randomCardCount[];
    boolean destinationIsGraveyardFriendly,  destinationIsGraveyardEnemy;
    public WillRandomMoveNonT (String battleCryName, String battleCryDetails, int randomCardCount[],boolean destinationIsGraveyardFriendly, boolean destinationIsGraveyardEnemy)
    {
        setWillDetails(battleCryDetails);
        setWillName(battleCryName);
        this.randomCardCount = randomCardCount;
        this.destinationIsGraveyardEnemy = destinationIsGraveyardEnemy;
        this.destinationIsGraveyardFriendly = destinationIsGraveyardFriendly;
    }
    void doWill (LinkedList<Card> beginningFriendly, LinkedList<Card> destinationFriendly, LinkedList<Card> beginningEnemy, LinkedList<Card> destinationEnemy)
    {
        Random random = new Random();
        LinkedList<Integer> enemyRandomGenerator = new LinkedList<>();
        LinkedList<Integer> friendlyRandomGenerator = new LinkedList<>();
        for (int i = 0; i < beginningFriendly.size(); i++)
        {
            friendlyRandomGenerator.add(i);
        }
        for (int i = 0; i < beginningEnemy.size(); i++)
        {
            enemyRandomGenerator.add(i);
        }
        for (int i = beginningFriendly.size(); i > randomCardCount[0]; i--)
        {
            friendlyRandomGenerator.remove(random.nextInt(i));
        }
        for (int i = beginningEnemy.size(); i > randomCardCount[1]; i--)
        {
            enemyRandomGenerator.remove(random.nextInt(i));
        }
        for (int i = 0; i < randomCardCount[0]; i++)
        {
            if (destinationIsGraveyardFriendly && beginningFriendly.get(friendlyRandomGenerator.get(i)) instanceof AuraSpellCard){
                ((AuraSpellCard) beginningFriendly.get(friendlyRandomGenerator.get(i))).reverseAura();
            }
            destinationFriendly.add(beginningFriendly.get(friendlyRandomGenerator.get(i)));
            beginningFriendly.remove(beginningFriendly.get(friendlyRandomGenerator.get(i)));
        }
        for (int i = 0; i < randomCardCount[1]; i++)
        {
            if (destinationIsGraveyardEnemy && beginningEnemy.get(enemyRandomGenerator.get(i)) instanceof AuraSpellCard){
                ((AuraSpellCard) beginningEnemy.get(enemyRandomGenerator.get(i))).reverseAura();
            }
            destinationEnemy.add(beginningEnemy.get(enemyRandomGenerator.get(i)));
            beginningEnemy.remove(beginningEnemy.get(enemyRandomGenerator.get(i)));
        }
    }
}
