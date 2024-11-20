package homework13_IT;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FrontEndDeveloper a = new FrontEndDeveloper("a", new String[]{"asd", "sdad"});
        FullStackDeveloper b = new FullStackDeveloper("b", new String[]{"dsadas", "sdasdd"});
        TestAutomationEngineer c = new TestAutomationEngineer("c", new String[]{"sadwqe,xzvb"});
        ProjectManager d = new ProjectManager("d", new String[]{"asdasd", "das"});
        ITWorker arr[] = {a, b, c, d};
        for (ITWorker worker : arr) {
            System.out.println("-------------------");
            worker.doesWork();
        }
        Developer arr2[] = {a, b, c};
        for (Developer dev : arr2) {
            System.out.println("-------------------");
            dev.doHealthCheck();
        }
    }
}
