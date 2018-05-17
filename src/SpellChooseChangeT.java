public class SpellChooseChangeT extends Spell {
    private int[] friendlyChanges, enemyChanges;
    private String[] tribes;
    private MonsterCard[] friendlyChosenCards = new MonsterCard[5];
    private MonsterCard[] enemyChosenCards = new MonsterCard[5];
    SpellChooseChangeT (String name, String details, int[] friendlyChanges, int[] enemyChanges, String[] tribes)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        setSpellDetails(details);
        setSpellName(name);
        this.tribes = tribes;
    }

    public MonsterCard[] getEnemyChosenCards() {
        return enemyChosenCards;
    }

    public MonsterCard[] getFriendlyChosenCards() {
        return friendlyChosenCards;
    }

    public int[] getEnemyChanges() {
        return enemyChanges;
    }

    public int[] getFriendlyChanges() {
        return friendlyChanges;
    }

    public void doSpell (MonsterField friendlyMonsterField, MonsterField enemyMonsterField, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        for (int i = 0; i < 5; i++)
        {
            if ((friendlyIsChosen[i])&&(friendlyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[0])))
            {
                friendlyChosenCards[i] = friendlyMonsterField.getMonsterField()[i];
                friendlyMonsterField.getMonsterField()[i].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[i].changeAP(friendlyChanges[1]);
            }
            if (enemyIsChosen[i]&&(enemyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[1])))
            {
                enemyChosenCards[i] = enemyMonsterField.getMonsterField()[i];
                enemyMonsterField.getMonsterField()[i].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[i].changeAP(enemyChanges[1]);
            }
        }

    }
}
