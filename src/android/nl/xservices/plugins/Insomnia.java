package nl.xservices.plugins;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class Insomnia extends CordovaPlugin {

  private static final String ACTION_KEEP_AWAKE = "keepAwake";
  private static final String ACTION_ALLOW_SLEEP_AGAIN = "allowSleepAgain";

  PowerManager.WakeLock wl;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_KEEP_AWAKE.equals(action)) {
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "Game TV"); // TODO add ON_AFTER_RELEASE
        wl.acquire();

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        return true;

      } else if (ACTION_ALLOW_SLEEP_AGAIN.equals(action)) {
        if (wl != null) {
          wl.release();
        }

        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        return true;

      } else {
        callbackContext.error("insomnia." + action + " is not a supported function. Did you mean '" + ACTION_KEEP_AWAKE + "'?");
        return false;
      }
    } catch (Exception e) {
      callbackContext.error(e.getMessage());
      return false;
    }
  }
}