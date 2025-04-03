package homework3;

import java.util.Objects;

public class Company {
    private String companyName;
    private int pageViewCount;
    private int followersCount;
    private int activeJobsCount;
    private int jobHistory;

    Company(String companyName, int pageViewCount, int followersCount,
            int activeJobsCount, int jobHistory) {
        this.companyName = companyName;
        this.pageViewCount = pageViewCount;
        this.followersCount = followersCount;
        this.activeJobsCount = activeJobsCount;
        this.jobHistory = jobHistory;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPageViewCount() {
        return pageViewCount;
    }

    public void setPageViewCount(int pageViewCount) {
        this.pageViewCount = pageViewCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getActiveJobsCount() {
        return activeJobsCount;
    }

    public void setActiveJobsCount(int activeJobsCount) {
        this.activeJobsCount = activeJobsCount;
    }

    public int getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(int jobHistory) {
        this.jobHistory = jobHistory;
    }

    public String toString() {
        return "\n{NAME:" + companyName + "\n:PAGE VIEW COUNT:" + pageViewCount + "\nFOLLOWERS COUNT:" + followersCount +
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
