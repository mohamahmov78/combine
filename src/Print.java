public class Print {
    private Play play;
    private String lastPrints;
    private boolean inShop = false;
    public void setInShop (boolean inShop) {this.inShop = inShop;}
    public boolean getInShop () {return inShop;}
    public void print (String print)
    {
        if (inShop)
        {
            lastPrints = String.format("Remaining Gil: %d Gil\n",play.player1.getGil()) + print;
        }
        else {
            lastPrints = print;
        }
        System.out.println(lastPrints);
    }
    public String getLastPrints() {return lastPrints;}
    public void setPlay (Play play) {this.play = play;}
}
