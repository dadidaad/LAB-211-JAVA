public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode.toUpperCase();
        this.countryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1).toLowerCase();
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode.toUpperCase();
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName.substring(0, 1).toUpperCase() + countryName.substring(1).toLowerCase();
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    public void display(){
        System.out.println(getCountryCode() + "\t\t" + getCountryName() + "\t\t" + getTotalArea());
    }
    @Override
    public boolean equals(Object o){
        if(o == null)   return false;
        if(o instanceof Country){
            Country x = (Country)o;
            return x.countryCode.equals(this.countryCode);
        }
        return false;
    }
}
