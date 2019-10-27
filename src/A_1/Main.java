package A_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("(([0-1][0-9]|[2][0-3])|[0-9]):([0-5][0-9])$").matcher("7:30");
        while(matcher.find()){
            String match = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(match+", start: "+start+", end: "+end);
        }
    }
}
