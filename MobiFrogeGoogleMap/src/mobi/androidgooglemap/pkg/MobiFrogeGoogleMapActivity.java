package mobi.androidgooglemap.pkg;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.maps.MapView.LayoutParams;  


public class MobiFrogeGoogleMapActivity extends MapActivity {
    /** Called when the activity is first created. */
    
    MapView mapView;
    
    // CF:79:92:33:0E:49:C0:26:14:8B:2F:E4:35:B1:1A:59
    
    // 0K9OmauNMAcY9CQC08XgJq22Xhv_hyd7FHXq3Gg
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mapView = (MapView) findViewById(R.id.mapView);
     LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
     View zoomView = mapView.getZoomControls(); 
 
     zoomLayout.addView(zoomView, 
            new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, 
                LayoutParams.WRAP_CONTENT));  
     mapView.displayZoomControls(true);
        
      //mapView.setSatellite(true);
      mapView.setStreetView(true);

        
    }
    
    protected boolean isRouteDisplayed()
    {
    	return false;
    }
    
}

//http://developer.android.com/guide/components/index.html
//http://android-developers.blogspot.com/2012/05/using-dialogfragments.html