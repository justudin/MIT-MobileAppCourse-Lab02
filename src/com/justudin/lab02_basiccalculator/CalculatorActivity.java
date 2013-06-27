package com.justudin.lab02_basiccalculator;
/*
 * @author justudin
 * @email <justudinlab@gmail.com>
 * @github justudin 
 * */

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends Activity implements OnClickListener{

	Button satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,nol,koma,bagi,kali,kurang,tambah,samadengan,btnback,clear;
	EditText hasil;
	double num1,num2;
	int op;
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
		tiga	= (Button)findViewById(R.id.btn3);
		empat	= (Button)findViewById(R.id.btn4);
		lima	= (Button)findViewById(R.id.btn5);
		enam	= (Button)findViewById(R.id.btn6);
		tujuh	= (Button)findViewById(R.id.btn7);
		delapan	= (Button)findViewById(R.id.btn8);
		sembilan= (Button)findViewById(R.id.btn9);
		koma 	= (Button)findViewById(R.id.btnkoma);
		
		//btn operasi
		tambah		= (Button)findViewById(R.id.btnplus);
		samadengan	= (Button)findViewById(R.id.btnEqual);
		kali		= (Button)findViewById(R.id.btnmultiply);
		bagi		= (Button)findViewById(R.id.btndiv);
		clear		= (Button)findViewById(R.id.btnClear);
		kurang		= (Button)findViewById(R.id.btnminus);
		
		//disable btn
		setEnableBtn(false);
		
		//Layar Hasil
		hasil	= (EditText)findViewById(R.id.result);
		
		//btn back
		btnback = (Button)findViewById(R.id.btnback);
		
		//setOnclick listener
		//btn angka
		nol.setOnClickListener(this);
		satu.setOnClickListener(this);
    	dua.setOnClickListener(this);
    	tiga.setOnClickListener(this);
    	empat.setOnClickListener(this);
    	lima.setOnClickListener(this);
    	enam.setOnClickListener(this);
    	tujuh.setOnClickListener(this);
    	delapan.setOnClickListener(this);
    	sembilan.setOnClickListener(this);
    	koma.setOnClickListener(this);
    	
    	//btnproses
    	tambah.setOnClickListener(this);
    	samadengan.setOnClickListener(this);
    	kurang.setOnClickListener(this);
    	bagi.setOnClickListener(this);
    	kali.setOnClickListener(this);
    	clear.setOnClickListener(this);
    	
    	//btn back
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
			setEnableBtn(true);
			break;
		case R.id.btn2:
			addAngka("2");
			setEnableBtn(true);
			break;
		case R.id.btn3:
			addAngka("3");
			setEnableBtn(true);
			break;
		case R.id.btn4:
			addAngka("4");
			setEnableBtn(true);
			break;
		case R.id.btn5:
			addAngka("5");
			setEnableBtn(true);
			break;
		case R.id.btn6:
			addAngka("6");
			setEnableBtn(true);
			break;
		case R.id.btn7:
			addAngka("7");
			setEnableBtn(true);
			break;
		case R.id.btn8:
			addAngka("8");
			setEnableBtn(true);
			break;
		case R.id.btn9:
			addAngka("9");
			setEnableBtn(true);
			break;
		case R.id.btn0:
			addAngka("0");
			setEnableBtn(true);
			break;
		case R.id.btnkoma:
    		addAngka(".");
    		setEnableBtn(true);
    		break;
		case R.id.btnplus:
			num1 = Double.parseDouble(hasil.getText().toString());
    		op = 1;
    		hasil.setText("");
    		statusBtn(false);
			break;
		case R.id.btnminus:
			num1 = Double.parseDouble(hasil.getText().toString());
    		op = 2;
    		hasil.setText("");
    		statusBtn(false);
			break;
		case R.id.btnmultiply:
			num1 = Double.parseDouble(hasil.getText().toString());
    		op = 3;
    		hasil.setText("");
    		statusBtn(false);
			break;	
		case R.id.btndiv:
			num1 = Double.parseDouble(hasil.getText().toString());
    		op = 4;
    		hasil.setText("");
    		statusBtn(false);
			break;	
		case R.id.btnClear:
			clearscrn();
			break;
		case R.id.btnEqual:
			num2 = Double.parseDouble(hasil.getText().toString());
    		NumberFormat n = NumberFormat.getInstance();
    		n.setMaximumFractionDigits(2);
    		statusBtn(true);
    		switch(op){
    		case 1:
    			hasil.setText(n.format(num1+num2));
    			break;
    		case 2:
    			hasil.setText(n.format(num1-num2));
    			break;
    		case 3:
    			hasil.setText(n.format(num1*num2));
    			break;
    		case 4:
    			hasil.setText(n.format(num1/num2));
    			break;
    		}
    		break;	
		default:
			break;
		}
		
	}
	
	//proses addAngka
	private void addAngka(String a){
		String txt = hasil.getText().toString();
		txt+=a;
		hasil.setText(txt);
	}
	
	//fun disable all
	private void setEnableBtn(Boolean sys){
		samadengan.setEnabled(sys);
	    kali.setEnabled(sys);
	    bagi.setEnabled(sys);
	    kurang.setEnabled(sys);
	    tambah.setEnabled(sys);
	    koma.setEnabled(sys);
	}
	//proses for enable or disable button
	private void statusBtn(Boolean sts)
	{
		samadengan.setEnabled(true);
	    kali.setEnabled(sts);
	    bagi.setEnabled(sts);
	    kurang.setEnabled(sts);
	    tambah.setEnabled(sts);
	    koma.setEnabled(sts);
	}
	
	//func for clearing display
	private void clearscrn()
	{
	    	statusBtn(true);
	    	setEnableBtn(false);
	    	hasil.setText("");
	}

}
