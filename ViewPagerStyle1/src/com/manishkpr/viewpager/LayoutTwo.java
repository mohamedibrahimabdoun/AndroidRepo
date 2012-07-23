package com.manishkpr.viewpager;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutTwo extends Fragment {
	private View mMapViewContainer;
	private MapView mMapView;

	private MapController mMapController;

	public static Fragment newInstance(Context context) {
		LayoutTwo f = new LayoutTwo();
		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", 1);
		f.setArguments(args);

		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_two,
		// null);
		// return root;
		super.onCreateView(inflater, container, savedInstanceState);

		ViewPagerStyle1Activity mapActivity = (ViewPagerStyle1Activity) getActivity();
		mMapViewContainer = mapActivity.mMapViewContainer;
		mMapView = mapActivity.mMapView;
		// if( null != mMapView ) {
		// int index = getArguments().getInt( "index" );
		// Entry e = Locations.ENTRIES[1];

		mMapView.setBuiltInZoomControls(true);
		// mMapView.setSatellite( true );
		mMapView.setStreetView(true);

		mMapController = mMapView.getController();
		double lat = 15.60096045;
		double lng = 32.55840096;
		mMapController.animateTo(new GeoPoint((int) (lat * 1e6),
				(int) (lng * 1e6)));
		mMapController.setZoom(16);

		// }
		return mMapViewContainer;
	}

}
