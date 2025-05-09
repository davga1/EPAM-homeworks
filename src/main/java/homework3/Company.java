package homework3;

import java.util.Objects;

public class Company {
    private final String companyName;
    private final int pageViewCount;
    private final int followersCount;
    private final int activeJobsCount;
    private final int jobHistory;

    Company(String companyName, int pageViewCount, int followersCount,
            int activeJobsCount, int jobHistory) {
        this.companyName = companyName;
        this.pageViewCount = pageViewCount;
        this.followersCount = followersCount;
        this.activeJobsCount = activeJobsCount;
        this.jobHistory = jobHistory;
    }
    public String toString() {
        return "\n{NAME:" + companyName + "\nPAGE VIEW COUNT:" + pageViewCount + "\nFOLLOWERS COUNT:" + followersCount +
                "\nACTIVE JOBS COUNT:" + activeJobsCount + "\nJOB HISTORY:" + jobHistory + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return pageViewCount == company.pageViewCount && followersCount == company.followersCount && activeJobsCount == company.activeJobsCount && jobHistory == company.jobHistory && Objects.equals(companyName, company.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, pageViewCount, followersCount, activeJobsCount, jobHistory);
    }
}
