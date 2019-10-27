package test.A2_7;

import A2_7.LineReader;
//import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/** 
* Main Tester. 
* 
* @author <Authors name> 
* @since <pre>Okt. 21, 2019</pre> 
* @version 1.0 
*/ 
public class MainTest { 

//@Before
//public void before() throws Exception {
//}
//
//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: main(String[] args) 
* 
*/

    @Test
    public void testReader() throws Exception {
        Reader reader = null;
        assertThrows(IllegalArgumentException.class, () -> {
            LineReader lines = new LineReader(reader);
        });
    }

    @Test
    public void testString() throws Exception {
        ArrayList<String> test = new ArrayList<>();
        Reader reader = new StringReader("Dies\nist\nein\nTest");
        LineReader lines = new LineReader(reader);
        for(String line : lines) {
            test.add(line);
        }
        assertEquals(Arrays.asList("Dies", "ist", "ein", "Test"), test);
    }


    @Test
    public void testStringReturns() throws Exception {
        ArrayList<String> test = new ArrayList<>();
        Reader reader = new StringReader("Dies\nist\rein\n\rTest\r");
        LineReader lines = new LineReader(reader);
        for (String line : lines) {
            test.add(line);
        }
        assertEquals(Arrays.asList("Dies", "ist", "ein","", "Test"), test);
    }

    @Test
    public void testEmptyString() throws Exception {
        Reader reader = new StringReader("");
        LineReader lines = new LineReader(reader);
        assertThrows(NoSuchElementException.class, () -> {
            lines.iterator().next();
        });
    }

    @Test
    public void testHasNext() throws Exception {
        Reader reader = new StringReader("");
        LineReader lines = new LineReader(reader);
        assertFalse(lines.iterator().hasNext());
        assertFalse(lines.iterator().hasNext());
        assertFalse(lines.iterator().hasNext());
    }

    @Test
    public void testNext() throws Exception {
        Reader reader = new StringReader("dkqw2\n2134º∂}«≠\n\r");
        LineReader lines = new LineReader(reader);
        assertEquals("dkqw2", lines.iterator().next());
    }
} 
