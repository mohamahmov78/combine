
public class MonsterField {
    private MonsterCard[] MFCards = new MonsterCard[5];
    public MonsterCard[] getMonsterField() {return MFCards;}
    public void setMonsterFieldCard (MonsterCard MoCard, int index)
    {
        if ((index > 0)&&(index < 6))
            MFCards[index - 1] = MoCard;
    }
    public boolean removeMonsterFieldCard (int index)
    {
        if ((index > 0)&&(index < 6))
        {
            MFCards[index] = null;
            return true;
        }
        return false;
    }
}
