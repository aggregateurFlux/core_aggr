package org.restws.aggreg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map.Entry;

public class HttpService {
	private static String INSTAGRAM_URL = "http://localhost:8000/";
	
	public static String callMethod(String method, String path, HashMap<String,String> params) throws IOException {
        URL url = new URL( path );
        URLConnection connection = url.openConnection();
        
        for(Entry<String, String> entry : params.entrySet()) {
            connection.setRequestProperty( entry.getKey() , entry.getValue() );
        }
        
        connection.setDoOutput(true);

        InputStream in = connection.getInputStream();
        BufferedReader res = new BufferedReader(new InputStreamReader(in, "UTF-8"));

        StringBuffer sBuffer = new StringBuffer();
        String inputLine;
        while ((inputLine = res.readLine()) != null) {
            sBuffer.append(inputLine);
        }

        res.close();

        return sBuffer.toString();
    }
}
