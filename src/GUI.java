import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Created by Mihai on 03.09.2016.
 */
public class GUI {

    private ComboBox<Currency> comboBox;
    private ComboBox<Currency> comboBoxTo;
    private Pane layout;
    private Scene scene;
    private Text text;
    private Text valueText;
    private Button button;
    private TextField ammount;
    private TextField result;
    private Text ammountText;
    private Text resultText;

    public ComboBox<Currency> getComboBox() {
        return comboBox;
    }

    public void setComboBox(ComboBox<Currency> comboBox) {
        this.comboBox = comboBox;
    }

    public Pane getLayout() {
        return layout;
    }

    public void setLayout(Pane layout) {
        this.layout = layout;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public TextField getAmmount() {
        return ammount;
    }

    public void setAmmount(TextField ammount) {
        this.ammount = ammount;
    }

    public TextField getResult() {
        return result;
    }

    public void setResult(TextField result) {
        this.result = result;
    }

    public Text getValueText() {
        return valueText;
    }

    public void setValueText(Text valueText) {
        this.valueText = valueText;
    }

    public Text getAmmountText() {
        return ammountText;
    }

    public void setAmmountText(Text ammountText) {
        this.ammountText = ammountText;
    }

    public Text getResultText() {
        return resultText;
    }

    public void setResultText(Text resultText) {
        this.resultText = resultText;
    }

    public ComboBox<Currency> getComboBoxTo() { return comboBoxTo; }

    public void setComboBoxTo(ComboBox<Currency> comboBoxTo) { this.comboBoxTo = comboBoxTo; }

    public GUI(CurrencyFinder currencyFinder){
        setText(new Text("Convertor online"));
        getText().relocate(100,40);

        setValueText(new Text("Alegeti valuta"));
        getValueText().relocate(180,150);

        setAmmountText(new Text("Introduceti cantitatea"));
        getAmmountText().relocate(220,40);


        setComboBox(new ComboBox<Currency>());
        getComboBox().relocate(97, 65);

        setComboBoxTo(new ComboBox<Currency>());
        getComboBoxTo().relocate(97,110);


        setButton(new Button("Calculate"));
        getButton().relocate(400,80);

        setAmmount(new TextField(""));
        getAmmount().relocate(200,65);

        setResult(new TextField(""));
        getResult().setEditable(false);
        getResult().relocate(200,110);


        setLayout(new Pane());
        getLayout().getChildren().add(getComboBox());
        getLayout().getChildren().add(getButton());
        getLayout().getChildren().add(getText());
        getLayout().getChildren().add(getAmmount());
        getLayout().getChildren().add(getResult());
        getLayout().getChildren().add(getValueText());
        getLayout().getChildren().add(getAmmountText());
        getLayout().getChildren().add(getComboBoxTo());

        setScene(new Scene(getLayout(),500,200));

    }



}
