package live.becomeacookmaster.cookmaster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class JsonToArray {
    
    public String[][] jsonToArray(String json) {
        // Create an ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = null;

        // Convert JSON string to JsonNode
        try {
            jsonNode = mapper.readTree(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Determine the dimensions of the string[][]
        int rows = jsonNode.size();
        int columns = jsonNode.get(0).size();

        // Create a string[][] to store the values
        String[][] array = new String[rows][columns];

        // Extract the keys from the first JSON object
        JsonNode firstObjectNode = jsonNode.get(0);
        Map<String, Object> firstObjectMap = mapper.convertValue(firstObjectNode, Map.class);
        Iterator<String> keysIterator = firstObjectMap.keySet().iterator();
        String[] keys = new String[columns];
        int index = 0;
        while (keysIterator.hasNext()) {
            keys[index++] = keysIterator.next();
        }

        // Fill the string[][] with the values from JSON
        for (int i = 0; i < rows; i++) {
            JsonNode objectNode = jsonNode.get(i);
            for (int j = 0; j < columns; j++) {
                array[i][j] = objectNode.get(keys[j]).asText();
            }
        }

        return array;  
    }
}
