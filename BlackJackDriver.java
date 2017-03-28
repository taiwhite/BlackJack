
public class BlackJackDriver{
    int playerCount;
    int dealerCount;
    int CPUCount;
    public static void main(String args[])  {
        Blackjack game = new Blackjack();
        game.setDeck();
        int CPUTotal = 0;
        int PersonTotal = 0;
        int dealerTotal = 0;
        game.run(PersonTotal, dealerTotal, CPUTotal);
    } 
    
}