package homework13_IT;

import java.util.Random;

public class TestAutomationEngineer extends Developer implements usesIDE{
    TestAutomationEngineer(String name, String[] skills) {
        super(name, skills);
    }

    @Override
    public void doHealthCheck() {
        Random random = new Random();
        boolean testCasesExists = random.nextBoolean();
        System.out.println(testCasesExists ? "Test cases exist" : "Test cases does not exist");
        System.out.println(testCasesExists ? "QA with name " + super.getName() + " is ready to work" : "QA with name " + super.getName() + " is not ready to work");
    }

    @Override
    public void doesWork() {
        System.out.println("QA engineer develop tests that demonstrate how a product will react under expected and unexpected circumstances");
    }

    @Override
    public void usesIDE() {
        System.out.println("QA with name " + super.getName() + " is using Selenium");
    }
}
