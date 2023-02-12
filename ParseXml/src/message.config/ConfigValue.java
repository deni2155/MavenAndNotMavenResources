package message.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
//подключаю интерфейс с переменными для чтения информации из конфигурационного файла
//
public class ConfigValue implements InterfaceConfigValue{

    public ConfigValue(){
        Logger logger=LoggerFactory.getLogger(ConfigValue.class);
        
        try{
            //проверяю существование файла конфигураций
            if(pathConfigFile.exists()){
                //читаю свойства из файла и присваю значения массиву
                FileInputStream fileStream=new FileInputStream(pathConfigFile);
                try{
                    Properties properties=new Properties();
                    properties.load(fileStream);
                    typeMessage.put("in",properties.getProperty("in"));
                    typeMessage.put("out",properties.getProperty("out"));
                    typeMessage.put("archiveIn",properties.getProperty("archiveIn"));
                    typeMessage.put("archiveOut",properties.getProperty("archiveOut"));
                }catch(IOException ex){
                    logger.error("При чтении информации из конфигурационного файла config.properties возникла программная ошибка {}", ex);
                }finally{
                    fileStream.close();
                }
            }
            else{
                logger.info("Не найден конфигурационный файл config.properties");
            }
        }
        catch(FileNotFoundException ex){
            logger.error("При чтении информации из конфигурационного файла config.properties возникла программная ошибка {}", ex);
        }
        catch(IOException ex){
            logger.error("При чтении информации из конфигурационного файла config.properties возникла программная ошибка {}", ex);
        }
        catch(Exception ex){
            logger.error("При чтении информации из конфигурационного файла config.properties возникла программная ошибка {}", ex);
        }
    }
    //
    //Переопределяю метод для получения значения из массива
    //
    @Override
    public String getConfigValue(String key){
        return typeMessage.get(key);
    }
}
