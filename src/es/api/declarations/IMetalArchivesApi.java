package es.api.declarations;

import es.api.models.Album;

import java.util.List;

/**
 * Created by Pablo on 14/09/2015.
 */
public interface IMetalArchivesApi {
    List<Album> findAlbumsByIdBand(String id);
}
