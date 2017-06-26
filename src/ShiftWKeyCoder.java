import java.util.Scanner;

/**
 * Write a description of class ShiftWKeyCoder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShiftWKeyCoder
{
    private static String key = "";
    private static byte shift;
    private static char[] toCode;
    private static char[] lock;
    private static char[] chart = new char[26];
    private static Scanner scan = new Scanner(System.in);
    private static String input;
    //for lowercase, -96
    //for uppercase, -64
    //for now, makes all lowercase
    //ascii 32 is space
    private static void key()
    {
        //gets info
        System.out.println("Enter shift");
        boolean done = false;
        do
        {
            try
            {
                shift = (byte)scan.nextInt();
                scan.nextLine();
                done = true;
            }catch(Exception e)
            {
                System.out.println("Please input a number");
            }
        }while(!done);
        if(shift>26||shift<-26)
        {
            shift = (byte)(shift%26);
            System.out.println("Shift is too high!\nReducing to: " + shift);
        }
        System.out.println("Enter keyword (if applicable)");
        key = scan.nextLine().toLowerCase();
        lock = key.toCharArray();
        //initializes chart array.  blank values are defaulted to char 42
        for(int i = 0; i<chart.length; i++)
        {
            chart[i]=42;
        }
        //puts key into the chart
        if(!key.equals(""))
        {
            for(int i = 0; i<lock.length; i++)
            {
                if(lock[i]>96&&lock[i]<123)
                    chart[lock[i]-96-1]=lock[i];
            }
        }
        //puts other letters in, shifted
        boolean inKey = false;
        int j = 0;
        for(int i = 0; i<chart.length; i++)
        {
            //checks if the letter isn't part of the key
            if(!key.equals(""))
            {
                inKey = false;
                j = 0;
                do
                {
                    if(lock[j]==i+96+1)
                        inKey=true;
                    j++;
                }while(!inKey && j<lock.length);
            }
            //shifts and inserts into key
            if(!inKey)
            {
                j=shift;
                while(chart[j]!=42)
                {
                    j++;
                    if(j>=26)
                        j-=26;
                }
                chart[j]=(char)(i+96+1);
            }
        }
        System.out.println("\nSuccess!\n");
    }

    private static void encode()
    {
        System.out.println("\nCurrently: ENCODING\n(type /quit to quit)");
        do
        {
            System.out.println("Enter message");
            input = scan.nextLine();
            if(input.equals("/quit"))
            {
                System.out.println();
                return;
            }
            toCode = input.toLowerCase().toCharArray();
            for(int i = 0; i<toCode.length; i++)
            {
                if(toCode[i]>96&&toCode[i]<123)
                {
                    toCode[i]=chart[toCode[i]-96-1];
                }
            }
            System.out.println();
            System.out.println(toCode);
            System.out.println();
        }while(true);
    }

    private static void decode()
    {
        System.out.println("\nCurrently: DECODING\n(type /quit to quit)");
        do
        {
            System.out.println("Enter coded message");
            input = scan.nextLine();
            if(input.equals("/quit"))
            {
                System.out.println();
                return;
            }
                
            toCode = input.toLowerCase().toCharArray();
            byte j;
            for(int i = 0; i<toCode.length; i++)
            {
                if(toCode[i]>96&&toCode[i]<123)
                {
                    j = 0;
                    while(chart[j]!=toCode[i]&&j<=26)
                    {
                        j++;
                    }
                    toCode[i] = (char)(j+96+1);
                }
            }
            System.out.println();
            System.out.println(toCode);
            System.out.println();
        }while(true);
    }

    private static void userInput()
    {
        do
        {
            System.out.println("key - set new cipher\nencode - encode a message\ndecode - decode a message\n/quit - quit program");
            input = scan.nextLine();
            if(input.equals("key"))
                key();
            else if(input.equals("encode"))
                encode();
            else if(input.equals("decode"))
                decode();
            else if(input.equals("/quit"))
                return;
            else
                System.out.println("Invalid input");
        }while(!input.equals(true));
    }

    public static void main(String[]args)
    {
        System.out.println("Welcome! First set up a cipher.");
        key();
        userInput();
        System.out.println("Goodbye!");
    }
}
