package Learning.GroundZero;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class restAPI {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/hello", new MyHandler());
        server.start();
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange){
            try{
                String response = "Hello world";
                exchange.sendResponseHeaders(200,
                        response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
