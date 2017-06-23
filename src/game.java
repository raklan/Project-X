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

    static riddle five = new riddle("em", "m", 5, "");

    static riddle six = new riddle("e2", "e", 6, "");


    static Random gen = new Random();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[]args){

        System.out.println(cipher('z'));

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

        riddleOne();

    }

    public static void riddleOne(){

        System.out.println(one.getDesc());
        System.out.println();
        System.out.println("Press Enter To Continue");
        String ok = scan.nextLine();
        System.out.println();
    }
    public static void riddleTwo(){



    }
    public static void riddleThree(){



    }
    public static void riddleFour(){



    }
    public static void riddleFive(){



    }
    public static void riddleSix(){



    }

    public static char cipher(char first){

        char old = first;
        old+=5;
        return old;

    }



}
