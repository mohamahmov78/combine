import java.util.LinkedList;
import java.util.Random;

public class SpellRandomChangeT extends Spell {
    private int[] randomCardCount;
    private int[] friendlyChanges, enemyChanges;
    private String tribes[];
    private MonsterCard[] friendlyChosenCards = new MonsterCard[5];
    private MonsterCard[] enemyChosenCards = new MonsterCard[5];
    SpellRandomChangeT (int[] randomCardCount, int[] friendlyChanges, String[] tribes, int [] enemyChanges, String name, String details)
    {
        this.randomCardCount = randomCardCount;
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        this.tribes = tribes;
        setSpellName(name);
        setSpellDetails(details);
    }

    public int[] getEnemyChanges() {
        return enemyChanges;
    }

    public int[] getFriendlyChanges() {
        return friendlyChanges;
    }

    public MonsterCard[] getFriendlyChosenCards() {
        return friendlyChosenCards;
    }

    public MonsterCard[] getEnemyChosenCards() {
        return enemyChosenCards;
    }

    void doSpell (MonsterField enemyMonsterField, MonsterField friendlyMonsterField)
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
                friendlyChosenCards[i] = friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)];
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
                friendlyChosenCards[i] = friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)];
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeAP(friendlyChanges[1]);

            }
        }
        if (enemyRandomGenerator.size() <= randomCardCount[1])
        {
            for (int i = 0; i < enemyRandomGenerator.size(); i++)
            {
                enemyChosenCards[i] = enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)];
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
                enemyChosenCards[i] = enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)];
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeAP(enemyChanges[1]);

            }
        }
    }
}
