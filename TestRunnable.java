import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRunnable implements Runnable 
{
	private String filename;

	public TestRunnable(String filename)
	{
		this.filename = filename;
	}

	public void run()
	{
		InputStream is;
		try 
		{
		    is = new FileInputStream(filename);
		    Cabeg parser = new Cabeg(is);
		    parser.mainloop();
		    is.close();

		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}