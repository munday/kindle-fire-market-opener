package ws.munday.KFMarketIcon;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class KFMarketActivity extends Activity {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				launchMarket();
				finish();
			}
		}, 100);
		super.onCreate(savedInstanceState);
	}

	private boolean isCallable(Intent intent) {
	    List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
	    return list.size() > 0;
    }
	
	private void launchMarket(){
		final Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
		if(isCallable(LaunchIntent)){
			startActivity(LaunchIntent);
    	}else{
        	Toast t = Toast.makeText(this, R.string.no_store, Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        }
	}
}