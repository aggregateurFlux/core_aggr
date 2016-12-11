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
	
	public static void appel_a_call() throws IOException {
		String path = "user/feed";

        HashMap<String,String> params = new HashMap<String,String>();

        params.put("access_token", "4255759889.110ab74.3d1f61e9dec8403786edc677575b2fa2");
        //params.put("content", "le message a submit");
        
        String json = callMethod("GET", path, params);
	}
	
	public static String callMethod(String method, String path, HashMap<String,String> params) throws IOException {
        URL url = new URL(INSTAGRAM_URL + path);
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
