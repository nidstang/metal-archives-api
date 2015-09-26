package es.api.declarations;

import es.api.models.Album;
import org.json.JSONArray;

import java.util.List;

/**
 * Created by Satan on 14/09/2015.
 */
public interface IMetalArchivesApi {
    enum SEARCH_TYPES {
        BAND,
        ALBUM,
        SONG,
        ARTIST
    }

    enum SEARCH_FIELDS {
        NAME,
        GENRE,
    }


    /* HTML RESPONSE */
    List<Album> findAlbumsByIdBand  (String id);
    /* JSON RESPONSE */
    JSONArray find                  (String identifier, SEARCH_TYPES search_type, SEARCH_FIELDS search_fields);
}
