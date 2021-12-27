package main.java.com.yurkevichVV;

public class ConMenu {
    public static void menuCreating(String[] moves) {
        System.out.println("Available moves:");
        for (int i = 0; i < moves.length; i++)
            System.out.println(i + 1 + " - " + moves[i]);
        System.out.println("? - help");
        System.out.println("0 - exit");
    }
}
    /*String[][] table = new String[][] { {moves[1], moves[2], moves[3],moves[4],moves[5],moves[6] },
            {moves[1], "Draw", "Win", "Win","Lose","Lose" },
            {moves[2], "Draw", "Win", "Win","Lose","Lose" },
            {moves[3], "Draw", "Win", "Win","Lose","Lose" },
            {moves[4], "Draw", "Win", "Win","Lose","Lose" },
            {moves[5], "Draw", "Win", "Win","Lose","Lose" } };*/