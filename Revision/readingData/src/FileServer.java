import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;

public class FileServer {

    private static final String SHARED_DIR = "shared/";

    public static void start(int port) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", (HttpExchange exchange) -> {

            String method = exchange.getRequestMethod();
            String fileName = exchange.getRequestURI().getPath().substring(1);
            File file = new File(SHARED_DIR + fileName);

            if (method.equalsIgnoreCase("GET")) {

                if (!file.exists()) {
                    String message = "File not found";
                    exchange.sendResponseHeaders(404, message.length());
                    exchange.getResponseBody().write(message.getBytes());
                    exchange.close();
                    return;
                }

                exchange.sendResponseHeaders(200, file.length());

                FileInputStream fileInputStream = new FileInputStream(file);
                OutputStream outputStream = exchange.getResponseBody();

                fileInputStream.transferTo(outputStream);

                fileInputStream.close();
                outputStream.close();
            }

            else if (method.equalsIgnoreCase("POST")) {

                FileOutputStream fos = new FileOutputStream(file);
                InputStream is = exchange.getRequestBody();

                is.transferTo(fos);

                fos.close();
                is.close();

                String msg = "Upload successful";
                exchange.sendResponseHeaders(200, msg.length());
                exchange.getResponseBody().write(msg.getBytes());
                exchange.close();
            }

            else {
                exchange.sendResponseHeaders(405, -1);
            }

        });

        server.start();
        System.out.println("Server started on port " + port);
        System.out.println("Sharing folder: " + new File(SHARED_DIR).getAbsolutePath());
    }
}
