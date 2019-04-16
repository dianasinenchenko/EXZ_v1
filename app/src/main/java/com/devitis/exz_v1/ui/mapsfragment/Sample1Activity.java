//package com.devitis.exz_v1.ui.mapsfragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//
//import com.devitis.exz_v1.R;
//import com.github.nitrico.mapviewpager.MapViewPager;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.Marker;
//
//public class Sample1Activity extends AppCompatActivity implements MapViewPager.Callback {
//
//    private MapViewPager mapViewPager;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sample_1);
//        mapViewPager = (MapViewPager) findViewById(R.id.mapViewPager);
//
//        Sample1Adapter adapter = new Sample1Adapter(getSupportFragmentManager());
//        mapViewPager.start(this, adapter, this);
//    }
//
//    @Override
//    public void onMapViewPagerReady() {
//        mapViewPager.getMarker(1)
//                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//        mapViewPager.getViewPager().addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                for (int i = 0; i < mapViewPager.getMarkers().size(); i++) {
//                    Marker marker = mapViewPager.getMarker(i);
//                    if (i == position) {
//                        marker.setAlpha(1f);
//                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//                    } else {
//                        marker.setAlpha(0.5f);
//                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//
//                    }
//                }
//            }
//        });
//    }
//
//}
