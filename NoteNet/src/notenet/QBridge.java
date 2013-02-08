package notenet;

import java.lang.reflect.Method;

import com.trolltech.qt.core.QObject;

public class QBridge extends QObject {	
	
	Object parent;
	
	public QBridge(Object parent){
		this.parent = parent;
	}
	

    public String callMethod(String methodName){
        try
        {
            Method method = parent.getClass().getMethod(methodName);
            method.invoke(parent);
            return "Success";
        }
        catch (final Exception e)
        {
            return "Failure";
        }
    }
    
    public String callMethod(String methodName, String param){
        try
        {
            Method method = parent.getClass().getMethod(methodName, String.class);
            method.invoke(parent, param);
            return "Success";
        }
        catch (final Exception e)
        {
            return "Failure";
        }
    }
    
    public void log(String output){
    	System.out.println(output);
    }
}
