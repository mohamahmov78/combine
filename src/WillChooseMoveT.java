import java.util.LinkedList;

public class WillChooseMoveT extends Will {
    String[] tribes;

    WillChooseMoveT (String[] tribes, String battleCryDetails, String battleCryName){
        setWillDetails(battleCryDetails);
        setWillName(battleCryName);
        this.tribes = tribes;
    }
    void doWill (LinkedList<MonsterCard> beginningFriendly, LinkedList<MonsterCard> destinationFriendly, LinkedList<MonsterCard> beginningEnemy, LinkedList<MonsterCard> destinationEnemy, boolean[] friendlyIsChosen, boolean[] enemyIsChosen)
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
