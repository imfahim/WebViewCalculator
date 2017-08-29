package fahim.cal;


import android.content.Context;

//@android.webkit.JavascriptInterface
public class WebAppController {
	
	Context ControllerContext;
	String OPR = "";
	String numFirst = "";
	String numLast = "";
	String q="";
	
	public WebAppController(Context c){
		this.ControllerContext = c;
	}
	
	//@JavascriptInterface
	public void addNum(String num){
		
		numLast += "" + num; 
	}
	
	//@JavascriptInterface
	public void addOperator(String opr){
		OPR = opr;
		numFirst = numLast;
		numLast = "";
	}
	
	//@JavascriptInterface
	public double getResult(){
		q=numLast;
		numLast = "";
		if(OPR.equals("+")){
			return (Double.parseDouble(numFirst)) + (Double.parseDouble(q));
		}else if(OPR.equals("-")){
			return (Double.parseDouble(numFirst)) - (Double.parseDouble(q));
		}else if(OPR.equals("*")){
			return (Double.parseDouble(numFirst)) * (Double.parseDouble(q));
		}else if(OPR.equals("/")){
			return (Double.parseDouble(numFirst)) / (Double.parseDouble(q));
		}else{
			return 0.00;
		}
	}
}
