import java.util.LinkedList;
import java.util.Random;

public class WillRandomMoveT extends Will {
    private int[] randomCardCount;
    private String[] tribes;
    public WillRandomMoveT (String[] tribes, String name, String details, int[] randomCardCount)
    {
        this.randomCardCount = randomCardCount;
        this.tribes = tribes;
        setWillDetails(details);
        setWillName(name);
    }
    void doWill (LinkedList<MonsterCard> beginningFriendly, LinkedList<MonsterCard> beginningEnemy, LinkedList<MonsterCard> destinationFriendly, LinkedList<MonsterCard> destinationEnemy)
    {
        LinkedList<Integer> friendlyRandomGenerator = new LinkedList<>();
        LinkedList<Integer> enemyRandomGenerator = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < beginningFriendly.size(); i++)
        {
            if (beginningFriendly.get(i).getMonsterCardTribe().equals(tribes[0]))
            {
                friendlyRandomGenerator.add(i);
            }
        }
        for (int i = 0; i < beginningEnemy.size(); i++)
        {
            if (beginningEnemy.get(i).getMonsterCardTribe().equals(tribes[1]))
            {
                enemyRandomGenerator.add(i);
            }
        }
        if (friendlyRandomGenerator.size() <= randomCardCount[0])
        {
            for (int i = 0; i < friendlyRandomGenerator.size(); i++)
            {
                destinationFriendly.add(beginningFriendly.get(friendlyRandomGenerator.get(i)));
            }
            for (int i = 0; i < friendlyRandomGenerator.size(); i++)
            {
                beginningFriendly.remove(friendlyRandomGenerator.get(i));
            }
        } else {
            while (friendlyRandomGenerator.size() != randomCardCount[0])
            {
                friendlyRandomGenerator.remove(random.nextInt(friendlyRandomGenerator.size()));
            }
            for (int i = 0; i < randomCardCount[0]; i++)
            {
                destinationFriendly.add(beginningFriendly.get(friendlyRandomGenerator.get(i)));
            }
            for (int i = 0; i < randomCardCount[0]; i++)
            {
                beginningFriendly.remove(friendlyRandomGenerator.get(i));
            }
        }
        if (enemyRandomGenerator.size() <= randomCardCount[1])
        {
            for (int i = 0; i < enemyRandomGenerator.size(); i++)
            {
                destinationEnemy.add(beginningEnemy.get(enemyRandomGenerator.get(i)));
            }
            for (int i = 0; i < enemyRandomGenerator.size(); i++)
            {
                beginningEnemy.remove(enemyRandomGenerator.get(i));
            }
        } else {
            while (enemyRandomGenerator.size() != randomCardCount[1])
            {
                enemyRandomGenerator.remove(random.nextInt(enemyRandomGenerator.size()));
            }
            for (int i = 0; i < randomCardCount[1]; i++)
            {
                destinationEnemy.add(beginningEnemy.get(enemyRandomGenerator.get(i)));
            }
            for (int i = 0; i < randomCardCount[1]; i++)
            {
                beginningEnemy.remove(enemyRandomGenerator.get(i));
            }
        }
    }
}
