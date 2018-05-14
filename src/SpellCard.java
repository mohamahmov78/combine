public abstract class SpellCard extends Card {
    private Spell spell = null;
    public abstract String getSpellCardType();
    public String getSpellDetails () {return spell.getSpellDetails();}
    public Spell getSpell() {return spell;}
    public void setSpell (Spell spell) {this.spell = spell;}
}
