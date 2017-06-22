/**
 * Riddle Object Creator.
 *
 * Created by FBI_Games
 */
public class riddle {

    private String name;
    private String answer;
    private int id;
    private String desc;


    public riddle(String n, String a, int i, String d){

        name=n;
        answer=a;
        id=i;
        desc=d;

    }

    public String getName(){return name;}
    public String getAnswer(){return answer;}
    public int getId(){return id;}
    public String getDesc(){return desc;}

}
