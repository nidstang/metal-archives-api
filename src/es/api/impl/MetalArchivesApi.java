package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.declarations.IMetalArchivesApi;
import es.api.models.Album;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 14/09/2015.
 */
public class MetalArchivesApi implements IMetalArchivesApi {

    IHttpHelper http;

    public MetalArchivesApi(IHttpHelper httpHelper) {
        this.http = httpHelper;
    }

    @Override
    public List<Album> findAlbumsByIdBand(String id) {
        String uri = "http://www.metal-archives.com/band/discography/id/"+id+"/tab/all";
        Document doc = http.getHtmlDocument(uri);

        List<Album> albums = null;

        if(doc != null) {
            Elements thbody = doc.getElementsByTag("tbody");
            Elements albumRows = thbody.get(0).getElementsByTag("tr");

            albums = new ArrayList<Album>();

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
}
