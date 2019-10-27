package A2_7;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "./src/A_1_6/all-shakespeare.txt";
        File file = new File(filename);
        Reader reader = new FileReader(file);
        LineReader lines = new LineReader(reader);
        for(String line : lines) {
            System.out.println(line);
        }
    }
}


