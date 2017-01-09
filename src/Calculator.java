/**
 * Created by Mihai on 03.09.2016.
 */
public class Calculator {
/**
 * 
 * @param currency
 * @param ammount
 * @return the ammount of money
 */
    public double calculateAmmountOfMoney(double currency,double ammount){
       return currency * ammount;
    }
/**
 * 
 * @param firstValue
 * @param secondValue
 * @return the rate between the two currencies
 */
    public double calculateRate(double firstValue, double secondValue){
        return firstValue/secondValue;
    }

}
