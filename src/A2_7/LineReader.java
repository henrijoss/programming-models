package A2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineReader implements Iterable<String> {

    private BufferedReader bufferedReader;
    private String line;
    private boolean finished = false;

    public LineReader(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("Reader is not defined (null)");
        }
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                if (line != null) {
                    return true;
                } else if (finished) {
                    return false;
                } else {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            finished = true;
                            return false;
                        } else {
                            return true;
                        }
                    } catch(IOException ioe) {
                        throw new IllegalStateException(ioe.toString());
                    }
                }
            }
            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("End of file");
                }
                String currentLine = line;
                line = null;
                return currentLine;
            }
        };
    }
}




//public class LineReader implements Iterable<String> {
//
//    private BufferedReader bufferedReader;
//    private String line;
//    private boolean nextUsed = false;
//    private boolean firstTime = true;
//
//    public LineReader(Reader reader) {
//        this.bufferedReader = new BufferedReader(reader);
//    }
//
//    @Override
//    public Iterator<String> iterator() {
//        return new Iterator<String>() {
//            public String readLine() {
//                try {
//                    return bufferedReader.readLine();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }
//            @Override
//            public boolean hasNext() {
//                if (nextUsed && line != null) { // Check if Next was used and line if line is at start or end
//                    line = readLine();
//                    nextUsed = false;
//                    return line != null;
//                } else { // If next was not used
//                    if (firstTime) {
//                        firstTime = false;
//                        line = readLine();
//                        return line != null;
//                    } else {
//                        return line != null;
//                    }
//                }
//            }
//            @Override
//            public String next() {
//                if (hasNext()) {
//                    nextUsed = true;
//                } else {
//                    throw new NoSuchElementException();
//                }
//                return line;
//            }
//        };
//    }
//}



//public class LineReader implements Iterable<String> {
//
//    private BufferedReader bufferedReader;
//    private ArrayList<String> text = new ArrayList<>();
//
//    public LineReader(Reader reader) {
//        this.bufferedReader = new BufferedReader(reader);
//    }
//
//    @Override
//    public Iterator<String> iterator() {
//        try {
//            String line = this.bufferedReader.readLine();
//            while (line != null) {
//                text.add(line);
//                line = this.bufferedReader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return text.iterator();
//    }
//}

