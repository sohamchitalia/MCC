import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class testcalc extends MIDlet implements CommandListener
{
 private Form form;
 private Display display;
 private TextField input1, input2, input3, input4;
 private Command add, sub, mul,div;
 private StringItem item;
 
 public testcalc()
 {
 
 }
 public void startApp()
 {
  display = Display.getDisplay(this);
  Form form = new Form("complex Calculator");
  form.append("Hello everybody");
  item = new StringItem("Result", "");
 
  input1 = new TextField("First real Number:", "", 30, TextField.NUMERIC);
  input2 = new TextField("First imaginary Number", "", 30, TextField.NUMERIC);
  input3 = new TextField("Second Real Number", "", 30, TextField.NUMERIC);
  input4 = new TextField("Second Imaginary Number", "", 30, TextField.NUMERIC);
  form.append(input1);
  form.append(input2);
  form.append(input3);
  form.append(input4);
  add = new Command("Addition", Command.OK, 1);
  sub = new Command("Subtraction", Command.OK, 1);
  mul = new Command("Multiplication", Command.OK, 1);
  div = new Command("Division", Command.OK, 1);

  form.addCommand(add);
  form.addCommand(sub);
  form.addCommand(mul);
  form.addCommand(div);

  form.append(item);
 
  form.setCommandListener(this);
 
  display.setCurrent(form);
 }
 
 public void pauseApp() { }
 
 public void destroyApp(boolean uncondn)
 {
  notifyDestroyed();
 }
    private void calculate()
 {int rone=Integer.parseInt(input1.getString());
  int ione= Integer.parseInt(input2.getString());
  int rtwo = Integer.parseInt(input3.getString());
  int itwo = Integer.parseInt(input4.getString());
  int result1=rone+rtwo;
  int result2=ione+itwo;
  item.setText( result1 + "+" + result2 + "i" );
 
 }
 private void calculate1()
 {
 int rone=Integer.parseInt(input1.getString());
  int ione= Integer.parseInt(input2.getString());
  int rtwo = Integer.parseInt(input3.getString());
  int itwo = Integer.parseInt(input4.getString());
  int result1=rone-rtwo;
  int result2=ione-itwo;
  item.setText( result1 +"+"+ result2 + "i" );
 
 }
 private void calculate2()
 {
  int rone=Integer.parseInt(input1.getString());
  int ione= Integer.parseInt(input2.getString());
  int rtwo = Integer.parseInt(input3.getString());
  int itwo = Integer.parseInt(input4.getString());
  int constant=(rone*rtwo)-(ione*itwo);
  int img=(rone*itwo)+(rtwo*ione);
  item.setText( constant + "+" + img + "i" );
 
 }
 private void calculate3()
 {
  int rone=Integer.parseInt(input1.getString());
  int ione= Integer.parseInt(input2.getString());
  int rtwo = Integer.parseInt(input3.getString());
  int itwo = Integer.parseInt(input4.getString());
  int constant=(rone*rtwo)-(ione* (-itwo));
  int img=(rone*(-itwo))+(rtwo*ione);
  int square=(rtwo*rtwo) + (itwo*itwo);
  int result4= constant/square;
  int result5= img/square;
  item.setText( result4+"+"+result5+ "i");
 
 }

 public void commandAction(Command c, Displayable d)
 {
  String label = c.getLabel();
  if (label.equals("Addition"))
  {
   calculate();
   
  }
 
  else if (label.equals("Subtraction"))
  {
   calculate1();
   
  }
 
  else if (label.equals("Multiplication"))
  {
   calculate2();
   form.append("The Answer is:");
  }
 
  else if (label.equals("Division"))
  {
   calculate3();
   form.append("The Answer is:");
  }
}
}