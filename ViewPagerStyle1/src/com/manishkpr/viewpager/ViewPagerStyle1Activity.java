package com.manishkpr.viewpager;


import com.google.android.maps.MapView;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class ViewPagerStyle1Activity extends FragmentActivity {
	private ViewPager _mViewPager;
	private ViewPagerAdapter _adapter;

	
	View mMapViewContainer;
	MapView mMapView;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setUpView();
		setTab();
		
		mMapViewContainer = LayoutInflater.from( this ).inflate( R.layout.layout_two, null );
		mMapView = (MapView)mMapViewContainer.findViewById( R.id.map );
	}

	private void setUpView() {
		_mViewPager = (ViewPager) findViewById(R.id.viewPager);
		_adapter = new ViewPagerAdapter(getApplicationContext(),
				getSupportFragmentManager());
		_mViewPager.setAdapter(_adapter);
		_mViewPager.setCurrentItem(0);
		_mViewPager.setOffscreenPageLimit(0);
		
	}

	private void setTab() {
		_mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			public void onPageScrollStateChanged(int position) {
				Log.d("FragmentActivity", "setOnPageChangeListener") ;
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
				Log.d("FragmentActivity", "onPageScrolled") ;
			}

			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					findViewById(R.id.first_tab).setVisibility(View.VISIBLE);
					findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.third_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.fourth_tab).setVisibility(View.INVISIBLE);
					break;

				case 1:
					findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.second_tab).setVisibility(View.VISIBLE);
					findViewById(R.id.third_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.fourth_tab).setVisibility(View.INVISIBLE);
					break;
				case 2:
					findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.third_tab).setVisibility(View.VISIBLE);
					findViewById(R.id.fourth_tab).setVisibility(View.INVISIBLE);
					break;
					
				case 3:
					findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.third_tab).setVisibility(View.INVISIBLE);
					findViewById(R.id.fourth_tab).setVisibility(View.VISIBLE);
					break;
					
					
				}
			}

		});

	}
}