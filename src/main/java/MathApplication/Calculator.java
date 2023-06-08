package MathApplication;

class Calculator implements CalculatorService {
    @Override
    public double add(double input1, double input2) {
        return input1 + input2;
    }

    @Override
    public double subtract(double input1, double input2) {
        return input1-input2;
    }

    @Override
    public double multiply(double input1, double input2) {
        return input1*input2;
    }

    @Override
    public double divide(double input1, double input2) {
        if(input2 == 0) throw new IllegalArgumentException("Denominator can't be 0");
        return input1/input2;
    }
}