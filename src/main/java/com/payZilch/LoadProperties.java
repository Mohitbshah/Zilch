package com.payZilch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Welcome on 02/07/2019.
 */
public class LoadProperties extends Utils {

    static Properties prop;
    static FileInputStream input;

    public String getProperty (String key){

        prop = new Properties();

        try {
            input = new FileInputStream("src\\test\\Resources\\TestData\\config.properties");
            prop.load(input);
            input.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
