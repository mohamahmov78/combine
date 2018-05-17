import java.util.LinkedList;
import java.util.Random;

public class SpellRandomChangeNonT extends Spell {
    private int[] randomCardCount;
    private int[] friendlyChanges, enemyChanges;
    private MonsterCard[] friendlyChosenCards = new MonsterCard[5];
    private MonsterCard[] enemyChosenCards = new MonsterCard[5];
    SpellRandomChangeNonT (int[] friendlyChanges, int[] enemyChanges, int[] randomCardCount, String battleCryDetails, String battleCryName)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        this.randomCardCount = randomCardCount;
        setSpellDetails(battleCryDetails);
        setSpellName(battleCryName);
    }
    public int[] getFriendlyChanges() {
        return friendlyChanges;
    }
    public int[] getEnemyChanges() {
        return enemyChanges;
    }
    public MonsterCard[] getEnemyChosenCards() {
        return enemyChosenCards;
    }
    public MonsterCard[] getFriendlyChosenCards() {
        return friendlyChosenCards;
    }
    void doSpell (MonsterField friendlyMonsterField, MonsterField enemyMonsterField)
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
            enemyChosenCards[i] = enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)];
            enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeHP(enemyChanges[0]);
            enemyMonsterField.getMonsterField()[enemyRandomGenerator.get(i)].changeAP(enemyChanges[1]);
        }
        for (int i = 0; i < randomCardCount[0]; i++) {
            friendlyChosenCards[i] = friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)];
            friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeAP(friendlyChanges[1]);
            friendlyMonsterField.getMonsterField()[friendlyRandomGenerator.get(i)].changeHP(friendlyChanges[0]);
        }
    }
}
