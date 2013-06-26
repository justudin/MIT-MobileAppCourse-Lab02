package com.justudin.lab02_basiccalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity implements OnClickListener{

	Button satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,nol,koma,bagi,kali,kurang,tambah,samadengan,btnback;
	EditText hasil;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		inisialisasi();
	}

	public void inisialisasi(){
		
		//btn angka
		nol		= (Button)findViewById(R.id.btn0);
		satu 	= (Button)findViewById(R.id.btn1);
		dua		= (Button)findViewById(R.id.btn2);
		
		//btn operasi
		tambah		= (Button)findViewById(R.id.btnplus);
		samadengan	= (Button)findViewById(R.id.btnEqual);
		
		//Layar Hasil
		hasil	= (EditText)findViewById(R.id.result);
		
		//btn back
		btnback = (Button)findViewById(R.id.btnback);
		
		//setOnclick listener
		//btn angka
    	satu.setOnClickListener(this);
    	dua.setOnClickListener(this);
    	tiga.setOnClickListener(this);
    	
    	//btnproses
    	tambah.setOnClickListener(this);
    	
    	btnback.setOnClickListener(this);
    	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnback:
			Intent i = new Intent(CalculatorActivity.this, MainActivity.class);
			startActivity(i);
			break;
		case R.id.btn1:
			addAngka("1");
			break;
		default:
			break;
		}
		
	}
	private void addAngka(String a){
		String txt = hasil.getText().toString();
		txt+=a;
		hasil.setText(txt);
	}

}
