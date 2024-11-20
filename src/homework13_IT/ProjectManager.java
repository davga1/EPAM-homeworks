package homework13_IT;

public class ProjectManager extends ITWorker {
    ProjectManager(String name, String[] skills) {
        super(name, skills);
    }

    @Override
    public void doesWork() {
        System.out.println("Project manager is planning, organizing, and directing the completion of specific projects for an organization while ensuring these projects are on time, on budget, and within scope");
    }
}
