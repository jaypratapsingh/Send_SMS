package com.jp.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.util.Log;

public class Send_SMS extends CordovaPlugin {

	//Plugins created by JP on 10 Feb 2014
	String phone_number, message_string;
	CallbackContext callbackContext;

	@Override
	public boolean execute(String actionString, JSONArray dataString, CallbackContext callbackContext){
		try
		{
			this.callbackContext = callbackContext;

			if(actionString.equalsIgnoreCase("SMS")){

				JSONObject json_object = dataString.getJSONObject(0);

				phone_number = json_object.getString("phone_number");
				message_string = json_object.getString("message_text");

				new SMS_Send().execute();

				return true;
			}
			else{
				callbackContext.error("Invalid");
				return false;
			}
		}
		catch(Exception e)
		{
			Log.e(null, "SMS:Plugin:Exception "+e);
			callbackContext.error(""+e);
			return false;
		}
	}

	public class SMS_Send extends AsyncTask<String, Void, Object>
	{

		@Override
		protected Object doInBackground(String... params) {

			try
			{
				// TODO Auto-generated method stub

				String numbers[] = phone_number.split(", *");
				SmsManager smsManager = SmsManager.getDefault();

				for(String number : numbers) {
					smsManager.sendTextMessage(number, null, message_string, null, null);
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		public void onPostExecute(Object object)
		{
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, "success"));
		}
	}
}
