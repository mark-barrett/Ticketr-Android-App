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

public class TicketRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://178.62.41.17/api/tickets/";
    private Map<String, String> params;

    public TicketRequest(String username, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
