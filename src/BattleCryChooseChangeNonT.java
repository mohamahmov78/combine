public class BattleCryChooseChangeNonT extends BattleCry {
    private int[] friendlyChanges, enemyChanges;
    BattleCryChooseChangeNonT (String name, String details, int[] friendlyChanges, int[] enemyChanges)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        setBattleCryDetails(details);
        setBattleCryName(name);
    }
    public void doBattleCry (MonsterField friendlyMonsterField, MonsterField enemyMonsterField, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        for (int i = 0; i < 5; i++)
        {
            if (friendlyIsChosen[i])
            {
                friendlyMonsterField.getMonsterField()[i].changeHP(friendlyChanges[0]);
                friendlyMonsterField.getMonsterField()[i].changeAP(friendlyChanges[1]);
            }
            if (enemyIsChosen[i])
            {
                enemyMonsterField.getMonsterField()[i].changeHP(enemyChanges[0]);
                enemyMonsterField.getMonsterField()[i].changeAP(enemyChanges[1]);
            }
        }
    }
}
