/**
 * Copyright 2017 FBI Games
 * This code is under MIT licence, you can find the complete license in the
 * LICENSE file in the root project directory
 * <p>
 * Created by Raklan on 6/22/2017.
 */

/**
 * Riddle Object creator
 */
public class Riddle {

    private String name;
    private String answer;
    private int id;
    private String desc;
    private boolean isSolved;

    public Riddle() {
    }

    public Riddle(String n, String a, int i, String d) {

        name = n;
        answer = a;
        id = i;
        desc = d;

    }

    public String getName() {
        return name;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
