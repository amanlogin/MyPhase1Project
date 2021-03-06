package com.lockedme;
	
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
	
public class FileManager 
{
	/**
	 * This method will return all the file name from the folder
	 * @param folderpath
	 * @return List <String>
	 */
	public static List<String> getAllFiles (String folderpath)
	{
		//Creating File Object
		File fl = new File(folderpath);
		
		//Getting all the file into FileArray 
		File [] listOfFile = fl.listFiles();
		
		//Declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFile)
			fileNames.add(f.getName());
			
		//return the List
		return fileNames;
			
	}
	/**
	 * This method will create content into the file specified 
	 * @param folderpath
	 * @param Filename
	 * @param content
	 * @return boolean
	 */
	public static boolean createFiles (String folderpath, String fileName, List <String> content)
	{
		try 
		{
			File fl = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(fl);
			for (String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
/**
 * This method will delete the specific file if exist
 * @param folderpath
 * @param fileName
 * @return 
 */
	public static boolean deleteFile (String folderpath, String fileName)
	{
		
		//adding folder path with file name and creating file object
		File file = new File(folderpath+"\\"+fileName);
    
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}
			catch(Exception Ex)
		{
				return false;
    	}
	}
	/**
	 * This code will search the specific file if exist
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	
	public static boolean searchFile (String folderpath, String fileName)
	{
		//adding folder path with file name and creating file object
				File file = new File(folderpath+"\\"+fileName);
				
				if(file.exists())
					return true;
				else
					return false;
		
	}
}
	
	
	
	
	
	
	
	
	