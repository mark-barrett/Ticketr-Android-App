package com.markbarrettdesign.ticketrv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark Barrett on 18/04/2017.
 * Copyright 2017 Ticketr Android App V1.0
 */

public class CheckInRequest extends StringRequest {
    private static final String CHECK_IN_REQUEST_URL = "http://178.62.41.17/api/validate-ticket/";
    private Map<String, String> params;

    public CheckInRequest(String qrcode, Response.Listener<String> listener) {
        super(Request.Method.POST, CHECK_IN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("order_code", qrcode);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
