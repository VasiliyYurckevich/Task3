package main.java.com.yurkevichVV;

import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static main.java.com.yurkevichVV.Game.*;

public class Main {

    public static String[] getSavedArgs() {
        return savedArgs;
    }

    private static  String[] savedArgs;


    protected Set<String> markSet;

    public static void main(String[] args) {
        try{
            savedArgs = args;
            checkEntryParam(savedArgs);
            startGame(savedArgs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void checkEntryParam(String[] args) throws Exception{
        Set<String> markSet = new HashSet<String>();
        if(args.length < 3){
            throw new Exception("Must have three or more command line arguments!Try again!");
        }else if (args.length % 2 == 0) {
            throw new Exception("Must have odd number command line arguments!Try again!");
        }else {
            for (int i = 0; i<args.length;i++) {
                markSet.add(args[i]);
            }
        }
        if (markSet.size() != args.length){
            throw  new Exception("Must have unique command line arguments!Try again!");
        }

    }
    public static void startGame(String[] moves) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] randomKey =RandomKey.generateRandomKey();
        String computersMove = moves[getComputersMove(moves)];
        byte[] hmac = HMAC.getHMAC(randomKey, computersMove);
        System.out.println("HMAC:" + DatatypeConverter.printHexBinary(hmac));
        ConMenu.menuCreating(moves);
        int usersMove = getUsersMove(moves);
        if ( usersMove == -1){
            System.exit(0);
        }
        else if( usersMove == -2) {
            startGame(moves);
        }else{
            getGameResult(moves, computersMove, usersMove);
            System.out.println("HMAC key:" + DatatypeConverter.printHexBinary(randomKey));
            startGame(moves);
        }
    }
    public static int getUsersMove(String[] moves) throws NoSuchAlgorithmException, InvalidKeyException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your move: ");
        String userMove = input.nextLine();
        if(userMove.equals("?")){
            System.out.println("HelpTable");
            HelpTable.generateTable(moves);
            startGame(moves);
        } else if (isDigit(userMove) == true){
            int moveIndex = Integer.parseInt(userMove) - 1;
            if (moveIndex < -1|| moveIndex > moves.length-1 ){
                System.out.println("Incorrect input of move.Try again!");
                return -2;
            }else if(moveIndex == -1){
                System.out.println("Bye!");
                System.exit(0);
            }else {
                System.out.println("Your move: " + moves[moveIndex]);
                return moveIndex;
            }
        }else{
            System.out.println("Incorrect input of move.Try again!");
        }
        return -2;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}




