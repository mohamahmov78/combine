public class HeroCard extends MonsterCard {
    private Spell spell = null;
    private BattleCry battleCry = null;
    private Will will = null;
    @Override
    public String getMonsterCardType () {return "Hero";}
    public String getSpellDetails () {return spell.getSpellDetails();}
    public String getBattleCryDetails () {return battleCry.getBattleCryDetails();}
    public String getWillDetails () {return will.getWillDetails();}
    public Spell getSpell () {return spell;}
    public void setSpell (Spell spell) {this.spell = spell;}
    public BattleCry getBattleCry () {return battleCry;}
    public void setBattleCry (BattleCry battleCry) {this.battleCry = battleCry;}
    public Will getWill () {return will;}
    public void setWill (Will will) {this.will = will;}
}
