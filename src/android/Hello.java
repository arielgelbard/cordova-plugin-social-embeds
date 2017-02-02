package com.example.plugin;

import org.apache.cordova.*;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

@SuppressLint("SetJavaScriptEnabled")
public class Hello extends CordovaPlugin {
    
     CordovaWebView openWebView;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("greet")) {

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
    
    @Override
    public void initialize (CordovaInterface cordova, CordovaWebView webView) {
         openWebView = webView;
    }

    @Override
    public boolean onOverrideUrlLoading(String url) {
    	Log.d("OpenBlank", "onOverrideUrlLoading called with URL " + url);

        try {
            // This will execute openLinkInAppBrowser function defined in your javascript 
            openWebView.loadUrl("javascript:openLinkInAppBrowser('"+ url +"')");
        } catch (android.content.ActivityNotFoundException e) {
                Log.d("OpenBlank", "OpenBlank: Error loading url "+url+":"+ e.toString());
                return true;
        }

   		return true;
    }
}
