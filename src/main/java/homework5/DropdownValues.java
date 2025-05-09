package homework5;

public enum DropdownValues {
    YEAR("Year"), MONTH("Month"), DAY("Day");

    private final String name;

    DropdownValues(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
