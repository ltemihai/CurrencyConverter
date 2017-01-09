import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class finds all the currencies from BNR site
 * Created by Mihai on 03.09.2016.
 */
public class CurrencyFinder {

    private PageSourceCodeFinder pageSourceCodeFinder;
    private ArrayList<Currency> currencyArrayList;

    public ArrayList<Currency> getCurrencyArrayList() {
        return currencyArrayList;
    }

    public void setCurrencyArrayList(ArrayList<Currency> currencyArrayList) {
        this.currencyArrayList = currencyArrayList;
    }


    public void getCurrencyFromSourceCode(){
        String codeGroupCurrency = "";
        String codeGroupValue = "";
      
        //Gets the source coude from the internet
        String sourceCode = pageSourceCodeFinder.getSourceCode();
        
        /**
         * I used Pattern/Matcher to get the currencies and the values from the web page
         */
        Pattern patternCurrency = Pattern.compile("<td>(\\S+)</td><td>");
        Matcher matcherCurrency = patternCurrency.matcher(sourceCode);

        Pattern patternValue = Pattern.compile("<td align='right'><b>(\\S+)</b></td>");
        Matcher matcherValue = patternValue.matcher(sourceCode);

        /**
         * This is the pattern that I found and it fits for that web page.
         */
        while(matcherCurrency.find() && matcherValue.find()) {
            codeGroupCurrency = matcherCurrency.group();
            if(codeGroupCurrency.contains("<b>"))
                codeGroupCurrency = codeGroupCurrency.substring(7,10);
            else if(codeGroupCurrency.contains("100"))
                codeGroupCurrency = codeGroupCurrency.substring(4,10);
            else
                codeGroupCurrency = codeGroupCurrency.substring(4,7);

            codeGroupValue = matcherValue.group();
            codeGroupValue = codeGroupValue.substring(21);

            Pattern patternDigits = Pattern.compile("[0-9]+(\\.[0-9][0-9][0-9][0-9][0-9]?)?");
            Matcher matcherDigits = patternDigits.matcher(codeGroupValue);

            String codeGroupRealValue = "";
            if(matcherDigits.find())
                codeGroupRealValue = matcherDigits.group();

            this.getCurrencyArrayList().add(new Currency(codeGroupCurrency,Double.parseDouble(codeGroupRealValue)));
        }
    }

    //Scarp code//
    {
   /* public void getEuroCurrencyFromSourceCode(){
        String codeGroup = "";
        Pattern patternEuro = Pattern.compile("1 EURO = (\\S+)<br/>");
        Matcher matcherEuro = patternEuro.matcher(pageSourceCodeFinder.getSourceCode());

        if(matcherEuro.find()){
            codeGroup = matcherEuro.group(1);
            System.out.println(codeGroup);
        }

        this.getCurrencyArrayList().add(new Currency("EUR",Double.parseDouble(codeGroup)));
        for(int i=0;i<getCurrencyArrayList().size();i++)
            System.out.println(getCurrencyArrayList().get(i).getName() +" "+getCurrencyArrayList().get(i).getValue());
        System.out.println();
    }

    public void getDollarCurrencyFromSourceCode(){
        String codeGroup = "";
        String pageSourceCode = pageSourceCodeFinder.getSourceCode();
        Pattern patternDollar = Pattern.compile("1 USD = (\\S+)<br/>");
        Matcher matcherDollar = patternDollar.matcher(pageSourceCode);

        if(matcherDollar.find()){
            codeGroup = matcherDollar.group(1);
        }
        this.currencyArrayList.add(new Currency("USD",Double.parseDouble(codeGroup)));
        System.out.println();
        for(int i=0;i<getCurrencyArrayList().size();i++)
            System.out.println(getCurrencyArrayList().get(i).getName() +" "+getCurrencyArrayList().get(i).getValue());
    }

    public void getFrancCurrencyFromSourceCode(){
        String codeGroup = "";
        String pageSourceCode = pageSourceCodeFinder.getSourceCode();
        Pattern patternFranc = Pattern.compile("1 CHF = (\\S+)<br/>");
        Matcher matcherFranc = patternFranc.matcher(pageSourceCode);
        if(matcherFranc.find()){
            codeGroup = matcherFranc.group(1);
        }
        getCurrencyArrayList().add(new Currency("CHF",Double.parseDouble(codeGroup)));
        for(int i=0;i<getCurrencyArrayList().size();i++)
            System.out.println(getCurrencyArrayList().get(i).getName() +" "+getCurrencyArrayList().get(i).getValue());
        System.out.println();
    }
    */
    }
    //////////////

    /**
     * I've added an reference currency, which is RON(1 RON = 1 RON lol)
     */
    public CurrencyFinder(){
        this.pageSourceCodeFinder = new PageSourceCodeFinder();
        this.setCurrencyArrayList(new ArrayList<Currency>());
        this.getCurrencyArrayList().add(new Currency("RON",1.0000));
       // this.getEuroCurrencyFromSourceCode();
       // this.getDollarCurrencyFromSourceCode();
       // this.getFrancCurrencyFromSourceCode();
        this.getCurrencyFromSourceCode();
    }

}
