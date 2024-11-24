package homework13_IT;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FrontEndDeveloper frontDev = new FrontEndDeveloper("Armen", new String[]{"HTML", "CSS"});
        FullStackDeveloper fullStackDev = new FullStackDeveloper("Babken", new String[]{"API development", "Frameworks"});
        TestAutomationEngineer qaDev = new TestAutomationEngineer("Chris", new String[]{"Testing, PRoblem solving"});
        ProjectManager poManager = new ProjectManager("Dennis", new String[]{"Market Sensitivity", "User-Centric Design Approach"});
        ITWorker[] arr = {frontDev, fullStackDev, qaDev, poManager};
        for (ITWorker worker : arr) {
            System.out.println("-------------------");
            worker.doesWork();
        }
        Developer arr2[] = {frontDev, fullStackDev, qaDev};
        for (Developer dev : arr2) {
            System.out.println("-------------------");
            dev.doHealthCheck();
        }
    }
}
