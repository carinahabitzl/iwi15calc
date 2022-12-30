package at.edu.c02.calculator;

import java.util.HashMap;

public class Store {
    private Calculator calc;
    private HashMap<String, Double> hashMap = new HashMap<>();


    public Store(Calculator calc) {
        this.calc = calc;
    }

    public void store(String variable, double result) {
        if (hashMap.containsKey(variable)) hashMap.replace(variable, result);
        else hashMap.put(variable, result);
    }

    public double load(String variable) throws StoreException {
        if (!hashMap.containsKey(variable)) throw new StoreException("this name was not stored yet");
        return hashMap.get(variable);
    }
}
