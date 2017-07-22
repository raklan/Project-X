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

        String cont = "";

        System.out.println("Project X");
        System.out.println("Press Enter to Begin");
        cont = scan.nextLine();
        System.out.println(cont);
        chooseRiddle();
    }

    public static void chooseRiddle(){

        int next = gen.nextInt(6);
        switch (next) {
            case 0:
                theRiddle = new Riddle("r", "romeo", 1, ". .  . . .     _  _ _ _     . _ _ _  . . _  . _ . .  . .  .  _  _");
                break;
            case 1:
                theRiddle = new Riddle("e1", "echo", 2, "ECHO ECHO ECHO ECHO ECHO ECHO ECHO ECHO ECHO ECHO");
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
                theRiddle = new Riddle("e2", "echo", 6, "You really think you can solve all of this? Quite the narcissist, aren't you? That's ok, I love you anyways.");
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
                String e = "";
                do{
                    e = scan.nextLine();
                    if(e.equalsIgnoreCase("")){

                        System.out.println("...");
                    }
                    else
                        System.out.println(e);
                }while(!e.equalsIgnoreCase("stop")&&!e.equalsIgnoreCase("quit")&&!e.equalsIgnoreCase("no more")&&!e.equalsIgnoreCase("exit"));
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
                System.out.println(theRiddle.getDesc());
                break;

        }

        System.out.println();
        System.out.println("Press Enter to Continue");
        String scanner = scan.nextLine();
        if(scanner.equalsIgnoreCase(theRiddle.getAnswer()))
        {
            if(theRiddle.getId()==1){
                System.out.println("6   D S Y I P");
            }
            else if(theRiddle.getId()==2){
                System.out.println("5   K O E _ X");
            }
            else if(theRiddle.getId()==3){
                System.out.println("4   N J Q W C");
            }
            else if(theRiddle.getId()==4){
                System.out.println("3   _ G Z _ T");
            }
            else if(theRiddle.getId()==5){
                System.out.println("2   A L V H _");
            }
            else if(theRiddle.getId()==6){
                System.out.println("1   F R B U M");
            }
        }
        System.out.println();
    }


    private static void printDelta()//reads delta from file and prints it out
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader("./Delta.txt"));
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
