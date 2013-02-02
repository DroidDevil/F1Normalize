package com.droiddevil.f1normalize.util;

import java.io.InputStream;
import java.util.Scanner;

public class IOUtil {

    public static String streamToString(InputStream is) {
        Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
