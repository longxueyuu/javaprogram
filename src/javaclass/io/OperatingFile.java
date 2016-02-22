package javaclass.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class OperatingFile {
	
	private static int tabNum = 0;
	
	public static void main(String[] args){
		String path = "E:/ZQX_MES/java";
		String outputPath = "E:/ZQX_MES/folderTree.txt";
		OperatingFile opFile = new OperatingFile();
		//File file = new File(path);
		//opFile.CreateFolderTree(file);
		opFile.CreateFolderTree(path,outputPath);
		//opFile.deleteFiles(path);
	}
	
	/**
	 * 以给定的目录打印文件目录树,输出到指定的text文件中
	 * 
	 * @param inputPath
	 * @param outputFilePath
	 * @throws IOException 
	 */
	public void CreateFolderTree(String inputPath, String outputFilePath)
	{
		File file = new File(inputPath);
		File outputFile = new File(outputFilePath);
		CreateFolderTree(file, outputFile);
	}
	
	/**
	 * 以给定的目录打印文件目录树,输出到指定的text文件中
	 * 
	 * @param file
	 * @param outputFile
	 * @throws IOException 
	 */
	public void CreateFolderTree(File file, File outputFile)
	{
		if(!file.exists())
		{
			return;
		}
		String str = tabsAndName(tabNum, file);
		System.out.println(str);
		writeFile(outputFile,str,tabNum);
		if(file.isFile() || file.listFiles().length == 0)
		{
			return;
		}
		File[] fileList = file.listFiles();	
		fileList = sortFile(fileList);
		
		for(File filePath : fileList)
		{
			tabNum++;
			CreateFolderTree(filePath, outputFile);
			tabNum--;
		}
	}
	
	/**
	 * 将文件目录结构写入指定的文件
	 * 
	 * @param tabNum
	 * @param file
	 * @return
	 */
	private String tabsAndName(int tabNum, File file)
	{
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < tabNum; i++)
		{
			str.append("\t");
		}
		str.append(file.getName());
		return str.toString();
	}
	
	/**
	 * 文件列表重新排序，使目录在列表在前面，文件在列表后面
	 * 
	 * @param file
	 * @return
	 */
	private File[] sortFile(File[] file)
	{
		ArrayList<File> dir = new ArrayList<File>();
		ArrayList<File> fil = new ArrayList<File>();
		for(File filePath : file)
		{
			if(filePath.isDirectory())
			{
				dir.add(filePath);
			}else{
				fil.add(filePath);
			}
		}
		for(Iterator<File> iterator = fil.iterator(); iterator.hasNext();)
		{
			dir.add(iterator.next());
		}
		return dir.toArray(new File[0]);
	}
	
	/**
	 * 
	 * 
	 * @param file
	 * @param data
	 * @param tabNum
	 */
	public void writeFile(File file, String data, int tabNum)
	{
		Boolean append = false;
		if(tabNum > 0)
		{
			append = true;
		}
		FileWriter fw;
		try {
			fw = new FileWriter(file, append);
			fw.write(data);
			fw.write("\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除目录中、目录中的文件及其子目录
	 * 
	 * @param path
	 */
	public void deleteFiles(String path)
	{
		File file = new File(path);
		deleteFiles(file);
	}
	
	/**
	 * 删除目录中、目录中的文件及其子目录
	 * 
	 * @param file
	 */
	public void deleteFiles(File file)
	{
		if(!file.exists())
		{
			return;
		}
		if(file.isFile() || file.listFiles().length == 0)
		{
			file.delete();
			return;
		}
		File[] fileList = file.listFiles();
		for(File f : fileList)
		{
			deleteFiles(f);
		}
		file.delete(); // 如果file是目录，在删除所有子文件夹和文件后，删除该目录
	}
}































