package ws.munday.KFMarketIcon;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class KFMarketActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        
        if(isCallable(LaunchIntent)){
    		startActivity( LaunchIntent );
        }else{
        		Toast t = Toast.makeText(this, "Could not find the Android Market App, do you have it installed?", Toast.LENGTH_LONG);
            	t.setGravity(Gravity.CENTER, 0, 0);
            	t.show();
        }
        
        finish();
        
    }
    
    private boolean isCallable(Intent intent) {
	    List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, 
	        PackageManager.MATCH_DEFAULT_ONLY);
	    return list.size() > 0;
}
}