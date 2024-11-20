package homework13_IT;

import java.util.Random;

public class FullStackDeveloper extends Developer implements usesIDE {

    FullStackDeveloper(String name, String[] skills) {
        super(name, skills);
    }

    @Override
    public void doHealthCheck() {
        Random random = new Random();
        System.out.println("Calling to API {baseUrl}/fe/healthCheck");
        System.out.println("Calling to API {baseUrl}/be/healthCheck");
        boolean randomStatus1 = random.nextBoolean();
        boolean randomStatus2 = random.nextBoolean();
        System.out.println(randomStatus1 && randomStatus2 ? "Full stack developer with name " + super.getName() + " is ready to work" : "Full stack developer with name " + super.getName() + " is not ready to work");
    }

    @Override
    public void doesWork() {
        System.out.println("A full-stack web developer is a person who can develop both client and server software");
    }

    @Override
    public void usesIDE() {
        System.out.println("Full-stack developer with name" + super.getName() + " is using VS code");
    }
}
