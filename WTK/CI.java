import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.lang.*;
import java.io.*;

public class CI extends MIDlet implements CommandListener
{
	private Form form;
	private Display display;
	private TextField p,r,t,n;
	private Command calculate;
	private StringItem item;

	public void startApp()
	{
		display = Display.getDisplay(this);
		form = new Form("Compound Intrest");
		item = new StringItem("Result:","");
		p = new TextField("Pricipal Amount:","",30,TextField.NUMERIC);
		r = new TextField("Rate of Intrest:","",30,TextField.NUMERIC);
		n = new TextField("Number:","",30,TextField.NUMERIC);
		t = new TextField("Time:","",30,TextField.NUMERIC);
		

		form.append(p);
		form.append(r);
		form.append(n);
		form.append(t);

		calculate = new Command("calculate",Command.OK,1);
		form.addCommand(calculate);
		form.append(item);

		form.setCommandListener(this);

		display.setCurrent(form);

	} 

	public void pauseApp()
	{

	}

	public void destroyApp(boolean uncondn)
	{
		notifyDestroyed();
	}

	private void calCI()
	{
		double pi = Double.parseDouble(p.getString());
		double rate = Double.parseDouble(r.getString())/100;
		double no = Double.parseDouble(n.getString());
		double time = Double.parseDouble(t.getString());
		double result = (1+rate/no);
		double base = result;
		for (int i =1 ;i< no*time ;i++ ) 
		{
			result = result*base;	
		}
		//result=Math.pow(result,no*time);
		result = pi*result;
		item.setText(""+result+"");
	}

	public void commandAction(Command c,Displayable d)
	{
			calCI();
	}
}