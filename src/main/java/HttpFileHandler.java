import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class HttpFileHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) {
        try {
            System.out.println("new http request from " + httpExchange.getRemoteAddress() + " " + httpExchange.getRequestURI());
            InputStream inputStream = HttpFileHandler.class.getResourceAsStream("ExportObject.class");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while(inputStream.available()>0) {
                byteArrayOutputStream.write(inputStream.read());
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();
            httpExchange.sendResponseHeaders(200, bytes.length);
            httpExchange.getResponseBody().write(bytes);
            httpExchange.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
