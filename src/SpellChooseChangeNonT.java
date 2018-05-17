public class SpellChooseChangeNonT extends Spell {
    private int[] friendlyChanges, enemyChanges;
    private MonsterCard[] friendlyChosenCards = new MonsterCard[5];
    private MonsterCard[] enemyChosenCards = new MonsterCard[5];
    SpellChooseChangeNonT (String name, String details, int[] friendlyChanges, int[] enemyChanges)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        setSpellDetails(details);
        setSpellName(name);
    }
    public MonsterCard[] getFriendlyChosenCards() {
        return friendlyChosenCards;
    }
    public MonsterCard[] getEnemyChosenCards() {
        return enemyChosenCards;
    }
    public int[] getFriendlyChanges() {
        return friendlyChanges;
    }
    public int[] getEnemyChanges() {
        return enemyChanges;
    }
    public void doSpell (MonsterField friendlyMonsterField, MonsterField enemyMonsterField, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        for (int i = 0; i < 5; i++)
        {
            if (friendlyIsChosen[i])
            {
                friendlyChosenCards[i] = friendlyMonsterField.getMonsterField()[i];
                friendlyMonsterField.getMonsterField()[i].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[i].changeAP(friendlyChanges[1]);
            }
            if (enemyIsChosen[i])
            {
                enemyChosenCards[i] = enemyMonsterField.getMonsterField()[i];
                enemyMonsterField.getMonsterField()[i].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[i].changeAP(enemyChanges[1]);
            }
        }
    }
}
