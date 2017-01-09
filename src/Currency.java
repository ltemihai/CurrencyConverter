import java.io.Serializable;

/**
 * Created by Mihai on 03.09.2016.
 */
public class Currency implements Serializable {
    private String name;
   // private String description;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public String getDescription() {
        //return description;
    //}
   //
   //public void setDescription(String description) {
     //   this.description = description;
   // }

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
