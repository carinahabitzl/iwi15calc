package at.edu.c02.calculator.logic;

import java.util.ArrayList;
import java.util.Stack;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

		if (op == Operation.dot){

			return dotLogic();

		}

		else {

			double b = pop();
			double a = pop();

			switch (op) {
				case add:
					return a + b;
				case sub:
					return a - b;
				case div:
					double c = a / b;
					if (Double.isInfinite(c))
						throw new CalculatorException("Division by zero");
					return c;
				case mul:
					return a * b;
				case mod:
					double m = a % b;
					if (b == 0)
						throw new CalculatorException("Division by zero");
					return m;
			}
		}

		return 0;
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

	public double dotLogic(){


		double length = stack_.pop();
		int newLength = (int) length;

		if (length < 0){
			throw new NegativeArraySizeException("Negative length of vector");
		}



		Double[] b = new Double[newLength];
		Double[] a = new Double[newLength];

		for (int i = 0; i < newLength; i++) {
			b[i] = stack_.pop();
		}

		for (int i = 0; i < newLength; i++) {
			a[i] = stack_.pop();
		}

		double result = 0;

		for (int i = 0; i < newLength; i++) {
			result += a[i] * b[i];
		}

		return result;
	}

}
