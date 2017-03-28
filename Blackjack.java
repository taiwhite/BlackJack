
/**
 * Write a description of class blackJack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Blackjack 
{
    int value = 0;
    String a = "";
    String[] ranks = new String[13];
    String[] suits = new String[4];
    int[] values = new int[13];
    Deck regular;
    int CTotal;
    int PTotal;
    int DTotal;
    
    
    
    public int findValuesComputer(Card card){
        String cardRank = card.rank();
        if (cardRank.equals("ace")){
            return 1;
        }
        else if (cardRank.equals("two")){
            return 2;
        }
        else if (cardRank.equals("three")){
            return 3;
        }
        else if (cardRank.equals("four")){
            return 4;
        }
        else if (cardRank.equals("five")){
            return 5;
        }
        else if (cardRank.equals("six")){
            return 6;
        
        }else if (cardRank.equals("seven")){
            return 7;
        }
        else if (cardRank.equals("eight")){
            return 8;
        }
        else if (cardRank.equals("nine")){
            return 9;
        }
        else if (cardRank.equals("ten") || cardRank.equals("jack") || cardRank.equals("queen") || cardRank.equals("king")){
            return 10;
        }
        else{
            return 0;
        }
    }
    public int findValues(Card card){
        String cardRank = card.rank();
        if (cardRank.equals("ace")){
            return ace()+question();
        }
        else if (cardRank.equals("two")){
            return 2+question();
        }
        else if (cardRank.equals("three")){
            return 3+question();
        }
        else if (cardRank.equals("four")){
            return 4+question();
        }
        else if (cardRank.equals("five")){
            return 5+question();
        }
        else if (cardRank.equals("six")){
            return 6+question();
        
        }else if (cardRank.equals("seven")){
            return 7+question();
        }
        else if (cardRank.equals("eight")){
            return 8+question();
        }
        else if (cardRank.equals("nine")){
            return 9+question();
        }
        else if (cardRank.equals("ten") || cardRank.equals("jack") || cardRank.equals("queen") || cardRank.equals("king")){
            return 10+question();
        }
        else{
            return 0+question();
        }
    }
    Boolean Player=true;
    Boolean CPU=true;
    Boolean dealer=true;


public void run (int x, int y, int z){
   
    for (int i=0; i<21; i++){
           
        if (Player==true && dealer==true || Player==true && CPU==true || CPU==true && dealer==true || dealer==true && Player==true || CPU==true && Player==true || dealer==true && CPU==true ){

            x = PTotal;
            y = DTotal;
            z = CTotal;
            Person(x,y,z);
                System.out.println(PTotal +" "+DTotal+" "+CTotal);
        }
    else{

        i=i+20;
        if (x>21){
            playerBust();
            
        }
    }
    declareWinner();

    
        if (Player==true && dealer==true || Player==true && CPU==true || CPU==true && dealer==true || dealer==true && Player==true || CPU==true && Player==true || dealer==true && CPU==true ){

             x = PTotal;
            y = DTotal;
            z = CTotal;
            CPU(x,y,z);
            System.out.println(PTotal +" "+DTotal+" "+CTotal);
           
        }
    else{
        i=i+20;
        if (y>21){
            CPUBust();
            
        }
    } 
    declareWinner();

 
 if (Player==true && dealer==true || Player==true && CPU==true || CPU==true && dealer==true || dealer==true && Player==true || CPU==true && Player==true || dealer==true && CPU==true ){
            x = PTotal;
            y = DTotal;
            z = CTotal;
            dealer(x,y,z);
            System.out.println(PTotal +" "+DTotal+" "+CTotal);
           
        }
    else{

        i=i+20;
        if (z>21){
            dealerBust();
        }
    }
    
    
    declareWinner();
    

           
           
 }
}
    public void declareWinner(){
        if (  CPU==false && dealer==false  || dealer==false && CPU==false ){
            System.out.println("You have won.");
        }
        else if ( Player==false && CPU==false || CPU==false && Player==false){
            System.out.println("The dealer has won.");
        }
        else if ( Player==false && dealer==false || dealer==false && Player==false){
            System.out.println("The CPU has won.");
        }
    }

public void dealer(int x,int y,int z ){
    if (dealer==true){
        if (y<=21 ){
            if (x>y){
                if (z>y){
                    DTotal += findValuesComputer(regular.deal ());
                }
            }
        }
       
        
        else{
            dealerBust();
        }
    }
}

public void CPU(int x, int y, int z){
    if (CPU==true){
        if (z<21 && z<16 || y>z ){
            CTotal += findValuesComputer(regular.deal());
        }
        else if (z<=21){
            System.out.println("The CPU has decided to stop drawing");
            CPU=false;
        }
         else{
            CPUBust();
        }
    }
}
public void Person(int x, int y, int z){
    if (Player==true){
        if (x<=21 ){
            PTotal = PTotal + findValues(regular.deal());
        }
        else{
            playerBust();
            Player=false;
        }
    }
}



public void playerBust(){
    System.out.println ( "You have busted.");
    Player=false;
}

public void dealerBust(){
    System.out.println("The dealer has busted.");
    dealer=false;
}

public void CPUBust(){
    System.out.println("The CPU has busted.");
    CPU=false;
}

    public int question(){
        String temp;
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to draw another card? (y/n)");
        temp=scan.next();
        if(temp.equals("n")){
            Player = false;
        }
        else if(temp.equals("y")){
            Player = true;
        }
        else{
            System.out.println("Invalid response");
            question();
        }
        return 0;
    }
    public int ace (){
        Scanner scan = new Scanner(System.in);
        System.out.println("You have drawn an ace. Would you like to use a value of one or eleven for the ace?");
        a = scan.next();
        testValid();
        return value;
    }
    public void error(){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("You have entered an invalid response. Please either enter one or eleven.");
        a = scan.next();
        testValid();
    }
    public void testValid(){
        if ( a.equals("one")){
            value=1;
        }
        else if ( a.equals("eleven")){
            value =11;
        }
        else{
            error();
            
        }
    }
    public void setDeck(){
        ranks[0] = "ace"; ranks[1] = "two"; ranks[2] = "three"; ranks[3] = "four"; ranks[4] = "five"; ranks[5] = "six"; ranks[6] = "seven"; ranks[7] = "eight"; ranks[8] = "nine"; ranks[9] = "ten"; ranks[10] = "jack"; ranks[11] = "queen"; ranks[12] = "king";
        suits[0] = "hearts"; suits[1] = "diamonds"; suits[2] = "spades"; suits[3] = "clubs";
        for(int i = 0; i < 10; i++){
            values[i] = i + 1;
        }
        for(int i = 10; i < values.length; i++){
            values[i] = 10;
        }
        Deck temporary = new Deck(ranks, suits, values);
        regular = temporary;
        regular.selectionShuffle();
    }
    
    
}