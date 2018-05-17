public class BattleCryChooseChangeT extends BattleCry {
    private int[] friendlyChanges, enemyChanges;
    private String[] tribes;
    BattleCryChooseChangeT (String name, String details, int[] friendlyChanges, int[] enemyChanges, String[] tribes)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        setBattleCryDetails(details);
        setBattleCryName(name);
        this.tribes = tribes;
    }
    public void doBattleCry (MonsterField friendlyMonsterField, MonsterField enemyMonsterField, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        for (int i = 0; i < 5; i++)
        {
            if ((friendlyIsChosen[i])&&(friendlyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[0])))
            {
                friendlyMonsterField.getMonsterField()[i].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[i].changeAP(friendlyChanges[1]);
            }
            if (enemyIsChosen[i]&&(enemyMonsterField.getMonsterField()[i].getMonsterCardTribe().equals(tribes[1])))
            {
                enemyMonsterField.getMonsterField()[i].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[i].changeAP(enemyChanges[1]);
            }
        }

    }
}
