import java.util.*;
/**
 * Project X
 *
 * Created by FBI_Games
 */
public class game {

    static riddle one = new riddle("ar","r", 1, ". .  . . .     _  _ _ _     . _ _ _  . . _  . _ . .  . .  .  _  _");

    static riddle two = new riddle("e1", "e", 2, "Put the actual Riddle itself here");

    static riddle three = new riddle("ay", "a", 3, "");

    static riddle four = new riddle("dee", "d", 4, "");

    static riddle five = new riddle("em", "m", 5, "The 27th Angel");

    static riddle six = new riddle("e2", "e", 6, "");


    static Random gen = new Random();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[]args){


        int next = gen.nextInt(6);

        switch(next){

            case 0:
                riddleOne();
                break;
            case 1:
                riddleTwo();
                break;
            case 2:
                riddleThree();
                break;
            case 3:
                riddleFour();
                break;
            case 4:
                riddleFive();
                break;
            case 5:
                riddleSix();
                break;

        }

        riddleFive();

    }

    public static void riddleOne(){

        System.out.println(one.getDesc());
        moveOn();
    }
    public static void riddleTwo(){



    }
    public static void riddleThree(){



    }
    public static void riddleFour(){



    }
    public static void riddleFive(){

        int rand = gen.nextInt(5)+1;
        System.out.println(cipher(five.getDesc(), rand));
        moveOn();

    }
    public static void riddleSix(){



    }

    //To Use Cipher, call it with the message to be encrypted and the number of slots you want to move letters
    //For example, System.out.println(cipher("Hello There", 4)); would print out the encrypted version of Hello There, with all characters shifted down 4 slots

    public static String cipher(String m, int k){

        int key = k;
        String message = m;
        String finished;

        Cipher caesar = new Cipher(k,m);
        finished = caesar.encrypt();

        return finished;

    }

    public static void moveOn(){

        System.out.println();
        System.out.println("Press Enter to Continue");
        String scanner = scan.nextLine();
        System.out.println(scanner);

    }

}
