package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.declarations.IMetalArchivesApi;
import es.api.models.Album;
import es.api.models.Band;
import es.api.utils.StreamUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Satan on 14/09/2015.
 */
public class MetalArchivesApi implements IMetalArchivesApi {

    public MetalArchivesApi() {

    }

    @Override
    public List<Album> findAlbumsByIdBand(String id) {
        String uri = StreamUtils.getParamURL("band/discography/id/??/tab/all", new String[]{id});
        FactoryMetalArchives.log.printMessage(uri);
        Document doc = FactoryMetalArchives.httpHelper.getHtmlDocument(uri);

        List<Album> albums = null;

        if(doc != null) {
            Elements thbody = doc.getElementsByTag("tbody");
            Elements albumRows = thbody.get(0).getElementsByTag("tr");

            albums = new ArrayList<>();

            for(Element e: albumRows) {
                Elements cols = e.getElementsByTag("td");

                Album album = new Album();

                album.setName(cols.get(0).getElementsByTag("a").html());
                album.setUrlInfo(cols.get(0).getElementsByTag("a").attr("href"));
                album.setType(cols.get(1).html());
                album.setYear(cols.get(2).html());

                albums.add(album);
            }
        }

        return albums;
    }

    @Override
    public JSONArray find(String identifier, SEARCH_TYPES search_type, SEARCH_FIELDS search_fields) {
        String by = StreamUtils.getSearchTypeString(search_type);
        String field = StreamUtils.getSearchFieldString(search_fields);
        String uri = StreamUtils.getParamURL("/search/??/?field=??&query=??", new String[]{by, field, identifier});

        FactoryMetalArchives.log.printMessage(uri);

        try {
            return FactoryMetalArchives.httpHelper.getObjectJson(uri).getJSONArray("aaData");
        } catch(JSONException ex) {
            FactoryMetalArchives.log.printMessage("There is not field 'aaData' in json");
            return null;
        }
    }
}
