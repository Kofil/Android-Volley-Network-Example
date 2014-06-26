package com.example.androidvolleylibrary;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button) findViewById(R.id.button1);
		btnStart.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// MakeJsonObjectRequest();
		// MakeJsonArrayRequest();
		//MakeStringRequest();
		MakePostRequest();
	}

	public void MakeJsonObjectRequest() {
		String url = "http://api.androidhive.info/volley/person_object.json";
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Loading....");
		pd.show();
		JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Method.GET,
				url, null, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject res) {
						Log.d("RES", res.toString());
						pd.dismiss();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("RES", "Error: " + error.getMessage());
						pd.dismiss();
					}
				});
		AppController.getInstance().addToRequestQueue(jsonObjRequest);
	}

	public void MakeJsonArrayRequest() {
		String url = "http://api.androidhive.info/volley/person_array.json";
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Loading....");
		pd.show();
		JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {

					@Override
					public void onResponse(JSONArray res) {
						Log.d("RES", res.toString());
						pd.dismiss();
					}

				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("RES", "ERROR: " + error.getMessage());
						pd.dismiss();
					}

				});
		AppController.getInstance().addToRequestQueue(jsonArrayRequest);
	}

	public void MakeStringRequest() {
		String url = "http://api.androidhive.info/volley/string_response.html";
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Loading....");
		pd.show();
		StringRequest stringRequest = new StringRequest(Method.GET, url,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String res) {
						Log.d("RES", res.toString());
						pd.dismiss();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("RES", "ERROR: " + error.getMessage());
						pd.dismiss();
					}
				});
		AppController.getInstance().addToRequestQueue(stringRequest);
	}

	public void MakePostRequest() {
		String url = "http://api.androidhive.info/volley/person_object.json";
		final ProgressDialog pd = new ProgressDialog(this);
		pd.setMessage("Loading....");
		pd.show();
		JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Method.POST,
				url, null, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject res) {
						Log.d("RES", res.toString());
						pd.dismiss();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.d("RES", "Error: " + error.getMessage());
						pd.dismiss();
					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();
				params.put("name", "Nantu");
				params.put("email", "nantu_bu@yahoo.com");
				params.put("password", "pass007");
				return params;
			}
		};
		AppController.getInstance().addToRequestQueue(jsonObjRequest);
	}

}
