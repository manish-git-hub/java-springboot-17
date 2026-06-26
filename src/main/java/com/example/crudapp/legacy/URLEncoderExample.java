package com.example.crudapp.legacy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;

/**
 * This class uses deprecated URLEncoder/URLDecoder methods
 * that don't specify charset and rely on platform default encoding
 */
public class URLEncoderExample {
    
    @SuppressWarnings("deprecation")
    public String encodeUrl(String url) {
        // This method is deprecated - should use URLEncoder.encode(String, Charset)
        return URLEncoder.encode(url);
    }
    
    @SuppressWarnings("deprecation")
    public String decodeUrl(String url) {
        // This method is deprecated - should use URLDecoder.decode(String, Charset)
        return URLDecoder.decode(url);
    }
    
    // Old way with String charset that throws checked exception
    public String encodeUrlOldWay(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "UTF-8");
    }
    
    public String decodeUrlOldWay(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, "UTF-8");
    }
    
    // Complex nested encoding that needs migration
    @SuppressWarnings("deprecation")
    public String complexEncoding(String param1, String param2) {
        String encoded1 = URLEncoder.encode(param1);
        String encoded2 = URLEncoder.encode(param2);
        return encoded1 + "&" + encoded2;
    }
}

// Made with Bob
