import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Mihai on 03.09.2016.
 */
public class StartStage extends Application{
    public void start(Stage primaryStage) throws Exception{
        CurrencyFinder currencyFinder = new CurrencyFinder();
        GUI gui = new GUI(currencyFinder);
        Calculator calculator = new Calculator();
        primaryStage.setTitle("Convertor Valutar - Oltean Mihai");
        primaryStage.setScene(gui.getScene());

        for (int i=0; i<currencyFinder.getCurrencyArrayList().size();i++){
            gui.getComboBox().getItems().add(currencyFinder.getCurrencyArrayList().get(i));
            gui.getComboBoxTo().getItems().add(currencyFinder.getCurrencyArrayList().get(i));
        }

        gui.getComboBox().setOnAction((event) -> {
            String valueName = gui.getComboBox().getSelectionModel().getSelectedItem().getName();
            for(int i=0;i<currencyFinder.getCurrencyArrayList().size();i++)
                if(currencyFinder.getCurrencyArrayList().get(i).getName().equals((valueName)))
                    if(!gui.getComboBoxTo().getSelectionModel().isEmpty()){
                    double rate = calculator.calculateRate(gui.getComboBox().getSelectionModel().getSelectedItem().getValue(), gui.getComboBoxTo().getSelectionModel().getSelectedItem().getValue());
                        gui.getValueText().setText("1 " + gui.getComboBox().getSelectionModel().getSelectedItem().getName() + " = " + String.format("%.04f", rate) + " " + gui.getComboBoxTo().getSelectionModel().getSelectedItem().getName());
                }
        });

        gui.getComboBoxTo().setOnAction((event) -> {
            String valueName = gui.getComboBoxTo().getSelectionModel().getSelectedItem().getName();
            for(int i=0;i<currencyFinder.getCurrencyArrayList().size();i++)
                if(currencyFinder.getCurrencyArrayList().get(i).getName().equals((valueName)))
                    if(!gui.getComboBox().getSelectionModel().isEmpty()){
                        double rate = calculator.calculateRate(gui.getComboBox().getSelectionModel().getSelectedItem().getValue(), gui.getComboBoxTo().getSelectionModel().getSelectedItem().getValue());
                        gui.getValueText().setText("1 " + gui.getComboBox().getSelectionModel().getSelectedItem().getName() + " = " + String.format("%.04f", rate) + " " + gui.getComboBoxTo().getSelectionModel().getSelectedItem().getName());

                    }
        });

        gui.getButton().setOnAction((event) ->{
            double rate = calculator.calculateRate(gui.getComboBox().getSelectionModel().getSelectedItem().getValue(), gui.getComboBoxTo().getSelectionModel().getSelectedItem().getValue());
            gui.getResult().setText(String.valueOf(calculator.calculateAmmountOfMoney(rate,Double.parseDouble(gui.getAmmount().getText()))));
            gui.getResult().setText(String.format("%.04f", Double.parseDouble(gui.getResult().getText())));
        });


        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
