/**
 *  Plugin PhoneNavigator
 *
 *  Copyright (c) 2013 Dave Alden - Working Edge Ltd.
 *  
**/

package org.apache.cordova.plugin;

import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

public class PhoneNavigator extends CordovaPlugin {

	private static final String LOG_TAG = "PhoneNavigator";

	
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		boolean result;
		Log.d(LOG_TAG, "Executing PhoneNavigator Plugin");
		if ("doNavigate".equals(action)){						
			result = this.doNavigate(args);
		} else {
			Log.d(LOG_TAG, "Invalid action");
			result = false;
		}
		if(result == true){
			callbackContext.success();
		}
		return result;
	}

	
	private boolean doNavigate(JSONArray args){
		boolean result;
		
		try {
			String lat = args.getString(0);
        	String lon = args.getString(1);
        	
        	if (lat != null && lat.length() > 0 && lon != null && lon.length() > 0) {
        		Log.d(LOG_TAG, "Navigating to lat="+lat+", lon="+lon);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + lat +","+ lon)); 
                this.cordova.getActivity().startActivity(i);
                result = true;
            } else {            	
            	Log.d(LOG_TAG, "Expected two non-empty string arguments for lat and lon." );
            	result = false;
            }        	
		}catch( JSONException e ) {
			Log.d(LOG_TAG, "Exception occurred: ".concat(e.getMessage()));
        	result = false;
		}        
        return result;
    }

}