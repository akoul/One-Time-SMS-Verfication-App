package com.example.yo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Code extends Activity implements OnClickListener {

	EditText code;
	Button b;
	public static MainActivity ma = new MainActivity();
	String code1 = ma.getcode();
	String code2;
	Button close;
	PopupWindow pwindo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verify);
		code = (EditText) findViewById(R.id.etcode);

		b = (Button) findViewById(R.id.btverify);
		b.setOnClickListener(this);
		// Intent i = getIntent();
		// Bundle b = i.getExtras();
		// phno1 = b.getString("key");

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		code2 = code.getText().toString();

		if (code1.equalsIgnoreCase(code2)) {
			// Toast.makeText(getBaseContext(), "Verification Complete",
			// Toast.LENGTH_SHORT).show();
			initiatePopupWindow();
		} else {
			Toast.makeText(getBaseContext(), "Incorrect code Entered",
					Toast.LENGTH_SHORT).show();
		}
	}

	private void initiatePopupWindow() {
		try {
			LayoutInflater inflater = (LayoutInflater) Code.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup,
					(ViewGroup) findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout, 300, 370, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			pwindo.setAnimationStyle(R.style.popwin_anim_style);
			close = (Button) layout.findViewById(R.id.btclose);
			close.setOnClickListener(cancel_button_click_listener);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();

		}
	};

}
