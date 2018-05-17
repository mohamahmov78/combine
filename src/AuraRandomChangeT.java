public class AuraRandomChangeT extends SpellRandomChangeT{
    AuraRandomChangeT (int[] randomCardCount, int[] friendlyChanges, String[] tribes, int [] enemyChanges, String name, String details)
    {
        super(randomCardCount, friendlyChanges, tribes, enemyChanges, name, details);
    }
    void reverseAura (){
        for (int i = 0; i < 5; i++) {
            if (getFriendlyChosenCards()[i] != null)
            {
                getFriendlyChosenCards()[i].changeAP(0 - getFriendlyChanges()[1]);
                getFriendlyChosenCards()[i].changeHP(0 - getFriendlyChanges()[0]);
            }
            if (getEnemyChosenCards()[i] != null)
            {
                getEnemyChosenCards()[i].changeAP(0 - getEnemyChanges()[1]);
                getEnemyChosenCards()[i].changeHP(0 - getEnemyChanges()[0]);
            }
        }
    }
}
