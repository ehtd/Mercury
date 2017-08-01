package io.ernesto.mercury;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Fetcher {

    private String baseURL;

    public Fetcher(String baseURL) {
        this.baseURL = baseURL;
    }

    public String fetch(String segment) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(this.baseURL + segment);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();

        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }
}
