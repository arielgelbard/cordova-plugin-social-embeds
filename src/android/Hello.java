package com.example.plugin;

import org.apache.cordova.*;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;
import android.provider.Browser;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
