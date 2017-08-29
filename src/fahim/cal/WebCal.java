package fahim.cal;



import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebCal extends Activity {
		
		
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.webview);
	        
	        WebView webCalc = (WebView)findViewById(R.id.webView1);
	        
	        WebSettings webSet = webCalc.getSettings();
	        
	        webSet.setJavaScriptEnabled(true);
	        
	        webCalc.addJavascriptInterface(new WebAppController(this), "Android");
	        
	        webCalc.loadUrl("file:///android_asset/index.html");

	        
}}