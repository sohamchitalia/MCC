import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class ComplexCalc extends MIDlet implements CommandListener
{
	private Form form;
	private Display display;
	private TextField Real_no1,Real_no2,Comp_no1,Comp_no2;
	private Command add,sub,mul,div;
	private StringItem item;

	public void startApp()
	{
		display = Display.getDisplay(this);
		form = new Form("ComplexCalc");
		form.append("Calc");
		item = new StringItem("Result:","");

		Real_no1 = new TextField("Real part of equation 1","",30,TextField.NUMERIC);
		Comp_no1 = new TextField("Complex part of equation 1","",30,TextField.NUMERIC);
		Real_no2 = new TextField("Real part of equation 2","",30,TextField.NUMERIC);
		Comp_no2 = new TextField("Complexx part of equation 2","",30,TextField.NUMERIC);
		form.append(Real_no1);
		form.append(Comp_no1);
		form.append(Real_no2);
		form.append(Comp_no2);
		add = new Command("Addition",Command.OK,1);
		sub = new Command("Subtraction",Command.OK,1);
		mul = new Command("Multiplication",Command.OK,1);
		div = new Command("Division",Command.OK,1);
		form.addCommand(add);
		form.addCommand(sub);
		form.addCommand(mul);
		form.addCommand(div);
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

	private void AddC()
	{
		int real1 = Integer.parseInt(Real_no1.getString());
		int Comp1  = Integer.parseInt(Comp_no1.getString());
		int real2 = Integer.parseInt(Real_no2.getString());
		int Comp2 = Integer.parseInt(Comp_no2.getString());

		int rr = real1+real2;
		int rc = Comp1 + Comp2;
		item.setText(rr+"+"+rc+"i");
	}

	private void SubC()
	{
		int real1 = Integer.parseInt(Real_no1.getString());
		int Comp1  = Integer.parseInt(Comp_no1.getString());
		int real2 = Integer.parseInt(Real_no2.getString());
		int Comp2 = Integer.parseInt(Comp_no2.getString());

		int rr = real1-real2;
		int rc = Comp1 - Comp2;
		item.setText(rr+"+"+rc+"i");
	}

	private void MulC()
	{
		int real1 = Integer.parseInt(Real_no1.getString());
		int Comp1  = Integer.parseInt(Comp_no1.getString());
		int real2 = Integer.parseInt(Real_no2.getString());
		int Comp2 = Integer.parseInt(Comp_no2.getString());

		int rr = real1*real2 + Comp1*Comp2*(-1);
		int rc = real1*Comp2 + real2*Comp1;
		item.setText(rr+"+"+rc+"i");
	}

	private void DivC()
	{
		int real1 = Integer.parseInt(Real_no1.getString());
		int Comp1  = Integer.parseInt(Comp_no1.getString());
		int real2 = Integer.parseInt(Real_no2.getString());
		int Comp2 = Integer.parseInt(Comp_no2.getString());

		float d = Comp1*Comp1 + Comp2*Comp2; 
		float rr = (float)(real1*real2 - Comp1*Comp2*(-1))/d;
		float rc = (float)(real1*Comp2*(-1) + real2*Comp1)/d;
		item.setText(rr+"+"+rc+"i");
	}

	public void commandAction(Command c,Displayable d)
	{
		String label = c.getLabel();
		if( label == "Addition")
		{
			AddC();
		}
		if( label == "Subtraction")
		{
			SubC();
		}
		if( label == "Multiplication")
		{
			MulC();
		}
		if( label == "Division")
		{
			DivC();
		}
	}
}