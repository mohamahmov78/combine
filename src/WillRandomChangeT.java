import java.util.LinkedList;
import java.util.Random;

public class WillRandomChangeT extends Will {
    private int[] randomCardCount;
    private int[] friendlyChanges, enemyChanges;
    private String tribes[];
    WillRandomChangeT (int[] randomCardCount, int[] friendlyChanges, String[] tribes, int [] enemyChanges, String name, String details)
    {
        this.randomCardCount = randomCardCount;
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        this.tribes = tribes;
        setWillName(name);
        setWillDetails(details);
    }
    void doWill (MonsterField enemyMonsterField, MonsterField friendlyMonsterField)
    {
        LinkedList<Integer> enemyRandomGenerator = new LinkedList<>();
        LinkedList<Integer> friendlyRandomGenerator = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++)
        {
            if (enemyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[1]))
                enemyRandomGenerator.add(i);
            if (friendlyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[0]))
                friendlyRandomGenerator.add(i);
        }
        if (friendlyRandomGenerator.size() <= randomCardCount[0])
        {
            for (int i = 0; i < friendlyRandomGenerator.size(); i++)
            {
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeAP(friendlyChanges[1]);
            }
        } else {
            while (friendlyRandomGenerator.size() != randomCardCount[0])
            {
                friendlyRandomGenerator.remove(random.nextInt(friendlyRandomGenerator.size()));
            }
            for (int i = 0; i < randomCardCount[0]; i++)
            {
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeAP(friendlyChanges[1]);

            }
        }
        if (enemyRandomGenerator.size() <= randomCardCount[1])
        {
            for (int i = 0; i < enemyRandomGenerator.size(); i++)
            {
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeAP(enemyChanges[1]);
            }
        } else {
            while (enemyRandomGenerator.size() != randomCardCount[1])
            {
                enemyRandomGenerator.remove(random.nextInt(enemyRandomGenerator.size()));
            }
            for (int i = 0; i < randomCardCount[1]; i++)
            {
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeAP(enemyChanges[1]);

            }
        }
    }
}
