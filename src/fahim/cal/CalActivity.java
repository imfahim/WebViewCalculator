package fahim.cal;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalActivity extends Activity {
    /** Called when the activity is first created. */
	private EditText viewText;
	
	private Button button0; 
	private Button button1; 
	private Button button2; 
	private Button button3; 
	private Button button4; 
	private Button button5;
	private Button button6; 
	private Button button7; 
	private Button button8; 
	private Button button9; 
	private Button buttonAdd; 
	private Button buttonSub;
	private Button buttonMul; 
	private Button buttonDiv; 
	private Button buttonMR; 
	private Button buttonMS; 
	private Button buttonMP; 
	private Button buttonMM;
	private Button buttonMC;
	private Button buttonC;   
	private Button buttonEQ; 
	private Button button00;
	private Button buttonDot;
	private Button buttonAC;
	int dotted =0;
	
	String disp = "";
	
	private String frst; 
    private String secnd; 
    private String opprnd;
    private String mmry;
    
    public static final String PREFERENCES_NAME = "Cal";
    
    public void dotClick(Button btnValue){
    	if(dotted==0){
		if(this.opprnd == ""){
			if(this.viewText.length() < 10){
				disp += "" + btnValue.getText().toString();
				this.viewText.setText(disp);
				
				this.opprnd = "";
				
				this.frst = disp.toString();
				dotted++;
			}else{
				Toast.makeText(this, "Too Long Value", Toast.LENGTH_LONG).show();
			
			}	
		}else{
    		disp += "" + btnValue.getText().toString();
			this.viewText.setText(disp);
			dotted++;
		}}
    	else{
    		Toast.makeText(this, "Doshomik already exist", Toast.LENGTH_LONG).show();
    	}
    }
    
    public void numberClick(Button btnValue){
		if(this.opprnd == ""){
			if(this.viewText.length() < 10){
				disp += "" + btnValue.getText().toString();
				this.viewText.setText(disp);
				
				this.opprnd = "";
				
				this.frst = disp.toString();
			}else{
				Toast.makeText(this, "Too Long Value", Toast.LENGTH_LONG).show();
			
			}	
		}else{
    		disp += "" + btnValue.getText().toString();
			this.viewText.setText(disp);
		}
    }
    
    
    
    
    public void memoryButtonProcess(Button btnLogic){
    	if(btnLogic.getText().equals("M+")){
    		add(this.viewText.getText().toString());
    		disp = "";
    		dotted=0;
    		this.viewText.setText(disp);
    	}
		if(btnLogic.getText().equals("M-")){
		    sub(this.viewText.getText().toString());	
		    disp = "";
		    dotted=0;
    		this.viewText.setText(disp);
		}
		if(btnLogic.getText().equals("MR")){
			show();
		}
		if(btnLogic.getText().equals("MS")){
    		store(this.viewText.getText().toString());
    	}
		if(btnLogic.getText().equals("MC")){
			clear();
		}
    }
    
    public void add(String newValue){
    	SharedPreferences sharedPref = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPref.edit();
    	
    		double oldValue = Double.parseDouble(sharedPref.getString("result", "0"));
    		editor.putString("result", String.valueOf(Double.parseDouble(newValue) + oldValue));
    		editor.commit();
    		
    		Toast.makeText(this, "Added with the Memory Successfully!", Toast.LENGTH_LONG).show();

    }
    
    public void sub(String newValue){
    	SharedPreferences sharedPref = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPref.edit();

    		double oldValue = Double.parseDouble(sharedPref.getString("result", "0"));
    		editor.putString("result", String.valueOf(Double.parseDouble(newValue) - oldValue));
    		editor.commit();
    		
    		Toast.makeText(this, "Subtracted with the Memory Successfully!", Toast.LENGTH_LONG).show();

    }
    
    public void show(){
    	SharedPreferences sharedPref = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    	
    	disp = sharedPref.getString("result", this.mmry.toString());
    	dotted=0;
    	
    	this.viewText.setText("" + disp);
    }
    
    public void store(String s){
    	SharedPreferences sharedPref = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPref.edit();
    	
    	
    		
    		editor.putString("result", s);
        	editor.commit();
    	
    	
    	Toast.makeText(this, "Saved in the memory!", Toast.LENGTH_LONG).show();
    }
    
    public void clear(){
    	SharedPreferences sharedPref = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPref.edit();
    	
    	editor.putString("result","0");
    	editor.commit();
    	
    	Toast.makeText(this, "Memory Cleared Successfully!", Toast.LENGTH_LONG).show();
    	
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.opprnd = "";
        this.frst = "";
        this.mmry = "";
        
        this.viewText = (EditText)findViewById(R.id.EditTextView);
        this.viewText.setText("0");
        
 
        
        this.button0 = (Button)findViewById(R.id.button0);
        this.button1 = (Button)findViewById(R.id.button1);
        this.button2 = (Button)findViewById(R.id.button2);
        this.button3 = (Button)findViewById(R.id.button3);
        this.button4 = (Button)findViewById(R.id.button4);
        this.button5 = (Button)findViewById(R.id.button5);
        this.button6 = (Button)findViewById(R.id.button6);
        this.button7 = (Button)findViewById(R.id.button7);
        this.button8 = (Button)findViewById(R.id.button8);
        this.button9 = (Button)findViewById(R.id.button9);
        this.button00 = (Button)findViewById(R.id.button00);
        this.buttonAdd = (Button)findViewById(R.id.buttonAdd);
        this.buttonSub = (Button)findViewById(R.id.buttonSub);
        this.buttonMul = (Button)findViewById(R.id.buttonMul);
        this.buttonDiv = (Button)findViewById(R.id.buttonDiv);
        this.buttonEQ = (Button)findViewById(R.id.buttonEQ);
        this.buttonC = (Button)findViewById(R.id.buttonC);
        this.buttonMS = (Button)findViewById(R.id.buttonMS);
        this.buttonMR = (Button)findViewById(R.id.buttonMR);
        this.buttonMP = (Button)findViewById(R.id.buttonMP);
        this.buttonMM = (Button)findViewById(R.id.buttonMM);
        this.buttonMC = (Button)findViewById(R.id.buttonMC);
        this.buttonDot =(Button)findViewById(R.id.buttonDot);
        this.buttonAC =(Button)findViewById(R.id.buttonAC);
        
        //db
        
        //DatabaseHandler db = new DatabaseHandler(); 
        
        //button Click
        
        button0.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button0);
        	}
        });
        button1.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button1);
        	}
        });
        button2.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button2);
        	}
        });
        button3.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button3);
        	}
        });
        button4.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button4);
        	}
        });
        button5.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button5);
        	}
        });
        button6.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button6);
        	}
        });
        button7.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button7);
        	}
        });
        button8.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button8);
        	}
        });
        button9.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button9);
        	}
        });
        button00.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		numberClick(button00);
        	}
        	
        });
        buttonDot.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		dotClick(buttonDot);
        	}
        	
        });
        buttonAC.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		disp ="";
        		dotted=0;
        		viewText.setText("");
        	}
        	
        });
        
        buttonC.setOnClickListener(new OnClickListener(){
        	
        	public void onClick(View view){
        		if(disp != null || disp != ""){
        			disp = new StringBuilder(viewText.getText()).deleteCharAt(disp.length() - 1).toString();
        			dotted=0;
        			viewText.setText("" + disp);
        		}else{
        			viewText.setText("");
        		}
        	}
        });
        
  
        
        buttonAdd.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		opprnd = "+";
        		disp = "";
        		dotted=0;
        		viewText.setText("");
        	}
        });
        buttonSub.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		opprnd = "-";
        		disp = "";
        		dotted=0;
        		viewText.setText("");
        	}
        });
        buttonMul.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		opprnd = "*";
        		disp = "";
        		dotted=0;
        		viewText.setText("");
        	}
        });
        buttonDiv.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		opprnd = "/";
        		disp = "";
        		dotted=0;
        		viewText.setText("");
        	}
        });
        
        buttonEQ.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){	
    			secnd = disp.toString();
    			
    			Intent i = new Intent(CalActivity.this, CalculationActivity.class);
    			i.putExtra("frst", frst);
    			i.putExtra("secnd", secnd);
    			i.putExtra("opprnd", opprnd);
    			
    			startActivityForResult(i, 1);
        	}
        });
        //memory
        buttonMS.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		memoryButtonProcess(buttonMS);
        	}
        });
        buttonMR.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		memoryButtonProcess(buttonMR);
        	}
        });
        buttonMP.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		memoryButtonProcess(buttonMP);
        	}
        });
        buttonMM.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		memoryButtonProcess(buttonMM);
        	}
        });
        buttonMC.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		memoryButtonProcess(buttonMC);
        	}
        });
        
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	if(requestCode == 1 && resultCode == RESULT_OK){   		
    		disp = data.getStringExtra("varResult".toString());
    		
    		//this.memory = first;
    		this.viewText.setText("" + frst + opprnd + secnd );
			this.viewText.setText("" + disp);
			frst = data.getStringExtra("varResult");
			opprnd = "";
			disp = "";
			dotted=0;
			
    	}else{
    		this.viewText.setText("" + "Try Again !");
    	}
    }
    
    public void onConfugurationChanged(Configuration newConfig){
    	super.onConfigurationChanged(newConfig);
    	if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
    		setContentView(R.layout.main);
    	}
    	else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
    		setContentView(R.layout.main);
    	}
    }
}