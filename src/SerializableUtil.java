import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Mihai on 20.09.2016.
 */
public class SerializableUtil {
    /**
     * Metoda de deserializare a unui TreeMap
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Currency> deserialize(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        ArrayList<Currency> currencyList = new ArrayList<Currency>();
        currencyList = (ArrayList<Currency>) ois.readObject();
        ois.close();
        return currencyList;
    }
    /**
     * Metoda de serializare a unui TreeMap
     * @param tree
     * @param fileName
     * @throws IOException
     */
    public static void serialize(ArrayList<Currency> currencyList, String fileName) throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(currencyList);
        oos.close();
    }
}
