public class SpellCasterCard extends MonsterCard {
    private Spell spell;
    @Override
    public String getMonsterCardType() {return "SpellCaster";}
    public String getSpellDetails () {return spell.getSpellDetails();}
    public Spell getSpell() {return spell;}
    public void setSpell (Spell spell) {this.spell = spell;}
}
