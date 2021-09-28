
/**
 *
 * @author Vo Thanh Dat
 */
public interface IManageEastAsiaCountries {
    public void addCountryInformation(EastAsiaCountries country) throws Exception;
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception;
    public EastAsiaCountries[] searchInformationByName(String name) throws Exception;
    public EastAsiaCountries[]sortInformationByAscendingOrder() throws Exception;
}
