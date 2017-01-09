import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mihai on 02.09.2016.
 * This class lauches the application
 */
public class Driver {

    public static void main(String[] args) throws IOException{
        Application.launch(StartStage.class,"");
    }
}
