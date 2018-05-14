public abstract class MonsterCard extends Card {
    private String name;
    private String Tribe = null;
    private int HP = -1;
    private int AP = -1;
    private boolean IsDefensive;
    private boolean IsNimble;
    public int getAP () {return AP;}
    public int getHP () {return HP;}
    public void setHP (int HP) {this.HP = HP;}
    public void addHP (int HP) {this.HP = this.HP + HP;}
    public void setAP (int AP) {this.AP = AP;}
    public boolean getIsDefensive () {return IsDefensive;}
    public boolean getIsNimble () {return IsNimble;}
    public void setIsDefensive (boolean isDefensive) {IsDefensive = isDefensive;}
    public void setIsNimble (boolean isNimble) {IsNimble = isNimble;}
    public String getMonsterCardTribe () {return Tribe;}
    public void setTribe (String tribe) {Tribe = tribe;}
    public abstract String getMonsterCardType ();
}
