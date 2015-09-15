package es.api.impl;

import com.google.gson.JsonArray;
import es.api.declarations.IHttpHelper;
import es.api.utils.StreamUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Pablo on 14/09/2015.
 */
public class HttpHelper implements IHttpHelper {

    private HttpURLConnection mUrlConnection;

    private String openHTTPGETConnection(String url) {
        this.mUrlConnection = null;
        String response = "";

        try {
            URL url_dir = new URL(url);
            this.mUrlConnection = (HttpURLConnection)url_dir.openConnection();
            int responseCode = this.mUrlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                response = StreamUtils.streamToString(this.mUrlConnection.getInputStream());
                FactoryMetalArchives.log.printMessage("Response string: " + response);
            }
            else {
                FactoryMetalArchives.log.printMessage("Response code: " + responseCode);
            }

        }
        catch (Exception ex) {
            FactoryMetalArchives.log.printMessage("Ha ocurrido un error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            if(null != this.mUrlConnection) {
                this.mUrlConnection.disconnect();
            }
        }

        return response;
    }

    @Override
    public Document getHtmlDocument(String url) {
        String res = this.openHTTPGETConnection(url);

        if(res != null) {
            Document doc = Jsoup.parse(res);

            return doc;
        }

        return null;
    }

    @Override
    public JsonArray getObjectJson(String url) {
        return null;
    }
}
