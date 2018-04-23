import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.lang.*;
import java.io.*;

public class Calculator extends MIDlet implements CommandListener
{
	private Form form;
	private Display display;
	private TextField input1,input2;
	private Command add,sub,mul,div/*,expo*/;
	private StringItem item;

	public void startApp()
	{
		display = Display.getDisplay(this);
		form = new Form("Calculator");
		item = new StringItem("Result:","");
		input1 = new TextField("First number:","",30,TextField.NUMERIC);
		input2 = new TextField("Second Number","",30,TextField.NUMERIC);

		form.append(input1);
		form.append(input2);

		add = new Command("Addition",Command.OK,1);
		sub = new Command("Subtraction",Command.OK,1);
		mul = new Command("Multiplication",Command.OK,1);
		div = new Command("Division",Command.OK,1);
		expo = new Command("Power",Command.OK,1);
		form.addCommand(add);
		form.addCommand(sub);
		form.addCommand(mul);
		form.addCommand(div);
		form.addCommand(expo);
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

	private void ADD()
	{
		int one = Integer.parseInt(input1.getString());
		int two = Integer.parseInt(input2.getString());
		int result= one + two;
		item.setText("This is the answer:"+result+"");
	}

	private void SUB()
	{
		int one = Integer.parseInt(input1.getString());
		int two = Integer.parseInt(input2.getString());
		int result= one - two;
		item.setText(result+"");
	}

	private void MUL()
	{
		int one = Integer.parseInt(input1.getString());
		int two = Integer.parseInt(input2.getString());
		int result= one*two;
		item.setText(result+"");
	}

	private void DIV()
	{
		int one = Integer.parseInt(input1.getString());
		int two = Integer.parseInt(input2.getString());
		double result = (float)one/(float)two;
		item.setText(result+"");
	}

	private void EXPO()
	{
		double one = Double.parseDouble(input1.getString());
		double two = Double.parseDouble(input2.getString());
		double result = Math.pow(one,two);
		item.setText(result+"");
	}

	public void commandAction(Command c,Displayable d)
	{
		String label = c.getLabel();
		if(label.equals("Addition"))
		{
			ADD();
		}
		if(label.equals("Subtraction"))
		{
			SUB();
		}
		if(label.equals("Multiplication"))
		{
			MUL();
		}
		if(label.equals("Division"))
		{
			DIV();
		}
		if(label.equals("Power"))
		{
			EXPO();
		}
	}
}
