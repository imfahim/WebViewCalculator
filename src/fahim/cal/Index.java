package fahim.cal;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Index extends Activity {
		
	public boolean isInternetConnectionAvailable(){
	      ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo activeNetworkInfo = conManager.getActiveNetworkInfo();
		  return activeNetworkInfo != null && activeNetworkInfo.isConnected();
		}
		
		public void gotInternet(){
			Toast.makeText(this, "Internet Connection is Available", Toast.LENGTH_SHORT).show();
			
			Intent i = new Intent(getApplicationContext(), WebCal.class);
			startActivity(i);
		}
		
		public void noInternet(){
			Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
			
			Intent i = new Intent(getApplicationContext(), CalActivity.class);
    		startActivity(i);
		}
		
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.index);
	        
	        Button proceed = (Button)findViewById(R.id.buttonCal);
	        
	        proceed.setOnClickListener(new OnClickListener(){
	        	public void onClick(View view){
	        		if(isInternetConnectionAvailable()){
	        			gotInternet();
	        		}else{
	        			noInternet();
	        		}
	        	}
	        });
	        
}}