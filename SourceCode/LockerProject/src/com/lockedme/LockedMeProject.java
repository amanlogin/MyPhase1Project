package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{
	static final String folderpath = "D:\\MyPhase1Project\\LockedMeFiles"; 
	public static void main(String[] args) 
	{
		int proceed= 1;
		
		do
			{
			//Variable declaration
			Scanner obj = new Scanner(System.in);
			int ch;
			
			//Menu
			displayMenu();
			System.out.println("Enter your Choice:");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			case 1 : getAllFiles();
					break;
			case 2 : createFiles();
					break;
			case 3 : deleteFile();
					break;
			case 4 : searchFile();
					break;
			case 5 : System.exit(0);
					break;
			default : System.out.println("Invalid Option");
					break;
			}
			}
		while(proceed>0);
	}
	public static void displayMenu()
	{
		System.out.println("*************************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("*************************************************");
		System.out.println("1. Get all file");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*************************************************");
	}
	
	/**
	 * This method is for getting the file name. 
	 */
	public static void getAllFiles()
	{
		//Getting the File Name

		List<String> fileNames = FileManager.getAllFiles(folderpath);
	
		for(String f:fileNames)
		System.out.println(f);
	
	}
	
	/**
	 * This method is to create the files
	 */
	public static void createFiles()
	{
		//Variable Declaration
		Scanner obj = new Scanner (System.in);
		String fileName; 
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//Read file name from user
		System.out.println("Enter the FIle Name:");
		fileName= obj.nextLine();
		
		//Read number of lines from user
		System.out.println("Enter how many line in the file:");
		linesCount= Integer.parseInt(obj.nextLine());
		
		//Read Lines from user
		for(int i=1; i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
		}
		
		//Save the content into the file
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("File and data is saved sucessfully");
		else
			System.out.println("Some error occured. Please contact admin@LockedMe.com");
	}
	
	/**
	 * This method is to delete the specific file
	 */
	public static void deleteFile()
	{
		//Variable Declaration
		String fileName;
		Scanner obj = new Scanner(System.in);
		
		//Read file name from user
		System.out.println("Enter file name to delete:");
		fileName= obj.nextLine();
		
		//Deleting the file
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("File not found! Enter valid file name.");
	}
	
	/**
	 * This method is to search the file. 
	 */
	public static void searchFile() 
	{
		//Variable Declaration
		String fileName;
		Scanner obj = new Scanner(System.in);

		//Read file name from user
		System.out.println("Enter file name to searched:");
		fileName= obj.nextLine();
		
		//Searching the file
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		
		if(isFound)
			System.out.println("File is present");
		else
			System.out.println("File not present.");

	}

}
