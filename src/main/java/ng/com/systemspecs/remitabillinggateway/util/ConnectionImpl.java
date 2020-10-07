package ng.com.systemspecs.remitabillinggateway.util;


import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ng.com.systemspecs.remitabillinggateway.configuration.Credentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * The <tt>ConnectionImpl</tt> class implements the three methods <tt>Connection</tt> for establishing HTTP connection with Remita
 * Billing Gateway APIs.
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public class ConnectionImpl implements Connection {

    public final static String GET_METHOD = "GET";

    public final static String POST_METHOD = "POST";

    @Override
    public String sendGET(String url, Credentials credentials) throws Exception {
        StringBuffer response = null;

        URL obj;
        obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(GET_METHOD);
        con.setConnectTimeout(credentials.getConnectionTimeOut());
        con.setReadTimeout(credentials.getReadTimeOut());
        con.setRequestProperty("publicKey", credentials.getPublicKey());
        con.setRequestProperty("transactionId", credentials.getTransactionId());
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            response = getStringBuffer(con);
        }
        return response.toString();
    }

    @Override
    public String sendPOST(String urlString, Credentials credentials, Object payloadObject) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return makePostCall(con, credentials, payloadObject);
    }

    @Override
    public String sendPOSTWithHash(String urlString, Credentials credentials, Object payloadObject, String transHash) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("TXN_HASH", transHash);
        return makePostCall(con, credentials, payloadObject);
    }

    private String makePostCall(HttpURLConnection con, Credentials credentials, Object payloadObject) throws IOException {
        StringBuffer response = null;
        String payload = new Gson().toJson(payloadObject);
        con.setRequestMethod(POST_METHOD);
        con.setConnectTimeout(credentials.getConnectionTimeOut());
        con.setReadTimeout(credentials.getReadTimeOut());
        con.setRequestProperty("publicKey", credentials.getPublicKey());
        con.setRequestProperty("transactionId", credentials.getTransactionId());
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setConnectTimeout(credentials.getConnectionTimeOut());
        con.setReadTimeout(credentials.getReadTimeOut());
        con.setDoOutput(true);
        OutputStreamWriter os = new OutputStreamWriter(con.getOutputStream());
        os.write(payload.toString());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            response = getStringBuffer(con);
        }
        return response.toString();
    }


    private StringBuffer getStringBuffer(HttpURLConnection con) throws IOException {
        StringBuffer response;BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response;
    }

}
