import java.io.File;

public class Test
{ 
	public static void main(String args[]) throws InterruptedException
	{
		final File folder = new File("./tests");
		String fn;
		for(final File fileEntry:folder.listFiles())
		{
			fn = folder.getName()+"/"+fileEntry.getName();
			if(fileEntry.isDirectory())
				continue;
			System.out.println(fn+"\n"); 
			Thread t = new Thread(new TestRunnable(fn));
			t.start();
			t.join();
			System.out.println("\n");
		}
	}
}