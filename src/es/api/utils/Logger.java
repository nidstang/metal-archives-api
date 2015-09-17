package es.api.utils;

import es.api.declarations.Configuration;
import es.api.declarations.LoggerHTTP;

/**
 * Created by Satan on 15/09/2015.
 */
public class Logger implements LoggerHTTP
{
    @Override
    public void printMessage(String msg) {
        if(Configuration.DEBUG) {
            System.out.println("Debug: " + msg);
        }
    }
}
