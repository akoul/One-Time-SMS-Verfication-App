package com.example.yo;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button b;
	EditText pno;
	public static String code = String
			.valueOf((int) (Math.random() * 9000) + 1000);
	String phno;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pno = (EditText) findViewById(R.id.etphoneno);
		b = (Button) findViewById(R.id.bt1);
		b.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		phno = pno.getText().toString();
		if (phno.length() == 10) {
			sendSMS(phno);
		} else {
			Toast.makeText(getBaseContext(), "Enter 10 digit mobile Number",
					Toast.LENGTH_SHORT).show();
		}
		// Bundle b = new Bundle();
		// b.putString("key", phno);
		Intent i = new Intent(MainActivity.this, Code.class);
		// i.putExtras(b);
		startActivity(i);
	}

	private void sendSMS(String phno) {
		// TODO Auto-generated method stub
		// Intent intent = new Intent(this, SMSReceiver.class);
		// PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
				SMS.class), 0);
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phno, null, "Verification code is " + code, pi,
				null);
	}

	public String getcode() {
		return code;
	}
}
