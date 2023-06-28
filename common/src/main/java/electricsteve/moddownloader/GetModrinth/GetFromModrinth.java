package electricsteve.moddownloader.GetModrinth;

import electricsteve.moddownloader.ModDownloader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetFromModrinth {
    public static String GetNewestVersion(String projectid) {

        try {

            URL url = new URL("https://api.modrinth.com/v2/project/" + projectid);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                ModDownloader.LOGGER.info(String.valueOf(informationString));


                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));

                //Print the slug value of the response
                String slugValue = (String) dataObject.get("slug");
                return slugValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

