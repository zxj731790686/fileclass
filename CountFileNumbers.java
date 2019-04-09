import java.io.File;


public class CountFileNumbers {
	
public static void main(String[] args) {

	System.out.println(countFiles("D:\\zj"));
}

private static int  countFiles(String path) {
	File f=new File(path);
	if(f.isFile()){
		return 1;
	}
	String[] files=f.list();
	int tot=0;
	for(String file:files){
		File curFile=new File(f.getAbsolutePath(),file);
		if(curFile.isDirectory()){
			tot+=countFiles(curFile.getAbsolutePath());
			
		}
		else tot++;
	}
	return tot;
}
}
