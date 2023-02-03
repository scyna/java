package io.scyna;

import java.time.Instant;

public class Utils {
    private final static String PATH_REGEX = ":[A-z,0-9,$,-,_,.,+,!,*,',(,),\\,]{1,}";

    public static String subscribeURL(String urlPath) {
        String subURL = urlPath.replaceAll(PATH_REGEX, "*");
        subURL = subURL.replaceAll("/", ".");
        subURL = String.format("API%s", subURL);
        return subURL;
    }

    public static String publishURL(String urlPath) {
        var subURL = urlPath.replaceAll("/", ".");
        subURL = String.format("API%s", subURL);
        return subURL;
    }

    public static long calculateID(int prefix, long value) {
        return ((long) prefix << 44) + value;
    }

    public static long currentMicroSeconds() {
        var instant = Instant.now();
        return instant.getEpochSecond() * 1000_000 + instant.getNano() / 1000;
    }

}