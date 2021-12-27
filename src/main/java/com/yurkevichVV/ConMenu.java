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