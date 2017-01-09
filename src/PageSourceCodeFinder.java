import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Mihai on 03.09.2016.
 */
public class PageSourceCodeFinder {
    private String pageSourceCode;

    PageSourceCodeFinder(){
        URL url = null;
        try {
        	/**
        	 * Checks if the URL is available and it copies all the source code to a String.
        	 */
            if(isNetAvailable()) {
                url = new URL("http://www.cursbnr.ro/");
                URLConnection googleConnection = url.openConnection();
                googleConnection.connect();

                BufferedReader in = new BufferedReader(new InputStreamReader(googleConnection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    pageSourceCode += inputLine;
                in.close();
            }
            else{
            	/**
            	 * If there is no internet connection there will be an Alert
            	 */
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("No internet access");
                alert.showAndWait();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (ConnectException iioe){

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getSourceCode(){
        return pageSourceCode;
    }
/**
 * Checks if there is Internet available
 * @return
 */
    public boolean isNetAvailable(){
        try {
            URL url = new URL("http://www.cursbnr.ro/");
            URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
}
