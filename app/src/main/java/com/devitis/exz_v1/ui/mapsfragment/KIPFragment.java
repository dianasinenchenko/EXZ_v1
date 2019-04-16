package com.devitis.exz_v1.ui.mapsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devitis.exz_v1.R;


/**
 * Created by Diana on 15.04.2019.
 */

public class KIPFragment extends Fragment {

    private TextView title;
    private int index;

    public KIPFragment() { }

    public static KIPFragment newInstance(int i) {
        KIPFragment f = new KIPFragment();
        Bundle args = new Bundle();
        args.putInt("INDEX", i);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_1, container, false);
        title = (TextView) view.findViewById(R.id.title);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) index = args.getInt("INDEX", 0);

        title.setText(Sample1Adapter.TITLES[index]);
    }
}
