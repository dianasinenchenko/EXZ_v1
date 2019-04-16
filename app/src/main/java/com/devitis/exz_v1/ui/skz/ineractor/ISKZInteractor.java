package com.devitis.exz_v1.ui.skz.ineractor;

import com.devitis.exz_v1.data.models.SKZModel;

import java.util.List;

/**
 * Created by Diana on 15.04.2019.
 */

public interface ISKZInteractor {

    void onNetworkSuccess(List<SKZModel> skzModelsList);
    void onNetworkFailure();
}
