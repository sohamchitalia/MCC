import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class INCOME_TAX extends MIDlet implements CommandListener
{
	private Form form;
	private Display display;
	private TextField in;
	private  Command calculate;
	private StringItem item;

	public void startApp()
	{
		display = Display.getDisplay(this);
		form = new Form("INCOME TAX");
		item = new StringItem("Result:","");

		in = new TextField("Enter Income:","",30,TextField.NUMERIC);
		form.append(in);

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

	private void calIN()
	{
		double income= Double.parseDouble(in.getString());
		double income_tax;
		if(income <=250000) income_tax = 0;
		else if(income > 250000 && income <= 500000) 
			income_tax = 0.1*income;
		else if(income > 500000 && income >= 1000000) 
			income_tax = 0.2*income;
		else 
			income_tax = 0.3*income;
		item.setText("\nIncome:"+income+"\nIncome Tax:"+income_tax);
	}

	public void commandAction(Command c,Displayable d)
	{
		calIN();
	}

} 