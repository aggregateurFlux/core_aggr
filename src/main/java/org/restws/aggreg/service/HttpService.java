package org.restws.aggreg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map.Entry;

public class HttpService {
	
	public static String callMethod(String method, String path, HashMap<String,String> params) throws IOException {
		
		URL myURL = new URL( path );
		HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
		
		
		for(Entry<String, String> entry : params.entrySet()) {
			myURLConnection.setRequestProperty( entry.getKey() , entry.getValue() );
        }
		
		myURLConnection.setRequestMethod( method );
		myURLConnection.setDoInput(true);
		myURLConnection.setDoOutput(true);

        InputStream in = myURLConnection.getInputStream();
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
