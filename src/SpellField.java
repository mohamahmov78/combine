import java.util.Arrays;
import java.util.LinkedList;

public class SpellField {
    private SpellCard[] SFCards = new SpellCard[3];
    public LinkedList<SpellCard> spellCards= new LinkedList<>(Arrays.asList(SFCards));
    public SpellCard[] getSpellField() {
        return SFCards;
    }
    public void setSpellFieldCard(SpellCard SpCard, int index) {
        if ((index > 0)&&(index < 4))
        this.SFCards[index - 1] = SpCard;
    }
    public boolean removeSpellFieldCard (int index)
    {
        if ((index > 0)&&(index < 4)) {
            SFCards[index] = null;
            return true;
        }
        return false;
    }
}
