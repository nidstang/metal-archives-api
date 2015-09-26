package es.api.models;

import es.api.declarations.IMetalArchivesApi;
import es.api.impl.FactoryMetalArchives;
import org.json.JSONArray;

import java.util.List;
import java.util.Properties;

/**
 * Created by Satan on 14/09/2015.
 */
public class Band extends Model {
    private String id;
    private String name;
    private String genre;
    private String location;
    private String urlInfo;
    private List<Album> albums;


    public Band() {
        albums = null;
    }


    public List<Album> getAlbums() {
        if(null == albums) {
            albums = FactoryMetalArchives.api.findAlbumsByIdBand(this.id);
        }

        return albums;
    }

    public static List<Band> find(IMetalArchivesApi.SEARCH_FIELDS search_by, String id) {
        JSONArray jsonArray = FactoryMetalArchives.api.find(id, IMetalArchivesApi.SEARCH_TYPES.BAND, search_by);
        if(null != jsonArray) {

        }

        return null;
    }

    /*public void loadMoreInfo() {
        FactoryMetalArchives.getApi().getMoreInfoBand(this);
    }*


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the genere
     */
    public String getGenre() {
        return genre;
    }
    /**
     * @param genere the genere to set
     */
    public void setGenre(String genere) {
        this.genre = genere;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return the urlInfo
     */
    public String getUrlInfo() {
        return urlInfo;
    }
    /**
     * @param urlInfo the urlInfo to set
     */
    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }
}
