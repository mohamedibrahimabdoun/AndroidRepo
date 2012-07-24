package pkgViewPagerwithListViewpages.MainActivity;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewPagerwithListViewpagesActivity extends Activity {
    /** Called when the activity is first created. */
	 private Context mContext;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.main);
        ListView listview1 = new ListView(mContext);
        ListView listview2 = new ListView(mContext);
        ListView listview3 = new ListView(mContext);
        
        Vector<View> pages = new Vector<View>();
        
        pages.add(listview1);
        pages.add(listview2);
        pages.add(listview3);
        
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        CustomPagerAdapter adapter = new CustomPagerAdapter(mContext,pages);
        vp.setAdapter(adapter);
        
        listview1.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{"A1","B1","C1","D1"}));
        listview2.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{"A2","B2","C2","D2"}));
        listview3.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1,new String[]{"A3","B3","C3","D3"}));
        
    }
}