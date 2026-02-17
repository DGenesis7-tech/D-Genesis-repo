import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class CloudDataReader {

    public static String readDataFrom(String cloudLocation){
        URL uri = null;
        try {
            uri = URI.create(cloudLocation).toURL();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(uri.openStream()))){
            StringBuilder data = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                data.append(line).append("\n");
            }
            return data.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

