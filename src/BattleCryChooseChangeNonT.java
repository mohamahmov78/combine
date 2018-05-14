public class BattleCryChooseChangeNonT extends BattleCry {
    private boolean[] enemyIsChosen,friendlyIsChosen;
    private int[] friendlyChanges, enemyChanges;
    BattleCryChooseChangeNonT (String name, String details, int[] friendlyChanges, int[] enemyChanges, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        this.friendlyChanges = friendlyChanges;
        this.enemyChanges = enemyChanges;
        this.enemyIsChosen = enemyIsChosen;
        this.friendlyIsChosen = friendlyIsChosen;
        setBattleCryDetails(details);
        setBattleCryName(name);
    }
}
