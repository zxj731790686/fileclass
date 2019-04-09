import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;


public class CopyDirectory {
	
public static void main(String[] args) {

	copy("d:\\zj","e:\\zj2");
	List<String> files=listAlllFiles("d:\\zj");
	for(String filename:files){
		String cfilename=filename.replace("d:\\zj","e:\\zj2");//simple implementations
		System.out.println(cfilename);
		try {
			FileOutputStream fos=new FileOutputStream(cfilename);
			//
			//FileCopy.copy(filename, cfilename);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

private static void copy(String src, String dst) {
	// TODO Auto-generated method stub
	
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
