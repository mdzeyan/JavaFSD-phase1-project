package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	
	static final String projectFilesPath = "E:\\Simplilearn\\final_project\\LockedMe\\LockedMeFiles";
	static final String errorMessage = "Some error occured. Please contact: admin@lockedme.com";
	
	static int choice;
	static int sl = 0;
	static boolean isBusinessMenuTrue = false; 
	
	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		try
		{
		
			do
			{
				displayMainMenu();
				System.out.println("Enter your choice");
				choice = Integer.parseInt(sc.nextLine());
				
				
				switch(choice)
				{
				case 1: getAllFiles();
				break;
				case 2: businessMenu();
				break;
				case 3: System.exit(0);
				break;
				default : System.out.println("Invalid option");
				break;
				}
				
				if(isBusinessMenuTrue)
				{
					isBusinessMenuTrue = false;
					do
					{
						displayBusinessMenu();
						System.out.println("Enter your choice");
						sl = Integer.parseInt(sc.nextLine());
						
						
						switch(sl)
						{
						case 1: creatFiles();
						break;
						case 2: deleteFiles();
						break;
						case 3: searchFiles();
						break;
						case 4: backToMainMenu();
						break;
						default : System.out.println("Invalid option");
						break;
						}
					}
					while(sl>0);
				}
				
				
				
			}
			while(choice > 0);
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
	sc.close();


	}
	
	/**
	 *  This method will display the menu
	 */
	
	public static void displayMainMenu()
	{
		System.out.println("******************************************************");
		System.out.println("\t\tWelcome to LockedMe.com");
		System.out.println("");
		System.out.println("@author: Mohammad zeyan");
		System.out.println("@version: 26-01-2022");
		System.out.println("******************************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Go to businessMenu");
		System.out.println("\t\t3. Exit");
	}
	
	/**
	 *  This method will display the businessMenu
	 */
	
	public static void displayBusinessMenu()
	{
		System.out.println("******************************************************");
		System.out.println("\t\tWelcome to businessMethods");
		System.out.println("******************************************************");
		System.out.println("\t\t1. Add file");
		System.out.println("\t\t2. Delete file");
		System.out.println("\t\t3. Search file");
		System.out.println("\t\t4. back to the Mian menu");
	}
	
	/**
	 * This method is used to go back to main menu
	 */	
	public static void backToMainMenu()
	{
		sl = 0;
	}
	
	/**
	 * This method is used to go to the business menu
	 */	
	public static void businessMenu()
	{
		isBusinessMenuTrue = true;
	}
	
	/**
	 * This method returns all the files from directory
	 */
	
	public static void getAllFiles()
	{
		try
		{
			File folder = new File(projectFilesPath);
			File[] listOfAllFiles = folder.listFiles();
			
			if(listOfAllFiles.length == 0)
			{
				System.out.println("No files exist in this directory");
			}
			else
			{
				for(var l:listOfAllFiles)
				{
					System.out.println(l.getName());
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Some error occured. Please contact: admin@lockedme.com");
		}
		
		
		
	}
	
	/**
	 *  This method will creates the file
	 */
	
	public static void creatFiles()
	{
		
		try
		{
			String fileName;
			System.out.println("Enter file name");
			fileName = sc.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file");
			linesCount = Integer.parseInt(sc.nextLine());
			
			FileWriter myWriter = new FileWriter(projectFilesPath+ "\\"+ fileName);
			
			for(int i = 1; i <= linesCount; i++)
			{
				System.out.println("Enter the file line");
				myWriter.write(sc.nextLine()+"\n");
			}
			
			System.out.println("File is created succesfully");
			
			myWriter.close();
			
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
		
	}
	
	/**
	 * This method delete the file based on provided file name
	 */
	
	public static void deleteFiles()
	{
		
		try
		{
			String fileName;
			System.out.println("Enter file name to be deleted");
			fileName = sc.nextLine();
			File file = new File(projectFilesPath+ "\\"+ fileName);
			if(file.exists())
			{
				file.delete();
				System.out.println("File deleted succesfully: "+fileName);
			}
			else
			{
				System.out.println("File do not exist");
			}
				
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
			
		
	}
	
	/**
	 * This method will search the file based on provided filename
	 */
	
	public static void searchFiles()
	{
		
		try
		{
			String fileName;
			System.out.println("Enter file name to be search");
			fileName = sc.nextLine();
			
			File folder = new File(projectFilesPath);
			File[] listOfAllFiles = folder.listFiles();
			
			LinkedList<String> fileNames = new LinkedList<String>();
			
			for(var l:listOfAllFiles)
				fileNames.add(l.getName());
			
			if(fileNames.contains(fileName))
				System.out.println("File is available");
			else
				System.out.println("File is not available");
		}
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
			
	}


}
