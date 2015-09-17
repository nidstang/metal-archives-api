package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.declarations.IMetalArchivesApi;
import es.api.models.Album;
import es.api.models.Band;
import es.api.utils.StreamUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Satan on 14/09/2015.
 */
public class MetalArchivesApi implements IMetalArchivesApi {

    private IHttpHelper http;

    public MetalArchivesApi(IHttpHelper httpHelper) {
        this.http = httpHelper;
    }

    @Override
    public List<Album> findAlbumsByIdBand(String id) {
        String uri = StreamUtils.getParamURL("band/discography/id/??/tab/all", new String[]{id});
        FactoryMetalArchives.log.printMessage(uri);
        Document doc = http.getHtmlDocument(uri);

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
    public List<Band> findBands(String identifier, SEARCH_TYPES search_type) {
        String by = StreamUtils.getSearchTypeString(search_type);
        String uri = StreamUtils.getParamURL("search?searchString=??&type=??", new String[]{identifier, by});

        FactoryMetalArchives.log.printMessage(uri);

        return null;
    }
}
