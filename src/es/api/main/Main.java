package es.api.main;

import es.api.impl.FactoryMetalArchives;
import es.api.models.Album;
import es.api.models.Band;

import java.util.List;

/**
 * Created by Pablo on 14/09/2015.
 */
public class Main {

    public static void main(String[] args) {
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
