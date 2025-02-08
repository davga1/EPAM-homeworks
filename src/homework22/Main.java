package homework22;

public class Main {
    public static void main(String[] args) {
        Calculator sum1 = (num1, num2) -> {
            if (num1 == null || num2 == null) throw new NullValueException("Numbers cannot be null");
            Number sum = num1.doubleValue() + num2.doubleValue();
            return sum.doubleValue() % 1 == 0 ? sum.intValue() : sum;
        };
        Calculator sub1 = (num1, num2) -> {
            if (num1 == null || num2 == null) throw new NullValueException("Numbers cannot be null");
            Number sub = num1.doubleValue() - num2.doubleValue();
            return sub.doubleValue() % 1 == 0 ? sub.intValue() : sub;
        };
        Calculator mult1 = (num1, num2) -> {
            if (num1 == null || num2 == null) throw new NullValueException("Numbers cannot be null");
            Number mult = num1.doubleValue() * num2.doubleValue();
            return mult.doubleValue() % 1 == 0 ? mult.intValue() : mult;
        };
        Calculator div1 = (num1, num2) -> {
            if (num1 == null || num2 == null) throw new NullValueException("Numbers cannot be null");
            if (num2.doubleValue() == 0) throw new ZeroDivisionException("Cannot divide by zero");
            Number div = num1.doubleValue() / num2.doubleValue();
            return div.doubleValue() % 1 == 0 ? div.intValue() : div;
        };

        Calculator sum2 = Calculator::addition;
        Calculator sub2 = Calculator::subtraction;
        Calculator mult2 = Calculator::multiplication;
        Calculator div2 = Calculator::division;
        try {
            System.out.println("Using lambdas");
            System.out.println(sum1.calculate(null, 6));
            System.out.println(sub1.calculate(6, 88));
            System.out.println(mult1.calculate(2, 9));
            System.out.println(div1.calculate(5, 1));
        } catch (NullValueException | ZeroDivisionException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {

            System.out.println("Using method reference");
            System.out.println(sum2.calculate(1.3, 6));
            System.out.println(sub2.calculate(6, 88));
            System.out.println(mult2.calculate(2, 9));
            System.out.println(div2.calculate(5, 1));
            System.out.println(div2.calculate(5, 2));
        } catch (ZeroDivisionException | NullValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
