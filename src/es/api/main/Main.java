package es.api.main;

import es.api.declarations.IMetalArchivesApi;
import es.api.impl.FactoryMetalArchives;
import es.api.impl.MetalArchivesApi;
import es.api.models.Album;
import es.api.models.Band;

import java.util.List;

/**
 * Created by Satan on 14/09/2015.
 */
public class Main {

    public static void main(String[] args) {
        //Search example
        //FactoryMetalArchives.api.find("my dying bride", MetalArchivesApi.SEARCH_TYPES.BAND, MetalArchivesApi.SEARCH_FIELDS.NAME);
        //Band.find(IMetalArchivesApi.SEARCH_FIELDS.NAME, "my dying bride");

        Band band = new Band();
        band.setId("305");

        List<Album> albums = band.getAlbums();


        for(Album a: albums) {
            System.out.println("Nombre: " + a.getName());
            System.out.println("Type: " + a.getType());
            System.out.println("Year: " + a.getYear());
            System.out.println("Url: " + a.getUrlInfo());
        }
    }
}
