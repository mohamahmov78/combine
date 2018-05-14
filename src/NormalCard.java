public class NormalCard extends MonsterCard
{
    @Override
    public String getMonsterCardType() {return "Normal";}
    NormalCard (String name, int gilCost, int magicPointCost, int healthPoint, int attackPoint, String tribe, boolean isNimble, boolean isDefender)
    {
        setName(name);
        setMPcost(magicPointCost);
        setAP(attackPoint);
        setTribe(tribe);
        setHP(healthPoint);
        setCost(gilCost);
        setIsDefensive(isDefender);
        setIsNimble(isNimble);
    }

}
