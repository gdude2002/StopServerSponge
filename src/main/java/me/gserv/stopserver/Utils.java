package me.gserv.stopserver;

/**
 * Created by Gareth on 02/12/2014.
 */
public class Utils {
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
