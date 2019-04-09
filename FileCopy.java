import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopy {
	public static void copy(String src, String dst) {
		try {
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(dst));
			
			int c;
			while((c=bis.read())!=-1){
				bos.write(c);
				
			}
			
			bis.close();
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		copy("A.txt", "B.txt");
		copy("A.jpg", "D:\\B.jpg");
	}
}
