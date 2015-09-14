package es.api.impl;

import es.api.declarations.IHttpHelper;
import es.api.declarations.IMetalArchivesApi;

/**
 * Created by Pablo on 14/09/2015.
 */
public class FactoryMetalArchives {
    public static IHttpHelper       httpHelper  = new HttpHelper        ();
    public static IMetalArchivesApi api         = new MetalArchivesApi  (FactoryMetalArchives.httpHelper);
}
