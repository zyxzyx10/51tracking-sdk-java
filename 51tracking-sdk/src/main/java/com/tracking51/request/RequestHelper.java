package com.tracking51.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracking51.Tracking51;
import com.tracking51.utils.JsonUtils;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class RequestHelper {

    private String apiBaseUrl = "api.51Tracking.com";

    private String apiVersion = "v4";

    private Integer apiPort = 443;

    private String url;

    private Map<String, String> headers;

    protected ObjectMapper objectMapper;

    public RequestHelper(){
        this.objectMapper = new ObjectMapper();
    }

    private void setRequestUrl(String path) {
        String port = apiPort == 443 ? "https" : "http";
        this.url = port + "://" + apiBaseUrl + "/" + apiVersion + path;
    }

    private void setRequestHeader(String apiKey) {
        this.headers = new HashMap<>();
        this.headers.put("Content-Type", "application/json");
        this.headers.put("Accept", "application/json");
        this.headers.put("Tracking-Api-Key", apiKey);
    }

    public <T> String sendApiRequest(String path, String method, T queryParam, T requestData) throws IOException{

        setRequestUrl(path);

        setRequestHeader(Tracking51.apiKey);

        HttpURLConnection connection = null;
        try {

            trustAllHosts();

            if (queryParam!=null){
                url += "?" + JsonUtils.convertToQueryString(queryParam);
            }

            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod(method);

            if (requestUrl.getProtocol().toLowerCase().equals("https")) {
                ((HttpsURLConnection) connection).setHostnameVerifier(DO_NOT_VERIFY);
            }

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            if (requestData != null) {
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                String requestBody = objectMapper.writeValueAsString(requestData);
                os.write(requestBody.getBytes(StandardCharsets.UTF_8));
                os.flush();
                os.close();
            }

            int responseCode = connection.getResponseCode();
            String responseBody = "";
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                responseBody = response.toString();
            }else {

                BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String errorLine;
                StringBuilder errorResponse = new StringBuilder();

                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine);
                }

                errorReader.close();

                responseBody = errorResponse.toString();
            }

            return responseBody;
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static void trustAllHosts() {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        } };
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

}
