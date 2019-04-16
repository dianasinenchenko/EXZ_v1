//package com.devitis.exz_v1.ui.kip.view;
//
//import android.app.Fragment;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//
//import com.devitis.exz_v1.R;
//import com.devitis.exz_v1.data.models.KIPModel;
//import com.devitis.exz_v1.ui.kip.presenter.KIPPresenter;
//import com.devitis.exz_v1.ui.utils.EndlessRecyclerViewScrollListener;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by Diana on 15.04.2019.
// */
//
//public class KIPFragment extends Fragment implements IKIPView {
//
//    @BindView(R.id.rv_kips)
//    RecyclerView recycler;
//
//    @BindView(R.id.progress_characters)
//    ProgressBar progressBar;
//
//    private EndlessRecyclerViewScrollListener scrollListener;
//
//
//    private String TAG = KIPFragment.class.getName();
//
//    private KIPPresenter kipPresenter;
//
//    public KIPFragment() {
//        this.kipPresenter = new KIPPresenter(this);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_kips, container, false);
//        ButterKnife.bind(this, view);
//        kipPresenter.loadKIPs();
//        return view;
//    }
//
////    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void setRecyclerAdapter(List<KIPModel> kipModels) {
//        progressBar.setVisibility(View.GONE);
//        recycler.setVisibility(View.VISIBLE);
//        KIPAdapter kipAdapter = new KIPAdapter(kipModels, getContext());
//        recycler.setAdapter(kipAdapter);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recycler.setLayoutManager(linearLayoutManager);
//        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                Log.d(TAG, "onLoadMore...");
//            }
//        };
//        recycler.addOnScrollListener(scrollListener);
//    }
//
//    @Override
//    public void onKIPsLoadSuccess(List<KIPModel> kipModelsList) {
//
//        Log.d(TAG, "Received kips " + kipModelsList.size());
//        setRecyclerAdapter(scrollListener);
//
//    }
//
//    @Override
//    public void onKIPsLoadError() {
//
//    }
//}
