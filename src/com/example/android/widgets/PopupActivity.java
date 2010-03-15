package com.example.android.widgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PopupActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		CharSequence[] list = {
			"PopupWindow",
			"Dialog",
			"AlertDialog",
			"ProgressDialog",
			"Toast",
		};
		
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
		ListView listView = (ListView)findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Button button = new Button(PopupActivity.this);
				switch (position) {
				case 0:
					button.setText("PopupWindow Close");
					final PopupWindow popupWindow = new PopupWindow(PopupActivity.this);
					popupWindow.setContentView(button);
					popupWindow.setFocusable(true);
					popupWindow.setWidth(200);
					popupWindow.setHeight(100);
					popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
					button.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							popupWindow.dismiss();
						}
						
					});
					break;
					
				case 1:
					button.setText("Dialog Close");
					final Dialog dialog = new Dialog(PopupActivity.this);
					dialog.setTitle("Dialog");
					dialog.setContentView(button);
					dialog.show();
					button.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
						
					});
					break;
					
					
				case 2:
					Builder builder = new Builder(PopupActivity.this);
					builder.setTitle("AlertDialog");
					builder.setMessage("This is alert.");
					builder.show();
					break;
					
				case 3:
					final ProgressDialog progressDialog = ProgressDialog.show(PopupActivity.this, "Working...", "Please wait for a while...");
					final Handler handler = new Handler();
					final Runnable callback = new Runnable() {

						@Override
						public void run() {
							progressDialog.dismiss();
						}
						
					};


					Thread thread = new Thread() {
						
						@Override
						public void run() {
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							handler.post(callback);
						}
						
					};
					thread.start();
					break;
					
				case 4:
					Toast.makeText(PopupActivity.this, "This is toast text.", Toast.LENGTH_SHORT).show();
					break;
				}
			}
			
		});
		
	}
}
