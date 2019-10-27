package A_1_6;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        String test = "Dies 9-3 ist e in Test-woran knnte   es noch...;liegen;das es     nicht -- ewq % I em]";
        String text = readFile();
        System.out.println(countWords(text) + " Matcher");
        System.out.println(test(text));
    }

    public static String readFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("./src/A_1_6/all-shakespeare.txt")));
    }

    public static int countWords(String text) {
        int counter = 0;
        Matcher matcher = Pattern.compile("([-a-z0-9]{2,}(?=[.,;\\s\\r\\t]|$))").matcher(text);
        while(matcher.find())
            counter++;
        return counter;
    }

    public static int test(String text) {

        String[] words = text.split("((?!([-A-Za-z\\d]{2,}(?=[.,;\\s\\r\\t]|$))).)");
//        String[] words = text.split("([^-A-Za-z\\d])+(.\\1)?([-A-Za-z\\d]{2}[^.,;\\s\\r\\t-A-Za-z\\d])?");
//        String[] words = text.split("(?<=(A-Z|a-z|\\d|-)){2,}[.,;\\s\\r\\t)]+");
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }

        return words.length;
    }


}
