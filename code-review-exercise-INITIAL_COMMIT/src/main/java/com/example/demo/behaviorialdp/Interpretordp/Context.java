package src.main.java.com.example.demo.behaviorialdp.Interpretordp;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String ,Integer> contextMap= new HashMap<>();

    public void put(String var,int val){
        contextMap.put(var,val);
    }
    public int get(String value) {
        return contextMap.get(value);
    }
}
