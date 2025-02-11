//ստեղծում եք կալկուլյատորի functional interface, իրա calculate մեթոդով,
// որը ստանումա երկու հատ թիվ ու վերադարձնումա թիվ ու նաև իրա signature ի մասա կազմում ինչ-որ ձեր սարքած custom checked exception։
// Էդ exception ը սխալ պարամետրերի դեպքում կօգտագործեք։
// Լամբդաներով իմպլեմենտ եք անում չորս տարբեր մաթեմատիկական օպերացիաները համապատասխանաբար ու կիրառում եք։
package homework22;


import homework22.exceptions.NullValueException;
import homework22.exceptions.ZeroDivisionException;

@FunctionalInterface
interface Calculator {
    Number calculate(Number num1, Number num2) throws ZeroDivisionException, NullValueException;

    static Number addition(Number num1, Number num2) throws NullValueException {
        checkNullValue(num1, num2);
        Number sum = num1.doubleValue() + num2.doubleValue();
        return sum.doubleValue() % 1 == 0 ? sum.intValue() : sum;
    }

    static Number subtraction(Number num1, Number num2) throws NullValueException {
        checkNullValue(num1, num2);
        Number sub = num1.doubleValue() - num2.doubleValue();
        return sub.doubleValue() % 1 == 0 ? sub.intValue() : sub;
    }

    static Number multiplication(Number num1, Number num2) throws NullValueException {
        checkNullValue(num1, num2);
        Number mult = num1.doubleValue() * num2.doubleValue();
        return mult.doubleValue() % 1 == 0 ? mult.intValue() : mult;
    }

    static Number division(Number num1, Number num2) throws ZeroDivisionException, NullValueException {
        checkNullValue(num1, num2);
        if (num2.doubleValue() == 0) throw new ZeroDivisionException("Cannot divide by zero");
        Number div = num1.doubleValue() / num2.doubleValue();
        return div.doubleValue() % 1 == 0 ? div.intValue() : div;
    }

    private static void checkNullValue(Number num1, Number num2) throws NullValueException {
        if (num1 == null || num2 == null) {
            throw new NullValueException("Numbers cannot be null");
        }
    }

}

