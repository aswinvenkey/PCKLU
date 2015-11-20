package com.racingwheels.aswinvenkat.pcklu;

import android.location.Location;
import android.text.TextUtils;

import com.android.volley.NetworkResponse;
import com.bakar.api.APIEndpoints;
import com.bakar.api.dto.CampusResponse;
import com.bakar.api.dto.MessageDetailResponse;
import com.bakar.api.dto.MessageResponse;
import com.bakar.api.dto.PublishMessageResponse;
import com.bakar.api.dto.VoteResponse;
import com.bakar.bean.Campus;
import com.bakar.bean.Message;
import com.bakar.core.ResponseListener;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gauravarora on 12/04/15.
 */
public class BakarService extends BaseService {

    public void registerForPushNotification(String userId, String registrationId, ResponseListener<NetworkResponse> listener) {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", userId);
        params.put("registration_id", registrationId);

        executePostRequest(APIEndpoints.REGISTER_FOR_PUSH_NOTIFICATION, params, null, new TypeToken<PublishMessageResponse>() {
        }, listener);
    }

}
