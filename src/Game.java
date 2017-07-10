import java.util.*;
import java.io.*;

/**
 * Copyright 2017 FBI Games
 * This code is under MIT licence, you can find the complete license in the
 * LICENSE file in the root project directory
 * <p>
 * Created by Raklan on 6/22/2017.
 */

public class Game {
    //create objects to use in the game
    static Riddle theRiddle = null;
    //static Riddle one = new Riddle("ar", "r", 1, ". .  . . .     _  _ _ _     . _ _ _  . . _  . _ . .  . .  .  _  _");
    //static Riddle two = new Riddle("e1", "e", 2, "Put the actual Riddle itself here");
    //static Riddle three = new Riddle("ay", "a", 3, "");
    //static Riddle four = new Riddle("dee", "d", 4, "");
    //static Riddle five = new Riddle("em", "m", 5, "");
    //static Riddle six = new Riddle("e2", "e", 6, "");

    static Random gen = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        chooseRiddle();
    }

    public static void chooseRiddle(){

        int next = gen.nextInt(6);
        switch (next) {
            case 0:
                theRiddle = new Riddle("r", "romeo", 1, ". .  . . .     _  _ _ _     . _ _ _  . . _  . _ . .  . .  .  _  _");
                break;
            case 1:
                theRiddle = new Riddle("e1", "echo", 2, "Put the actual Riddle itself here");
                break;
            case 2:
                theRiddle = new Riddle("a", "alpha", 3, "Sundry nerdists and geeks");
                break;
            case 3:
                theRiddle = new Riddle("d", "delta", 4, "");
                break;
            case 4:
                theRiddle = new Riddle("m", "mike", 5, "The 27th Angel");
                break;
            case 5:
                theRiddle = new Riddle("e2", "echo", 6, "");
                break;

        }
         showRiddle();
        chooseRiddle();
    }

    public static void showRiddle() {
        switch(theRiddle.getId()){
            case 1:
                System.out.println(theRiddle.getDesc());
                break;
            case 2:
                //Echo 1 Goes Here
                break;
            case 3:
                System.out.println(theRiddle.getDesc());
                break;
            case 4:
                printDelta();
                break;
            case 5:
                Cipher casesar = new Cipher(gen.nextInt(5)+1, theRiddle.getDesc());
                System.out.println(casesar.encrypt());
                break;
            case 6:
                //Echo 2 Goes Here
                break;

        }

        System.out.println();
        System.out.println("Press Enter to Continue");
        String scanner = scan.nextLine();
        if(scanner.equalsIgnoreCase(theRiddle.getAnswer()))
        {
            if(theRiddle.getId()==1){
                System.out.println("5   L U F K _ V");
            }
            else if(theRiddle.getId()==2){
                System.out.println("4   _ C N _ W X");
            }
            else if(theRiddle.getId()==3){
                System.out.println("3    E M S Z Y G");
            }
            else if(theRiddle.getId()==4){
                System.out.println("2   Q T B O R J");
            }
            else if(theRiddle.getId()==5){
                System.out.println("1   A I H D _ P");
            }
            else if(theRiddle.getId()==6){
                System.out.println("0   1 2 3 4 5 6");
            }
        }
        System.out.println();
    }


    private static void printDelta()//reads delta from file and prints it out
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader("./src/Delta.txt"));
            String line;
            do
            {
                line = reader.readLine();
                if(line!=null)
                {
                    System.out.println(line);
                }
            }while (line!=null);
            reader.close();
        }catch(IOException e)
        {
            System.out.println("There was an error reading the file");
            e.printStackTrace();
        }
    }
}
