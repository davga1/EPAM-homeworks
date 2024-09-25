//Calculate Income Tax Based on Salary Using Overloaded Functions (With Special IT Tax Rate)
//Write overloaded methods named calculateIncomeTax:
//One version accepts a gross salary (as a double) and calculates the income tax based on a default tax rate of 20%.
//Another version accepts a gross salary and a custom tax rate (as a double) to calculate the income tax.
//A third version accepts a gross salary and a flag indicating whether the person works in the IT sector, applying a special tax rate of 10% for IT employees.

package homework7_overloaded_methods;

public class CalculateIncomeTax {

    static double calculateIncomeTax(int grossSalary) {
        if (grossSalary < 0) {
            grossSalary *= -1;
        }
        return (grossSalary * 20.0) / 100;
    }

    static double calculateIncomeTax(int grossSalary, double taxRate) {
        if (taxRate <= 0) {
            taxRate = 20;
        }
        if (grossSalary < 0) {
            grossSalary *= -1;
        }
        return (grossSalary * taxRate) / 100;
    }

    static double calculateIncomeTax(int grossSalary, boolean isFromIT) {
        if (grossSalary < 0) {
            grossSalary *= -1;
        }
        return isFromIT ? (grossSalary * 10.0) / 100 : (grossSalary * 20.0) / 100;
    }

    public static void main(String[] args) {
        System.out.println(calculateIncomeTax(-15000));
    }
}
