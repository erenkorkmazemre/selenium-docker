package common.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataHelper {


    public static Map<String, Object> getData(String key) {
        String jsonDataAsString = null;
        try {
            jsonDataAsString = new String(Files.readAllBytes(Paths.get("src/test/resources/data/Data.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonData = new JSONObject(jsonDataAsString);
        return getList(jsonData.get(key).toString());
    }

    public static LinkedHashMap<String, Object> getList(String string) {
        LinkedHashMap<String, Object> response = null;
        try {
            response = new ObjectMapper().readValue(string, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }

}
