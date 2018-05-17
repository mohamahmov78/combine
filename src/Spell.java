public abstract class Spell {
    private String spellName;
    private String SpellDetails = null;
    public String getSpellDetails () {return SpellDetails;}
    public void setSpellDetails (String spellDetails) {SpellDetails = spellDetails;}
    public String getSpellName ()
    {
        return spellName;
    }
    public void setSpellName (String name)
    {
        spellName = name;
    }


}
