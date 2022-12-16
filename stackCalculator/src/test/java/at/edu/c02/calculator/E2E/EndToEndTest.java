package at.edu.c02.calculator.E2E;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.logic.CalculatorImpl;
import at.edu.c02.calculator.parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import static org.mockito.Mockito.*;

public class EndToEndTest {

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



}
