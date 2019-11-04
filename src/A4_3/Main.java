package A4_3;

public class Main {

    public static String recursiveResult = "";

    public static void main(String[] args) {
        String text = "test";
        System.out.println(toUpper(text));
        System.out.println(toUpperRecursive(text, text.length()-1, 0));
        System.out.println(toUpperEndRecursive(text, 0, text.length()-1, ""));
    }

    public static String toUpper(String s) {
        String result="";
        for (int i = 0; i < s.length(); i++)
            result += Character.toUpperCase(s.charAt(i));
        return result;
    }

    public static String toUpperRecursive(String s, int current, int end) {
        if (current < 0 ) return recursiveResult;
        recursiveResult = toUpperRecursive(s, current-1, end) + Character.toUpperCase(s.charAt(current));
        return recursiveResult;
    }


    public static String toUpperEndRecursive(String s, int current, int end, String result) {
        if (current > end) return result;
        result = toUpperEndRecursive(s, current+1, end, result += Character.toUpperCase(s.charAt(current)));
        return result;
    }


}
