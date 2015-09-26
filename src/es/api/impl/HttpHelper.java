package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.utils.StreamUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Satan on 14/09/2015.
 */
public class HttpHelper implements IHttpHelper {
    public HttpHelper() {

    }

    private String openHTTPGETConnection(String url) {
        HttpURLConnection mUrlConnection = null;
        String response = "";

        try {
            URL url_dir = new URL(url);
            mUrlConnection = (HttpURLConnection)url_dir.openConnection();
            int responseCode = mUrlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                response = StreamUtils.streamToString(mUrlConnection.getInputStream());
                FactoryMetalArchives.log.printMessage("Response string: " + response);
            }
            else {
                FactoryMetalArchives.log.printMessage("Response code: " + responseCode);
            }

        }
        catch (Exception ex) {
            FactoryMetalArchives.log.printMessage("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            if(null != mUrlConnection) {
                mUrlConnection.disconnect();
            }
        }

        return response;
    }

    @Override
    public Document getHtmlDocument(String url) {
        String res = this.openHTTPGETConnection(url);

        if(res != null) {
            return Jsoup.parse(res);
        }

        return null;
    }

    @Override
    public JSONObject getObjectJson(String url) {
        JSONObject jsonObject = null;

        try {
            return new JSONObject(this.openHTTPGETConnection(url));
        }
        catch(JSONException ex) {
            FactoryMetalArchives.log.printMessage("Couldn't read the json");
            return null;
        }

    }

    @Override
    public String getTextDocument(String url) {
        return null;
    }
}
