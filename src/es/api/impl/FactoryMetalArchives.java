package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.declarations.IMetalArchivesApi;
import es.api.declarations.LoggerHTTP;
import es.api.utils.Logger;

/**
 * Created by Pablo on 14/09/2015.
 */
public class FactoryMetalArchives {
    public static IHttpHelper       httpHelper  = new HttpHelper        ();
    public static IMetalArchivesApi api         = new MetalArchivesApi  (FactoryMetalArchives.httpHelper);
    public static LoggerHTTP        log         = new Logger();


    public static void setLogger(LoggerHTTP logger) {
        FactoryMetalArchives.log = logger;
    }
}
