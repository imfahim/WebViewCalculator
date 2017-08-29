package fahim.cal;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;


public class CalculationActivity extends Activity {
	
	Date CalDate;
	FileOutputStream fos;
	String FILENAME = "Hostiry.txt";
	
	public void writeHistory(String frst,String secnd,String opprnd, double result)
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		String CurrentDateTime =  dateFormat.format(cal.getTime());
		
		String LogData = ""+CurrentDateTime+" : "+ frst +" "+opprnd+" "+secnd+" = " +result+"\n";
		
		try{
			fos = openFileOutput(FILENAME, Context.MODE_APPEND);
			fos.write(LogData.getBytes());
			fos.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void calculation(Intent i, String opprnd, String frst, String secnd){
		if(opprnd.equals("+")){
	    	double varResult = ((Double.parseDouble(frst)) + (Double.parseDouble(secnd)));
			
	    	i.putExtra("varResult", String.valueOf(varResult));
			setResult(Activity.RESULT_OK, i);
			
			writeHistory(frst,secnd,opprnd,varResult);
			
			finish();
		}
		else if(opprnd.equals("-")){
	    	double varResult = ((Double.parseDouble(frst)) - (Double.parseDouble(secnd)));
			
	    	i.putExtra("varResult", String.valueOf(varResult));
			setResult(Activity.RESULT_OK, i);
			
			writeHistory(frst,secnd,opprnd,varResult);
			
			finish();
		}
		else if(opprnd.equals("*")){
	    	double varResult = ((Double.parseDouble(frst)) * (Double.parseDouble(secnd)));
			
	    	i.putExtra("varResult", String.valueOf(varResult));
			setResult(Activity.RESULT_OK, i);
			writeHistory(frst,secnd,opprnd,varResult);
			finish();
		}
		else if(opprnd.equals("/")){
	    	double varResult = ((Double.parseDouble(frst)) / (Double.parseDouble(secnd)));
			
	    	i.putExtra("varResult", String.valueOf(varResult));
			setResult(Activity.RESULT_OK, i);
			writeHistory(frst,secnd,opprnd,varResult);
			finish();
		}
		
	}
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        Intent Result = new Intent();
	        Result = getIntent();
	        
	        if(Result != null){
	            String frst = Result.getStringExtra("frst");
	            String secnd = Result.getStringExtra("secnd");
	            String opprnd = Result.getStringExtra("opprnd");
	            
	            calculation(Result, opprnd, frst, secnd);
	        }
	        else{
	        	setResult(Activity.RESULT_CANCELED, Result);
				finish();
	        }
	     
	    }
	

}
