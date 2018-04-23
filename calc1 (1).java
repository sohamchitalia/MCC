import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class calc1 extends MIDlet implements CommandListener
{
 private Form form;
 private Display display;
 private TextField input1, input2;
 private Command add, sub, mul,div,sin,cos,tan,log,e,sq;
 private StringItem item;
 
 public calc1()
 {
 
 }
 public void startApp()
 {
  display = Display.getDisplay(this);
  Form form = new Form("Calculator");
  form.append("Hello everybody");
  item = new StringItem("Result", "");
 
  input1 = new TextField("First Number:", "", 30, TextField.NUMERIC);
  input2 = new TextField("Second Number", "", 30, TextField.NUMERIC);
  form.append(input1);
  form.append(input2);
  add = new Command("Addition", Command.OK, 1);
  sub = new Command("Subtraction", Command.OK, 1);
  mul = new Command("Multiplication", Command.OK, 1);
  div = new Command("Division", Command.OK, 1);
sin= new Command("Sine", Command.OK, 1);
cos= new Command("Cosine", Command.OK, 1);
tan= new Command("Tangent", Command.OK, 1);
log= new Command("Logarithm", Command.OK, 1);
e= new Command("E", Command.OK, 1);
sq= new Command("SquareRoot", Command.OK, 1);
  form.addCommand(add);
  form.addCommand(sub);
  form.addCommand(mul);
  form.addCommand(div);
form.addCommand(sin);
form.addCommand(cos);
form.addCommand(tan);
form.addCommand(log);
form.addCommand(e);
form.addCommand(sq);
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
 {int one=Integer.parseInt(input1.getString());
  int two= Integer.parseInt(input2.getString());
  int result=one+two;
  item.setText( result + "" );
 
 }
 private void calculate1()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one - two;
  item.setText(result + "");
 
 }
 private void calculate2()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one * two;
  item.setText(result + "");
 
 }
 private void calculate3()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one / two;
  item.setText(result + "");
 
 }
private void calculate4()
 {
  int one = Integer.parseInt(input1.getString());
  double result = Math.sin(one);
  item.setText(result + "");
 
 }
private void calculate5()
 {
  int one = Integer.parseInt(input1.getString());
  double result = Math.cos(one);
  item.setText(result + "");
 
 }
private void calculate6()
 {
  int one = Integer.parseInt(input1.getString());
  double result = Math.tan(one);
  item.setText(result + "");
 
 }
private void calculate7()
 {
  int one = Integer.parseInt(input1.getString());
  //double result = java.lang.Math.log(one);
  //item.setText(result + "");
 
 }
private void calculate8()
 {
  int one = Integer.parseInt(input1.getString());
  double result = Math.E;
  item.setText(result + "");
 
 }
private void calculate9()
 {
  int one = Integer.parseInt(input1.getString());
  double result = Math.sqrt(one);
  item.setText(result + "");
 
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
else if (label.equals("Sine"))
  {
   calculate4();
   form.append("The Answer is:");
  }
else if (label.equals("Cosine"))
  {
   calculate5();
   form.append("The Answer is:");
  }
else if (label.equals("Tangent"))
  {
   calculate6();
   form.append("The Answer is:");
  }
else if (label.equals("Logarithm"))
  {
   calculate7();
   form.append("The Answer is:");
  }
else if (label.equals("E"))
  {
   calculate8();
   form.append("The Answer is:");
  }
else if (label.equals("SquareRoot"))
  {
   calculate9();
   form.append("The Answer is:");
  }
 }
}