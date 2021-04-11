package advisor.command;

import advisor.Application;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class AuthCommand extends Command {

    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String REDIRECT_URI = "http://localhost:8080";
    private static final String AUTHORIZATION;

    private String code;

    static {
        AUTHORIZATION = new String(Base64.getEncoder().encode(String.format("%s:%s", CLIENT_ID, CLIENT_SECRET).getBytes()));
    }

    @Override
    public void execute(String[] commandArgs, String[] programArgs) {
        System.out.println("use this link to request the access code:");

        HttpServer server = null;
        try {
            server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);

            HttpServer finalServer = server;
            server.createContext("/",
                    new HttpHandler() {
                        public void handle(HttpExchange exchange) throws IOException {
                            String query = exchange.getRequestURI().getQuery();

                            String[] queryArr = new String[0];
                            if (query != null) {
                                queryArr = query.split("&");
                            }
                            for (String str : queryArr) {
                                String[] param = str.split("=");
                                if (param.length != 2) {
                                    System.out.println("wrong param!");
                                }
                                if ("code".equals(param[0])) {
                                    code = param[1];
                                }
                            }

                            String responseText;
                            if (code != null) {
                                responseText = "Got the code. Return back to your program.";
                                System.out.println("code received");
                            } else {
                                responseText = "Not found authorization code. Try again.";
                            }

                            exchange.sendResponseHeaders(200, responseText.length());
                            exchange.getResponseBody().write(responseText.getBytes());

                            exchange.getResponseBody().close();

                            if (code != null) {
                                finalServer.stop(0);
                            } else {
                                return;
                            }

                        }
                    }
            );

            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.printf("https://accounts.spotify.com/authorize?client_id=%s&redirect_uri=%s&response_type=code\n", CLIENT_ID, REDIRECT_URI);
        System.out.println("waiting for code...");


        while (code == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("making http request for access_token...");
        HttpClient client = HttpClient.newBuilder().build();

        String uri = programArgs.length >= 2 && "-access".equals(programArgs[0]) ? programArgs[1] : "https://accounts.spotify.com/api/token";

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", String.format("Basic %s", AUTHORIZATION))
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(String.format("grant_type=authorization_code&code=%s&redirect_uri=%s", code, REDIRECT_URI)))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("response:");
        System.out.println(response.body());

        Application.setActive(true);
        System.out.println("---SUCCESS---");
    }
}
