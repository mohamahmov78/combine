import java.util.LinkedList;

public class BattleCryChooseMoveT extends BattleCry{
    String[] tribes;

    BattleCryChooseMoveT (String[] tribes, String battleCryDetails, String battleCryName) {
        setBattleCryDetails(battleCryDetails);
        setBattleCryName(battleCryName);
        this.tribes = tribes;
    }
    void doBattleCry (LinkedList<MonsterCard> beginningFriendly, LinkedList<MonsterCard> destinationFriendly, LinkedList<MonsterCard> beginningEnemy, LinkedList<MonsterCard> destinationEnemy, boolean[] enemyIsChosen, boolean[] friendlyIsChosen)
    {
        for (int i = 0; i < friendlyIsChosen.length; i++) {
            if ((friendlyIsChosen[i])&&(tribes[0].equals(beginningFriendly.get(i).getMonsterCardTribe()))) {
                destinationFriendly.add(beginningFriendly.get(i));
                beginningFriendly.remove(i);
            }
        }
        for (int i = 0; i < enemyIsChosen.length; i++) {
            if ((enemyIsChosen[i])&&(tribes[1].equals(beginningEnemy.get(i).getMonsterCardTribe()))) {
                destinationEnemy.add(beginningEnemy.get(i));
                beginningEnemy.remove(i);
            }
        }
    }

}
