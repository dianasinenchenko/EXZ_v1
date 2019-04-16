//package com.devitis.exz_v1.ui.kip.view;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.devitis.exz_v1.R;
//import com.devitis.exz_v1.data.models.KIPModel;
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
//public class KIPAdapter extends RecyclerView.Adapter<KIPAdapter.ViewHolder> {
//
//    private List<KIPModel> kipModelList;
//    private Context context;
//
//    public KIPAdapter(List<KIPModel> kipModelList, Context context) {
//        this.kipModelList = kipModelList;
//        this.context = context;
//    }
//
//
//    @Override
//    public KIPAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View kipView = inflater.inflate(R.layout.item_kip, parent, false);
//
//        return new ViewHolder(kipView);
//    }
//
//    @Override
//    public void onBindViewHolder(KIPAdapter.ViewHolder holder, int position) {
//
//        KIPModel kipModel = kipModelList.get(position);
//
//        TextView tvName = holder.nameTextView;
//
//        tvName.setText(kipModel.getName());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return kipModelList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.tv_kip_name)
//        public TextView nameTextView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            ButterKnife.bind(this, itemView);
//        }
//    }
//}
