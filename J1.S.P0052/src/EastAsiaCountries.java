public class EastAsiaCountries extends Country {
    private String countryTerrian;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrian) {
        super(countryCode, countryName, totalArea);
        this.countryTerrian = countryTerrian.substring(0,1).toUpperCase() + countryTerrian.substring(1).toLowerCase();
    }
    @Override
    public void display(){
        System.out.println(super.getCountryCode() + "\t\t" + super.getCountryName() +"      \t" + super.getTotalArea() +"\t\t" + countryTerrian);
    }
}
