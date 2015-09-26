package es.api.models;

/**
 * Created by Satan on 14/09/2015.
 */
public class Album extends Model {
    private String name;
    private String type;
    private String year;
    private String urlInfo;


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
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
}
