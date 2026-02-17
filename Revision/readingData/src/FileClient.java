import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileClient {

    public static String download(String ip, int port, String fileName) {

        try {
            URL url = new URL("http://" + ip + ":" + port + "/" + fileName);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200 || connection.getResponseCode() == 401 || connection.getResponseCode() == -1) {
                System.out.println("Download failed. Server returned: " + connection.getResponseCode());
                return ip;
            }

            InputStream inputStream = connection.getInputStream();

            FileOutputStream fileOutputStream = new FileOutputStream("downloaded" + fileName);

            inputStream.transferTo(fileOutputStream);

            inputStream.close();
            fileOutputStream.close();

            System.out.println("Downloaded: " + fileName);

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return ip;
    }
}
