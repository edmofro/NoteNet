package notenet;

import java.lang.reflect.Method;

import com.trolltech.qt.core.QObject;

public class QBridge extends QObject {	
	
	VisualizerWindow view;
	
	public QBridge(VisualizerWindow view){
		this.view = view;
	}

    public String callMethod(String methodName){
        try
        {
            Method method = view.getClass().getMethod(methodName);
            method.invoke(view);
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
            Method method = view.getClass().getMethod(methodName, String.class);
            method.invoke(view, param);
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
