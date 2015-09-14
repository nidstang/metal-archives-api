package es.api.models;

import es.api.impl.FactoryMetalArchives;

import java.util.List;

/**
 * Created by Pablo on 14/09/2015.
 */
public class Band {
    private String id;
    private String name;
    private String genere;
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
    public String getGenere() {
        return genere;
    }
    /**
     * @param genere the genere to set
     */
    public void setGenere(String genere) {
        this.genere = genere;
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
