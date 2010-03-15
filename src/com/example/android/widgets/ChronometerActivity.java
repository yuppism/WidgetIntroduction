package com.example.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class ChronometerActivity extends Activity {

	private Chronometer chronometer;
	private Button button;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chronometer_activity);

		chronometer = (Chronometer)findViewById(R.id.Chronometer01);
		chronometer.start();
		button = (Button)findViewById(R.id.Button01);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (button.getText().equals("Start")) {
					chronometer.start();
					button.setText("Stop");
				} else {
					chronometer.stop();
					button.setText("Start");
				}
			}

		});
	}

}
