package es.api.declarations;

import es.api.impl.FactoryMetalArchives;
import es.api.models.Album;
import es.api.models.Band;

import java.util.List;

/**
 * Created by Satan on 14/09/2015.
 */
public interface IMetalArchivesApi {
    enum SEARCH_TYPES {
        BAND_NAME,
        BAND_GENRE,
        ALBUM_TITLE,
        SONG_TITLE,
        ARTIST
    }

    List<Album> findAlbumsByIdBand  (String id);
    List<Band>  findBands           (String identifier, SEARCH_TYPES search_type);
}
