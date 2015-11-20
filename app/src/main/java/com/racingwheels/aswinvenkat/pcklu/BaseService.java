package com.racingwheels.aswinvenkat.pcklu;

import com.android.volley.Request;
import com.bakar.BakarApplication;
import com.bakar.core.BaseRequest;
import com.bakar.core.ResponseListener;
import com.bakar.utils.NetworkUtils;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * Created by gauravarora on 12/04/15.
 */
public class BaseService {

    protected void executeGetRequest(String url, Map<String, String> params, TypeToken typeToken, ResponseListener listener) {
        url = NetworkUtils.getUrl(url, params);
        executeRequest(Request.Method.GET, url, null, null, typeToken, listener);
    }

    protected void executePostRequest(String url, Map<String, String> params, String postContent, TypeToken typeToken, ResponseListener listener) {
        executeRequest(Request.Method.POST, url, params, postContent, typeToken, listener);
    }

    protected void executeRequest(int method, String url, Map<String, String> params, String postContent, TypeToken typeToken, ResponseListener listener) {
        BaseRequest request = new BaseRequest(method, url, params, postContent, typeToken, listener);
        BakarApplication.getInstance().addToRequestQueue(request);
    }

}
