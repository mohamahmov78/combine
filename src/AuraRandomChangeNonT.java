public class AuraRandomChangeNonT extends SpellRandomChangeNonT {
    AuraRandomChangeNonT (int[] friendlyChanges, int[] enemyChanges, int[] randomCardCount, String battleCryDetails, String battleCryName)
    {
        super(friendlyChanges,enemyChanges,randomCardCount,battleCryDetails,battleCryName);
    }
    void reverseAura ()
    {
        for (int i = 0; i < 5; i++)
        {
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
