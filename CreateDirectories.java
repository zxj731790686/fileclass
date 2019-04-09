import java.io.File;


public class CreateDirectories {
public static void main(String[] args) {
	try {
		for(int i=0;i<10;i++){
			File f=new File("zj"+i);
			if(f.exists()){
				f.delete();
				continue;
			}else{
				//f.mkdir();
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
