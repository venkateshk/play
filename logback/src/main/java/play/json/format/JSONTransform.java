package play.json.format;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author vkavuluri
 */
public class JSONTransform {

    static Logger logger = LoggerFactory.getLogger("play.json.format");


    public static void main(String[] args) throws IOException {

        String sampleJson1 = "{  \n" +
                "  \"ID\":\"SGML\",\n" +
                "  \"SortAs\":\"SGML\",\n" +
                "  \"GlossTerm\":\"Standard Generalized Markup Language\",\n" +
                "  \"Acronym\":\"SGML\",\n" +
                "  \"Abbrev\":\"ISO 8879:1986\"\n" +
                "}";

        String sampleJson2 = "{\n" +
                "\t\"id\": \"0001\",\n" +
                "\t\"type\": \"donut\",\n" +
                "\t\"name\": \"Cake\",\n" +
                "\t\"ppu\": 0.55,\n" +
                "\t\"batters\":\n" +
                "\t\t{\n" +
                "\t\t\t\"batter\":\n" +
                "\t\t\t\t[\n" +
                "\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                "\t\t\t\t]\n" +
                "\t\t},\n" +
                "\t\"topping\":\n" +
                "\t\t[\n" +
                "\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                "\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t]\n" +
                "}";

        String sampleJson = "{\n" +
                "    \"input_signals\": {\n" +
                "        \"id\": \"fpti_x\",\n" +
                "        \"referrer_search_keyword\": \"ref\",\n" +
                "        \"client_os\": \"os2\",\n" +
                "        \"browser_type\": \"br1\",\n" +
                "        \"model_specific”\": [\n" +
                "            {\n" +
                "                \"id\": \"send_money_p2p\",\n" +
                "                \"foo_sm\": \"bar_sm_1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"invoice\",\n" +
                "                \"foo_in\": \"bar_in\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"meta\" : \"meta1\"\n" +
                "}";

        logger.debug(sampleJson);

        Map map;

        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(sampleJson,
                new TypeReference<HashMap<String, Object>>() {
                });

        logger.debug(String.valueOf(map.size()));


        Map<String, Object> map1 = new LinkedHashMap<String, Object>();
        map1.put("ID", "SGML");
        map1.put("SortAs", "SGML");
        map1.put("GlossTerm", "Standard Generalized Markup Language");
        map1.put("Acronym", "SGML");
        map1.put("Abbrev", "ISO 8879:1986");


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map1);

        logger.info(json);





    }

}
