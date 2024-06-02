package busquedaconcurrencia;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class BusquedaConcurrencia{

    final static String[] DATA_FIELDS = {"points",
            "title",
            "description",
            "taster_name",
            "taster_twitter_handle",
            "price",
            "designation",
            "variety",
            "region_1",
            "region_2",
            "province",
            "country",
            "winery"
    };

    public static String compararValores(String[] singleData, String[] query) {
        String value = "";
        for(byte i = (byte)0; i < singleData.length; ++i) {
            if (singleData[i] == null)
                continue;
            if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[0])){
                if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[1])){
                    if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[2])){
                        if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[3])){
                            if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[4])){
                                if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[5])){
                                    if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[6])){
                                        if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[7])){
                                            if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[8])){
                                                if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[9])){
                                                    if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[10])){
                                                        if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[11])){
                                                            if (query[i] == null || singleData[i].equalsIgnoreCase(query[i]) || singleData[i].equalsIgnoreCase(query[12])){
                                                                value = value.concat(DATA_FIELDS[i] + ": " + singleData[i] + "\n");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }        
                
            else
                return "";
        }
        return value + "\n";
    }
    
    static void procesaObjetoJSON(JsonParser parser, String[] singleData, byte lastIndex, String[] query)
                     throws IOException {
     while (!parser.isClosed()) {
         JsonToken token = parser.nextToken();
         if (JsonToken.END_OBJECT.equals(token)) {
             //Hemos alcanzado el final del objeto
             break;
         }
         if (!JsonToken.FIELD_NAME.equals(token)) {
             System.out.println("Error. esperado un nombre de campo");
             break;
         }
         token = parser.nextToken();
         procesaValorJSON(token, parser, singleData, lastIndex, query);
         lastIndex++;
     }
 }
 
 private static void procesaArrayJSON(JsonParser parser, String[] singleData, byte lastIndex, String[] query)
                     throws IOException {
     while (!parser.isClosed()) {
         JsonToken token = parser.nextToken();
         if (JsonToken.END_ARRAY.equals(token)) {
             //Hemos alcanzado el final del array
             break;
         }
         procesaValorJSON(token, parser, singleData, lastIndex, query);
     }
 }
 
 static void procesaValorJSON(JsonToken token, JsonParser parser, String[] singleData, byte lastIndex, String[] query)
                     throws IOException {
     if (null == token) {
         singleData[lastIndex] = parser.getValueAsString();
     } else switch (token) {
            case START_OBJECT:
                procesaObjetoJSON(parser, singleData, (byte)0, query);
                String x = compararValores(singleData, query);
                //Para eliminar espacios en blanco
                if (!x.isEmpty())
                System.out.println(x);
                break;
            case START_ARRAY:
                procesaArrayJSON(parser, singleData, (byte)0, query);
                break;
            default:

                singleData[lastIndex] = parser.getValueAsString();
                break;
        }
 }
}