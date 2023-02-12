package ru.scrooge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        Logger logger=LoggerFactory.getLogger(MainClass.class);
        logger.debug("dsafsda");
        System.out.println("123");
*/
        FileInputStream fileStream=new FileInputStream(ru.scrooge.MainClass.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"config.properties");
        Properties properties=new Properties();
        Map <String,String> typeMessage=new HashMap<>();
        properties.load(fileStream);
        typeMessage.put("in",properties.getProperty("in"));
        System.out.println("in");
    }
    
}
