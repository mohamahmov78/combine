public class AuraSpellCard extends SpellCard {
    @Override
    public String getSpellCardType() {return "AuraSpell";}
    public void reverseAura ()
    {
        if (getSpell() instanceof AuraChooseChangeNonT)
            ((AuraChooseChangeNonT) getSpell()).reverseAura();
        if (getSpell() instanceof AuraChooseChangeT)
            ((AuraChooseChangeT) getSpell()).reverseAura();
        if (getSpell() instanceof AuraRandomChangeT)
            ((AuraRandomChangeT) getSpell()).reverseAura();
        if (getSpell() instanceof AuraRandomChangeNonT)
            ((AuraRandomChangeNonT) getSpell()).reverseAura();
    }

}
