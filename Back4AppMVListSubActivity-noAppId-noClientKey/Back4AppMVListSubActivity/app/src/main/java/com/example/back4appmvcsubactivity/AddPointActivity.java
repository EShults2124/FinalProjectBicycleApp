package com.example.back4appmvcsubactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPointActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addpoint);

	}

	public void saveLocation(View view) {
		Bundle bundle = new Bundle();
		EditText editLatitud = (EditText) findViewById(R.id.edit_latitud);
		EditText editLongitud = (EditText) findViewById(R.id.edit_longitud);
		EditText editkmTotales = (EditText) findViewById(R.id.edit_kmTotales);
		EditText editkmClima = (EditText) findViewById(R.id.edit_clima);
		EditText edit_duracionEnMinutos = (EditText) findViewById(R.id.edit_duracionEnMinutos);

		String longitud = editLongitud.getText().toString();
		String latitud = editLatitud.getText().toString();
		String kmTotales = editkmTotales.getText().toString();
		String clima = editkmClima.getText().toString();
		String duracionEnMinutos = edit_duracionEnMinutos.getText().toString();

		double lon =  Double.valueOf(longitud);
		double lat =  Double.valueOf(latitud);
		double km =  Double.valueOf(kmTotales);
		String climate =  clima;
		int min = Integer.parseInt(duracionEnMinutos);


		bundle.putDouble("longitud", lon);
		bundle.putDouble("latitud", lat);
		bundle.putDouble("kmTotales", km);
		bundle.putString("clima", climate);
		bundle.putInt("duracionEnMinutos", min);

		Intent intent = new Intent();
		intent.putExtras(bundle);
		setResult(RESULT_OK, intent);
		finish();
	}
}
