package at.edu.c02.calculator.E2E;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.StoreException;
import at.edu.c02.calculator.logic.CalculatorImpl;
import at.edu.c02.calculator.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import static org.mockito.Mockito.*;

public class EndToEndTest { //hochladen

    @Test
    public void testParserTest06Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test06.xml"));

       assertEquals(2,result,0);

    }

    @Test
    public void testParserTest07Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test07.xml"));

        assertEquals(2,result,0);

    }

    @Test
    public void testParserTest11Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test11.xml"));

        assertEquals(40,result,0);

    }

    @Test
    public void testParserTest12Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test12.xml"));

        assertEquals(45, result, 0);

    }

    @Test
    public void testParserTest13Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        double result = parser.parse(new File("src/test/resources/test13.xml"));

        assertEquals(27, result, 0);

    }

    @Test
    public void testParserTest14Xml() throws Exception {

        Calculator cal = new CalculatorImpl();

        Parser parser = new Parser(cal);
        try {
            double result = parser.parse(new File("src/test/resources/test14.xml"));
        } catch (StoreException e) {
            assertEquals("this name was not stored yet", e.getMessage());
        }

    }


}
