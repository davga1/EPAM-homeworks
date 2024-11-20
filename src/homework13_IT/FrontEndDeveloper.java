package homework13_IT;

import java.util.Random;

public class FrontEndDeveloper extends Developer implements usesIDE {
    FrontEndDeveloper(String name, String[] skills) {
        super(name, skills);
    }

    @Override
    public void doHealthCheck() {
        System.out.println("Calling to API {baseUrl}/fe/healthCheck");
        Random random = new Random();
        boolean randomStatus = random.nextBoolean();
        System.out.println(randomStatus ? "Front End developer is ready to work" : "Front End developer is not ready to work");
    }

    @Override
    public void usesIDE() {
        System.out.println("Front End Developer with name " + super.getName() + " is using Android Studio");
    }

    @Override
    public void doesWork() {
        System.out.println("Front End Developer builds the front-end portion of websites and web applications");
    }
}
