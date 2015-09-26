package es.api.utils;

import es.api.declarations.Configuration;
import es.api.declarations.IMetalArchivesApi;
import es.api.impl.FactoryMetalArchives;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Satan on 15/09/2015.
 */
public class StreamUtils
{
    private static String pattern = "??";

    public static String streamToString(InputStream is) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    public static String getParamURL(String urlPatter, String[] args) {
        for(String arg : args) {
            // Clear spaces in first and last
            arg = arg.trim();
            //If contain spaces
            if(arg.matches(".*\\s+.*")) {
                arg = arg.replace(" ", "+");
            }
            urlPatter = urlPatter.replaceFirst(Pattern.quote(StreamUtils.pattern), arg);
        }

        return Configuration.DOMAIN + urlPatter;
    }

    public static String getSearchFieldString(IMetalArchivesApi.SEARCH_FIELDS search_fields) {
        switch (search_fields) {
            case NAME:
                return "name";
            case GENRE:
                return "genre";
            default:
                return null;
        }
    }

    public static String getSearchTypeString(IMetalArchivesApi.SEARCH_TYPES search_types) {
        String type = "ajax-"+StreamUtils.pattern+"-search";
        switch (search_types){
            case BAND:
                return type.replace(StreamUtils.pattern, "band");
            case ALBUM:
                return type.replace(StreamUtils.pattern, "album");
            case SONG:
                return type.replace(StreamUtils.pattern, "song");
            case ARTIST:
                return type.replace(StreamUtils.pattern, "artist");
            default:
                return null;
        }
    }
}
