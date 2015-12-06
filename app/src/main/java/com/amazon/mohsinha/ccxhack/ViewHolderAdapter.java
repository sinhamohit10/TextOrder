/*******************************************************************************
 * Copyright 2013 Gabriele Mariotti
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.amazon.mohsinha.ccxhack;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Rating;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Good Adapter.
 * 
 * 
 */
public class ViewHolderAdapter extends ArrayAdapter<MyObj> {

	private static String TAG = "RecycleAdapter";

	private MainActivity mContext;
	private LayoutInflater mInflater;
	private GestureDetector gdt;

	public ViewHolderAdapter(MainActivity context, int textViewResourceId, GestureDetector gdt) {
		super(context, textViewResourceId);
		mContext = context;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.gdt = gdt;
	}

	static class ViewHolder {
		TextView name;
		TextView title;
		ImageView imageView;
		TextView reorder;
		TextView desc;
		TextView asin;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		Log.d(TAG, "position=" + position);

		final ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, parent, false);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.title = (TextView) convertView
					.findViewById(R.id.title);
			convertView.setTag(holder);
			holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
			holder.desc = (TextView) convertView.findViewById(R.id.desc);
			holder.reorder = (TextView)  convertView.findViewById(R.id.reorder);
			holder.asin = (TextView)  convertView.findViewById(R.id.asin);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		MyObj data = getItem(position);
		holder.name.setText(data.name);
		holder.title.setText(data.title);
		holder.imageView.setImageBitmap(getImage(data.getImage()));
		holder.desc.setText("Price: $" + data.getDesc() + "\nRating: " + data.getRating());
		holder.reorder.setText(data.getReorder());
		holder.asin.setText(data.asin);
		if(data.getImage()==null){
			holder.imageView.setVisibility(View.GONE);
		}else{
			holder.imageView.setVisibility(View.VISIBLE);
		}

		if(data.getDesc()==null){
			holder.desc.setVisibility(View.GONE);
		}else{
			holder.desc.setVisibility(View.VISIBLE);
		}
		if(data.getReorder()==null){
			holder.reorder.setVisibility(View.GONE);
		}else{
			holder.reorder.setVisibility(View.VISIBLE);
		}
		holder.asin.setVisibility(View.GONE);

		convertView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				gdt.onTouchEvent(event);
				// TODO Auto-generated method stub
				return false;
			}

		});
		convertView.setLongClickable(true);
		return convertView;

	}
	private Bitmap getImage(String url){
		Bitmap bitmap = null;

		try {
			if(url!=null) {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}

}