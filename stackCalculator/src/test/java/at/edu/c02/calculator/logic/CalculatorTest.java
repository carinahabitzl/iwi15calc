package at.edu.c02.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.logic.CalculatorImpl;

public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		//setup
		Calculator calc = new CalculatorImpl();
		
		//execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.add);

		//verify
		assertEquals(5, result, 0);
		

	}
	
	@Test
	public void testSimpleMulOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.mul);

		assertEquals(6, result, 0);

	}
	
	@Test
	public void testSimpleDivOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(6.0);
		calc.push(2);
		double result = calc.perform(Operation.div);

		assertEquals(3, result, 0);

	}
	
	
	
	

	//
	@Test(expected = CalculatorException.class)
	public void testPopOnEmptyStack() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.pop();

	}

	@Test
	public void testDivisionByZero() throws Exception {

		//Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.div);

			fail("Exception expected");
			

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}

	}

	@Test
	public void testSimpleModOperation() throws CalculatorException {

		Calculator calc = new CalculatorImpl();
		calc.push(11);
		calc.push(2);
		double result = calc.perform(Operation.mod);

		assertEquals(1, result, 0);

	}

	@Test
	public void testSimpleModOperationNegativ() throws CalculatorException {

		//Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.mod);

			fail("Exception expected");


		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}
	}
	@Test
	public void testSimpleCos() throws Exception {
		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		double result = calc.perform(Operation.cos);

		assertEquals(Math.cos(2), result, 0);


	}
	@Test
	public void testSimpleSin() throws Exception {
		Calculator calc = new CalculatorImpl();
		calc.push(5.0);
		double result = calc.perform(Operation.sin);

		assertEquals(Math.sin(5), result, 0);


	}


	@Test
	public void testSimpleDotOperation() throws Exception {

		//setup
		Calculator calc = new CalculatorImpl();

		//execute
		calc.push(1.0);
		calc.push(3);
		calc.push(2);
		calc.push(4);
		calc.push(2);
		double result = calc.perform(Operation.dot);

		//verify
		assertEquals(14, result, 0);
	}

	@Test
	public void negativeTestSimpleDotOperation() throws Exception {

		//Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(1.0);
			calc.push(3);
			calc.push(2);
			calc.push(4);
			calc.push(-2);
			calc.perform(Operation.dot);

			fail("Exception expected");


		} catch (NegativeArraySizeException e) {
			assertEquals("Negative length of vector", e.getMessage());
			// e.getCause()
		}
	}
}
