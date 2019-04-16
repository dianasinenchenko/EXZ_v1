package com.devitis.exz_v1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.devitis.exz_v1.ui.mapsfragment.KIPFragment;
import com.devitis.exz_v1.ui.mapsfragment.SKZFragment;
import com.devitis.exz_v1.ui.mapsfragment.Sample1Adapter;
import com.github.nitrico.mapviewpager.MapViewPager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MapViewPager.Callback {

    private TextView mTextMessage;
    private MapViewPager mapViewPager;

    private  TextView editButton;


    Fragment kipFragment;
    SKZFragment skzFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(kipFragment);
                    break;
                case R.id.navigation_dashboard:
                    showFragment(skzFragment);
                    break;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        kipFragment = new KIPFragment();
        skzFragment = new SKZFragment();

        showFragment(kipFragment);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mapViewPager = (MapViewPager) findViewById(R.id.mapViewPager);

        Sample1Adapter adapter = new Sample1Adapter(getSupportFragmentManager());
        mapViewPager.start(this, adapter, this);


//        editButton = (TextView) findViewById(R.id.edit);
//        editButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, EditKIPActivity.class);
//                startActivity(intent);
//            }
//        });

    }





    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_placeholder, fragment);
        fragmentTransaction.commit();
    }




    @Override
    public void onMapViewPagerReady() {

        mapViewPager.getMarker(1)
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mapViewPager.getViewPager().addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mapViewPager.getMarkers().size(); i++) {
                    Marker marker = mapViewPager.getMarker(i);
                    if (i == position) {
                        marker.setAlpha(1f);
                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    } else {
                        marker.setAlpha(0.5f);
                        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

                    }
                }
            }
        });

    }
}
