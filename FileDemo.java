import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File f = new File("D:\\zj");
		System.out.println(f.isDirectory());// true
		String[] files = f.list();
		for (String file : files)
			System.out.println(new File(f.getAbsolutePath(), file));
		// System.out.println(new File(f.getAbsolutePath()+"\\"+file));//rigid
	}
}
