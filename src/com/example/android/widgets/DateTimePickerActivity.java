package com.example.android.widgets;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateTimePickerActivity extends Activity {

	private TextView textView01;
	private TextView textView02;
	private Button button01;
	private Button button02;
	private DatePickerDialog datePickerDialog;
	private TimePickerDialog timePickerDialog;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_time_picker_activity);

		GregorianCalendar calendar = new GregorianCalendar();
		
		textView01 = (TextView)findViewById(R.id.TextView01);
		textView02 = (TextView)findViewById(R.id.TextView02);
		button01 = (Button)findViewById(R.id.Button01);
		button02 = (Button)findViewById(R.id.Button02);
		datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				textView01.setText(year + "/" + monthOfYear + 1 + "/" + dayOfMonth);
			}
			
		}, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		timePickerDialog = new TimePickerDialog(this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				textView02.setText((hourOfDay > 12 ? hourOfDay - 12 : hourOfDay) + ":" + minute + " " + (hourOfDay > 12 ? "PM" : "AM"));
			}
			
		}, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
		
		
		button01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				datePickerDialog.show();
			}
			
		});
		
		button02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				timePickerDialog.show();
			}
			
		});
		
	}

}
