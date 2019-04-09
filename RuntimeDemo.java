import java.io.IOException;


public class RuntimeDemo {
public static void main(String[] args) {
	try {
		
		//Runtime.getRuntime().exec("notepad.exe 1.txt");
		for(int i=0;i<100;i++)
		{
			Runtime.getRuntime().exec("explorer.exe https://oj.ahstu.cc");
			Thread.sleep(100);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
