public class AuraChooseChangeNonT extends SpellChooseChangeNonT {
    AuraChooseChangeNonT (String name,String details, int[] friendlyChanges, int[] enemyChanges) {
        super(name, details, friendlyChanges, enemyChanges);
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
