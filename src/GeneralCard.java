public class GeneralCard extends MonsterCard {
    private BattleCry battleCry;
    private Will will;
    @Override
    public String getMonsterCardType() {return "General";}
    public String getBattleCryDetails () {return battleCry.getBattleCryDetails();}
    public String getWillDetails () {return will.getWillDetails();}
    public BattleCry getBattleCry () {return battleCry;}
    public void setBattleCry (BattleCry battleCry) {this.battleCry = battleCry;}
    public Will getWill () {return will;}
    public void setWill (Will will) {this.will = will;}
}
