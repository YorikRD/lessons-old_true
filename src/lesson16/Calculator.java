package lesson16;

public class Calculator {

    public double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }

    public static void main(String[] args) {

    }
}

interface Operation {
    double execute(double a, double b);
}



