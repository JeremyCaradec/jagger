import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

 public class Main
 { 
  public static void main(String args[]) throws ParseException
    {
    	if(args.length != 1)
    	{
    		System.out.println("how to use: java Main path");
    		return;
    	}

        InputStream is;

		try 
		{
		    is = new FileInputStream(args[0]);
		    Cabeg parser = new Cabeg(is);
		    parser.mainloop();
		    is.close();

		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
    }
}