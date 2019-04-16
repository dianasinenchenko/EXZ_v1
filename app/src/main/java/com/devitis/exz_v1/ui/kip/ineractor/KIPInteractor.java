package com.devitis.exz_v1.ui.kip.ineractor;

import com.devitis.exz_v1.data.models.KIPModel;
import com.devitis.exz_v1.data.models.responce.KIPResponce;
import com.devitis.exz_v1.data.network.api.APIClient;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Diana on 15.04.2019.
 */

public class KIPInteractor implements Callback<KIPResponce> {

    private IKIPInteractor listener;

    private APIClient apiClient;

    public KIPInteractor(IKIPInteractor listener) {
        this.listener = listener;
        apiClient = new APIClient();
    }

    public void getKIPsFromAPI() {

        apiClient.createAPIService().getKip().enqueue(this);

    }


    @Override
    public void onResponse(Call<KIPResponce> call, Response<KIPResponce> response) {

        if (response.body().getResult() != null) {

            List<KIPModel> kipModels = response.body().getResult();
            Collections.sort(kipModels, new Comparator<KIPModel>() {
                @Override
                public int compare(KIPModel kipModel, KIPModel t1) {
                    return kipModel.getName().compareTo(t1.getName());
                }
            });

            listener.onNetworkSuccess(kipModels);
        } else {

            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<KIPResponce> call, Throwable t) {

        listener.onNetworkFailure();

    }
}
