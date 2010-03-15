package com.example.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

public class GalleryActivity extends Activity {

	private ImageSwitcher imageSwitcher;
	Gallery gallery;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_activity);
		
		imageSwitcher = (ImageSwitcher)findViewById(R.id.ImageSwitcher01);
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView imageView = new ImageView(GalleryActivity.this);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				return imageView;
			}
			
		});
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		imageSwitcher.setImageResource(R.drawable.g01);
		
		gallery = (Gallery) findViewById(R.id.Gallery01);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				imageSwitcher.setImageResource((int)gallery.getItemIdAtPosition(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
			
		});
		gallery.setAdapter(new BaseAdapter() {

			private Integer[] imageIds = {
					R.drawable.g01,
					R.drawable.g02,
					R.drawable.g03,
					R.drawable.g04,
					R.drawable.g05,
					R.drawable.g06,
					R.drawable.g07,
					R.drawable.g08,
			};

			@Override
			public int getCount() {
				return imageIds.length;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return imageIds[position];
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView = new ImageView(GalleryActivity.this);
				imageView.setImageResource(imageIds[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(66, 100));
				return imageView;
			}
			
		});
	}

}
