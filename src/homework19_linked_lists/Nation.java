//Ունենք պետություն բնորոշող կլասս (property ների օրինակներ՝ օրհներգ, զինանշան, դրոշ, բնակչության թիվ, մակերես, և այլն)։

package homework19_linked_lists;

public class Nation {
    private final String nationName;
    private final String anthem;
    private final String flagColors;
    private final Number population;
    private final double area;
    private final String capital;
    private final String currency;
    private final String phoneCode;

    Nation(String nationName, String anthem, String flagColors, Number population, double area, String capital, String currency, String phoneCode) {
        this.nationName = nationName;
        this.anthem = anthem;
        this.flagColors = flagColors;
        this.population = population;
        this.area = area;
        this.capital = capital;
        this.currency = currency;
        this.phoneCode = phoneCode;
    }

    //Other properties have no getters because Andranik told us to not add them if we will not use them

    public String getCapital() {
        return capital;
    }
}