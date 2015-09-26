package es.api.declarations;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

import java.util.Properties;

/**
 * Created by Satan on 14/09/2015.
 */
public interface IHttpHelper {
    public Document     getHtmlDocument (String url);
    public JSONObject   getObjectJson   (String url);
    public String       getTextDocument (String url);
}
