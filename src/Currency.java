import java.io.Serializable;

/**
 * Created by Mihai on 03.09.2016.
 * The currency class which serves as the Model class from MVC
 */
public class Currency implements Serializable {
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency(String name, double value){
        this.setName(name);

        this.setValue(value);

    }

    @Override
    public String toString(){
        return this.getName();
    }


}
