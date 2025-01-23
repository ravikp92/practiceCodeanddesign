package src.main.java.com.example.demo.behaviorialdp.MomentoDP;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {

    List<ConfigurationMomento> history= new ArrayList<>();

    public void addMomento(ConfigurationMomento configurationMomento){
        history.add(configurationMomento);
    }

    public ConfigurationMomento undo(){
        if(!history.isEmpty()){
            ConfigurationMomento cfg=history.remove(history.size()-1);
            return cfg;

        }
        return null;
    }
}
