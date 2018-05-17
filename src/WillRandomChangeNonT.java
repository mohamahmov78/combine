import java.util.LinkedList;
import java.util.Random;

public class WillRandomChangeNonT extends Will {
    private int[] randomCardCount;
    private int[] friendlyChanges, enemyChanges;
    WillRandomChangeNonT (int[] friendlyChanges, int[] enemyChanges, int[] randomCardCount, String battleCryDetails, String battleCryName)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        this.randomCardCount = randomCardCount;
        setWillDetails(battleCryDetails);
        setWillName(battleCryName);
    }
    void doWill (MonsterField friendlyMonsterField, MonsterField enemyMonsterField)
    {
        LinkedList<Integer> enemyRandomGenerator = new LinkedList<>();
        LinkedList<Integer> friendlyRandomGenerator = new LinkedList<>();
        for (int i = 0; i < 5; i++)
        {
            enemyRandomGenerator.add(i);
            friendlyRandomGenerator.add(i);
        }
        Random random = new Random();
        for (int i = 5; i > randomCardCount[1]; i--)
        {
            enemyRandomGenerator.remove(random.nextInt(i));
        }
        for (int i = 5; i > randomCardCount[0]; i--)
        {
            friendlyRandomGenerator.remove(random.nextInt(i));
        }
        for (int i = 0; i < randomCardCount[1]; i++)
        {
            enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeHP(enemyChanges[0]);
            enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeAP(enemyChanges[1]);
        }
        for (int i = 0; i < randomCardCount[0]; i++) {
            friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeAP(friendlyChanges[1]);
            friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeHP(friendlyChanges[0]);
        }
    }
}
