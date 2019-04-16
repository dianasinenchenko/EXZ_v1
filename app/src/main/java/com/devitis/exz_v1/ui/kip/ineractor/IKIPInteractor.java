package com.devitis.exz_v1.ui.kip.ineractor;


import com.devitis.exz_v1.data.models.KIPModel;

import java.util.List;

/**
 * Created by Diana on 15.04.2019.
 */

public interface IKIPInteractor {

    void onNetworkSuccess(List<KIPModel> kipModelsList);
    void onNetworkFailure();
}
