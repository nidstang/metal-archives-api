package es.api.utils;

import es.api.declarations.Configuration;
import es.api.declarations.IMetalArchivesApi;
import es.api.impl.FactoryMetalArchives;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by Satan on 15/09/2015.
 */
public class StreamUtils
{
    public static String streamToString(InputStream is) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    public static String getParamURL(String urlPatter, String[] args) {
        String strFinal = "";
        for(String arg : args) {
            // Clear spaces in first and last
            arg = arg.trim();
            //If contain spaces
            if(arg.matches(".*\\s+.*")) {
                arg = arg.replaceAll(" ", "+");
            }
            strFinal = urlPatter.replace("??", arg);
        }

        return Configuration.DOMAIN + strFinal;
    }

    public static String getSearchTypeString(IMetalArchivesApi.SEARCH_TYPES search_types) {
        switch (search_types){
            case BAND_NAME:
                return "band_name";
            case BAND_GENRE:
                return "band_genre";
            case ALBUM_TITLE:
                return "album_title";
            case SONG_TITLE:
                return "song_title";
            case ARTIST:
                return "artist_alias";
            default:
                return null;
        }
    }
}
