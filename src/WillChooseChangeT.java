public class WillChooseChangeT extends Will {
    private int[] friendlyChanges, enemyChanges;
    private String[] tribes;
    WillChooseChangeT (String name, String details, int[] friendlyChanges, int[] enemyChanges, String[] tribes)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        setWillDetails(details);
        setWillName(name);
        this.tribes = tribes;
    }
    public void doWill (MonsterField friendlyMonsterField, MonsterField enemyMonsterField, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
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
