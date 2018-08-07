package main.resources.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MenuSize {
    Small,Medium,Large;

    private static Map<String,MenuSize> menuSizeMap = new HashMap<String,MenuSize>();

    static{
        menuSizeMap.put("Small",Small);
        menuSizeMap.put("Medium",Medium);
        menuSizeMap.put("Large",Large);
    }

    @JsonCreator
    public static MenuSize forValue(String value){
        return menuSizeMap.get(value);
    }

    @JsonValue
    public String toValue(){
        for (Map.Entry<String, MenuSize> entry : menuSizeMap.entrySet()){
            if(entry.getValue()==this) return entry.getKey();
        }

        return null; //failed
    }
}
