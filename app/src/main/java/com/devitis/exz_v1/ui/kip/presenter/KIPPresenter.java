package com.devitis.exz_v1.ui.kip.presenter;

import com.devitis.exz_v1.data.models.KIPModel;
import com.devitis.exz_v1.ui.kip.ineractor.IKIPInteractor;
import com.devitis.exz_v1.ui.kip.ineractor.KIPInteractor;
import com.devitis.exz_v1.ui.kip.view.IKIPView;

import java.util.List;

/**
 * Created by Diana on 15.04.2019.
 */

public class KIPPresenter implements IKIPPresenter, IKIPInteractor {

    private KIPInteractor interactor;

    private IKIPView view;

    public KIPPresenter(IKIPView view) {
        this.interactor = new KIPInteractor(this);
        this.view = view;
    }

    @Override
    public void loadKIPs() {

        interactor.getKIPsFromAPI();

    }

    @Override
    public void onNetworkSuccess(List<KIPModel> kipModelsList) {

        view.onKIPsLoadSuccess(kipModelsList);
    }

    @Override
    public void onNetworkFailure() {

        view.onKIPsLoadError();

    }
}
