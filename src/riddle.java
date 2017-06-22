/**
 * Created by Ryan on 6/21/2017.
 */
public class riddle {

    private String name;
    private String answer;
    private int id;


    public riddle(String n, String a, int i){

        name=n;
        answer=a;
        id=i;

    }

    public String getName(){return name;}
    public String getAnswer(){return answer;}
    public int getId(){return id;}

}
