package com.ionberges.scannerqr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QRCodeActivity extends Activity {

	Button b1;
	TextView t1, t2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				startActivityForResult(intent, 0);

			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {

		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {

				String contents = intent.getStringExtra("SCAN_RESULT");
				t1.setText(contents);
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				t2.setText(format);

			} else if (resultCode == RESULT_CANCELED) {

				Log.i("App", "Scan unsuccessful");
			}
		}
	}

}