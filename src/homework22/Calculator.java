//ստեղծում եք կալկուլյատորի functional interface, իրա calculate մեթոդով,
// որը ստանումա երկու հատ թիվ ու վերադարձնումա թիվ ու նաև իրա signature ի մասա կազմում ինչ-որ ձեր սարքած custom checked exception։
// Էդ exception ը սխալ պարամետրերի դեպքում կօգտագործեք։
// Լամբդաներով իմպլեմենտ եք անում չորս տարբեր մաթեմատիկական օպերացիաները համապատասխանաբար ու կիրառում եք։
package homework22;


@FunctionalInterface
interface Calculator {
    NullValueException n = new NullValueException("Numbers cannot be null");

    Number calculate(Number num1, Number num2) throws ZeroDivisionException, NullValueException;

    static Number addition(Number num1, Number num2) throws NullValueException {
        if (num1 == null || num2 == null) throw n;
        Number sum = num1.doubleValue() + num2.doubleValue();
        return sum.doubleValue() % 1 == 0 ? sum.intValue() : sum;
    }

    static Number subtraction(Number num1, Number num2) throws NullValueException {
        if (num1 == null || num2 == null) throw n;
        Number sub = num1.doubleValue() - num2.doubleValue();
        return sub.doubleValue() % 1 == 0 ? sub.intValue() : sub;
    }

    static Number multiplication(Number num1, Number num2) throws NullValueException {
        if (num1 == null || num2 == null) throw n;
        Number mult = num1.doubleValue() * num2.doubleValue();
        return mult.doubleValue() % 1 == 0 ? mult.intValue() : mult;
    }

    static Number division(Number num1, Number num2) throws ZeroDivisionException, NullValueException {
        if (num1 == null || num2 == null) throw n;
        if (num2.doubleValue() == 0) throw new ZeroDivisionException("Cannot divide by zero");
        Number div = num1.doubleValue() / num2.doubleValue();
        return div.doubleValue() % 1 == 0 ? div.intValue() : div;
    }
}

class ZeroDivisionException extends Exception {
    public ZeroDivisionException(String message) {
        super(message);
    }
}

class NullValueException extends Exception {
    public NullValueException(String message) {
        super(message);
    }
}

