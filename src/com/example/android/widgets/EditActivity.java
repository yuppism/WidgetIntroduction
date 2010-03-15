package com.example.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class EditActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_activity);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
		
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.AutoCompleteTextView01);
		autoCompleteTextView.setAdapter(adapter);
		
		MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.MultiAutoCompleteTextView01);
		multiAutoCompleteTextView.setAdapter(adapter);
		multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		
		Spinner spinner = (Spinner)findViewById(R.id.Spinner01);
		spinner.setAdapter(adapter);
	}

}
