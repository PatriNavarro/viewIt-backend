package main.resources.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TicketType {
    Regular,VIP,Elderly,Young,Night;

        private static Map<String,TicketType> ticketTypeMap = new HashMap<String,TicketType>();

        static{
            ticketTypeMap.put("Regular",Regular);
            ticketTypeMap.put("VIP",VIP);
            ticketTypeMap.put("Elderly",Elderly);
            ticketTypeMap.put("Young",Young);
            ticketTypeMap.put("Night",Night);
        }

        @JsonCreator
        public static TicketType forValue(String value){
            return ticketTypeMap.get(value);
        }

        @JsonValue
        public String toValue(){
            for (Map.Entry<String, TicketType> entry : ticketTypeMap.entrySet()){
                if(entry.getValue()==this) return entry.getKey();
            }

            return null; //failed
        }
}
