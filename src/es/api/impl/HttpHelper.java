package es.api.impl;

import com.google.gson.JsonArray;
import es.api.declarations.IHttpHelper;
import org.jsoup.nodes.Document;

/**
 * Created by Pablo on 14/09/2015.
 */
public class HttpHelper implements IHttpHelper {

    @Override
    public Document getHtmlDocument(String url) {
        return null;
    }

    @Override
    public JsonArray getObjectJson(String url) {
        return null;
    }
}
