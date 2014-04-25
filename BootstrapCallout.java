package com.sukohi.lib;

import java.util.HashMap;
import java.util.Map;

import com.beardedhen.androidbootstrap.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BootstrapCallout extends FrameLayout {

	private static Map<String, Integer> typeColorMap;
	private static Map<String, Integer> typeBackgroundMap;
	private TextView titleTextView, descriptionTextView;
	
	static {

		typeColorMap = new HashMap<String, Integer>();
		typeColorMap.put("default", R.color.bbutton_default);
		typeColorMap.put("primary", R.color.bbutton_primary);
		typeColorMap.put("success", R.color.bbutton_success);
		typeColorMap.put("info", R.color.bbutton_info);
		typeColorMap.put("warning", R.color.bbutton_warning);
		typeColorMap.put("danger", R.color.bbutton_danger);
		typeColorMap.put("inverse", R.color.bbutton_inverse);
		
		typeBackgroundMap = new HashMap<String, Integer>();
		typeBackgroundMap.put("default", R.drawable.bcallout_default);
		typeBackgroundMap.put("primary", R.drawable.bcallout_primary);
		typeBackgroundMap.put("success", R.drawable.bcallout_success);
		typeBackgroundMap.put("info", R.drawable.bcallout_info);
		typeBackgroundMap.put("warning", R.drawable.bcallout_warning);
		typeBackgroundMap.put("danger", R.drawable.bcallout_danger);
		typeBackgroundMap.put("inverse", R.drawable.bcallout_inverse);
		
	}
	
	public BootstrapCallout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(attrs);
	}

	public BootstrapCallout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(attrs);
	}

	public BootstrapCallout(Context context) {
		super(context);
		initialize(null);
	}
	
	private void initialize(AttributeSet attrs) {
		
		LayoutInflater inflator = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapCallout);
		
		//defaults
		
		String bootstrapType = "default";
		String titleText = "";
		String descriptionText = "";
		int backgroundColor = Color.WHITE;
		float titleTextSize = 18.0f;
		float descriptionTextSize = 14.0f;
		
		//attribute values
		
		if (a.getString(R.styleable.BootstrapCallout_bc_type) != null) {
			bootstrapType = a.getString(R.styleable.BootstrapCallout_bc_type);
		}

		if(a.getString(R.styleable.BootstrapCallout_bc_title_text) != null) {
			titleText = a.getString(R.styleable.BootstrapCallout_bc_title_text);
		}

		if(a.getString(R.styleable.BootstrapCallout_bc_description_text) != null) {
			descriptionText = a.getString(R.styleable.BootstrapCallout_bc_description_text);
		}

		if(a.getString(R.styleable.BootstrapCallout_bc_title_text_size) != null) {
			titleTextSize = a.getFloat(R.styleable.BootstrapCallout_bc_title_text_size, titleTextSize);
		}

		if(a.getString(R.styleable.BootstrapCallout_bc_description_text_size) != null) {
			descriptionTextSize = a.getFloat(R.styleable.BootstrapCallout_bc_description_text_size, descriptionTextSize);
		}

		if(a.getString(R.styleable.BootstrapCallout_bc_background_color) != null) {
			backgroundColor = a.getColor(R.styleable.BootstrapCallout_bc_background_color, Color.WHITE);
		}
		
		int typeColor = getResources().getColor(typeColorMap.get(bootstrapType));
		a.recycle();
		
		View calloutView = inflator.inflate(R.layout.bootstrap_callout, null, false);
		
		View borderView = (View) calloutView.findViewById(R.id.border);
		borderView.setBackgroundColor(typeColor);
		
		titleTextView = (TextView) calloutView.findViewById(R.id.callout_title);
		descriptionTextView = (TextView) calloutView.findViewById(R.id.callout_description);

		setTitleText(titleText);
		setTitleTextSize(titleTextSize);
		setTitleTextColor(typeColor);
		
		setDescriptionText(descriptionText);
		setDescriptionTextSize(descriptionTextSize);
		
		setBackgroundColor(backgroundColor);
		
		addView(calloutView);
		
	}
	
	public void setTitleText(String text) {
		
		titleTextView.setText(text);
		
	}
	
	public void setDescriptionText(String text) {
		
		descriptionTextView.setText(text);
		
	}
	
	public void setTitleTextColor(int color) {
		
		titleTextView.setTextColor(color);
		
	}
	
	public void setTitleTextSize(float size) {
		
		titleTextView.setTextSize(size);
		
	}
	
	public void setDescriptionTextSize(float size) {
		
		descriptionTextView.setTextSize(size);
		
	}
	
}
/*** Example

	<com.sukohi.lib.BootstrapCallout
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		bootstrap:bc_title_text="@string/title"
		bootstrap:bc_description_text="@string/description"
		bootstrap:bc_type="success"
		bootstrap:bc_background_color="@color/color"
	    android:layout_marginTop="10dp" />

***/
