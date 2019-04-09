import java.io.File;
import java.util.List;
import java.util.Vector;


public class ListAllFilesDemo {
	
public static void main(String[] args) {

	for(String file:listAlllFiles("D:\\zj"))
		System.out.println(file);
}

private static List<String>  listAlllFiles(String path) {
	List<String> fLists=new Vector<String>();
	File f=new File(path);
	if(f.isFile()){
		fLists.add(f.getAbsolutePath());
		return fLists;
	}
	String[] files=f.list();
	for(String file:files){
		File curFile=new File(f.getAbsoluteFile(),file);
		if(curFile.isDirectory()){
			fLists.addAll(listAlllFiles(curFile.getAbsolutePath()));
		}else
			fLists.add(curFile.getAbsolutePath());
		
	}
	return fLists;
	

}
}
