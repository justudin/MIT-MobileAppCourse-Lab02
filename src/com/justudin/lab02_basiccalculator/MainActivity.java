package com.justudin.lab02_basiccalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton btnE	= (ImageButton)findViewById(R.id.btnEnter);
		btnE.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		RelativeLayout backgr 	= (RelativeLayout)findViewById(R.id.uilayout);
		ImageView img 			= (ImageView)findViewById(R.id.btnEnter);
		switch (item.getItemId()) {
		case R.id.wb:
			backgr.setBackgroundResource(R.color.white);
			return true;
		case R.id.bb:
			backgr.setBackgroundResource(R.color.black);
			return true;
		case R.id.sp:
			img.setVisibility(View.VISIBLE);
			return true;
		case R.id.hp:
			img.setVisibility(View.INVISIBLE);
			return true;	
		default:
			return super.onOptionsItemSelected(item);

		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
		startActivity(i);
	}

}
