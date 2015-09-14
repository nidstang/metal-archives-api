package es.api.declarations;

import com.google.gson.JsonArray;
import org.jsoup.nodes.Document;

/**
 * Created by Pablo on 14/09/2015.
 */
public interface IHttpHelper {
    public Document getHtmlDocument (String url);
    public JsonArray getObjectJson   (String url);
}
