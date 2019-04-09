import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * FileIO ver 0.1 by *
 * 
 * @author ZHAO Jing 
 * 33470027#qq.com ʵ��API:�ļ����У�����
 */
public class FileTools {
	public static void main(String[] args) {
		copyFolder("d:/zj", "e:\\zj2");
	}

	/**
	 * �ݹ���ȫɾ��һ��Ŀ¼��������Ŀ¼�е�����Ŀ¼����Ŀ¼��
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()) {
			System.out.println(folder + " not existed!");
			return;
		}
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				delFolder(file.toString());
				file.delete();
			} else
				file.delete();
		}
		folder.delete();
	}

	/*
	 * �����������ļ�������Ϊ�����Ч��Bufferһ���Ǳ����
	 */
	public static void copyContent(File srcFile, PrintStream outStream) {
		try {
			BufferedInputStream fis = new BufferedInputStream(
					new FileInputStream(srcFile));
			for (int c; (c = fis.read()) != -1;)
				outStream.write(c);
			fis.close();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����srcFile��dstPathĿ¼�£������Ŀ¼����������Զ�����
	 * 
	 * @param srcFile
	 *            ���������ļ�
	 * @param dstPath
	 *            �����ļ���Ŀ��·��
	 */
	public static void copyFile(File srcFile, String dstPath) {
		File dstFile = new File(dstPath.toString());
		if (!dstFile.exists())
			dstFile.mkdirs();
		try {
			PrintStream out = new PrintStream(new BufferedOutputStream(
					new FileOutputStream(new File(dstPath, srcFile.getName()))));
			copyContent(srcFile, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ļ����������ط���
	 * 
	 * @param srcFileName
	 * @param dstFilePath
	 */
	public static void copyFile(String srcFileName, String dstFilePath) {
		copyFile(new File(srcFileName), dstFilePath);
	}

	/**
	 * �ļ��п������ݹ�) ����srcFolderPath��dstFolderPathĿ¼�£������Ŀ¼����������Զ�����
	 * 
	 * @param srcFolderPath
	 *            ���������ļ���
	 * @param dstFolderPath
	 *            �����ļ��е�Ŀ��·��
	 */
	public static void copyFolder(String srcFolderPath, String dstFolderPath) {
		for (File file : new File(srcFolderPath).listFiles())
			if (!file.isDirectory())
				copyFile(file, dstFolderPath);
			else
				copyFolder(file.getAbsolutePath(), new File(dstFolderPath, file
						.getName()).toString());
	}

	/**
	 * �ݹ���һ���ļ����������ļ����б� *
	 * 
	 * @param folderPath
	 * @return
	 */
	public static LinkedList<String> getAllFileList(String folderPath) {
		LinkedList<String> list = new LinkedList<String>();
		File temp = new File(folderPath);
		if (temp.isFile())
			list.add(folderPath);
		else if (temp.isDirectory())
			for (String t : temp.list())
				list.addAll(getAllFileList(new File(folderPath, t)
						.getAbsolutePath()));// �ݹ���
		return list;
	}
}