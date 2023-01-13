package com.Caltech.Lockme;

import java.io.File;

import java.io.IOException;
import java.util.Scanner;

public class FileEx {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		String path = "D:\\caltech\\";
		int pref;
		Scanner sc = new Scanner(System.in);
		Boolean close = true;
		
		while(close)
		{
				//Print the menu
			    System.out.println("\n\n");
				System.out.println("Welcome to Company Lockers PVT LTD -  Below are the options for your file system.");
				System.out.println("**************************************************************");
				System.out.println("1 --------- Retrieving the file names in an ascending order\r\n");				
				System.out.println("2 --------- Add a user specified file to the application");
				System.out.println("3 --------- Delete a user specified file to the application");
				System.out.println("4 --------- Search for a user specified file to the application");
				System.out.println("5 --------- Exit the application");
				System.out.println("**************************************************************");
				
				System.out.println("Please enter your preference : ");
				try
				{
				    pref = sc.nextInt();
				    //take the user preference and call the respective methods
				    switch(pref)
				    {
				    case 1 : DisplayFileNames(path);
				    			break;
				    case 2: AddNewFile(path, sc);
				    			break;
				    case 3: DeleteFile(path,sc);
				    			break;
				    case 4: SearchFileName(path,sc);
				    		break;
				    default : System.out.println("Exiting the application");
				    		close = false;
				    		System.exit(0);	    			      
				    
				    }
				}
				catch(Exception e)
				{
					System.out.println("Unable to process your preference.");
				}
	
		}
	}
	
	//Creating a file in the path specified after taking filename from the user	
	private static void AddNewFile(String path, Scanner sc) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter a file name");
		String finalname = sc.next();
		String finalPath = path + finalname;
	    System.out.println(finalPath);
	    
	    File f = new File(finalPath);

	    boolean res =  f.createNewFile();
	    if(res != true)
	    	System.out.println("File is not created");
	    else
	    	System.out.println("File " + finalname + "  created successfully");    
	    
		
	}

	 //Delete a file from a particular directory
	static boolean DeleteFile(String path, Scanner sc)
	{
		
		System.out.println("Enter a file name to delete");
		String finalname = sc.next();
		String finalPath = path + finalname;
	    System.out.println(finalPath);
	    
	    File f = new File(finalPath);
	    //delete operation
	    //it will not return anything
	     return (f.delete());
	     
		}
	
	// Display all file names of a particular folder	
	static void DisplayFileNames(String path)
	{
		
		//display all the files
		File f = new File(path);
		File[] farry = f.listFiles();
		for(File file: farry)
		{
			System.out.println("The file name in the folder is " + file.getName());
		}		
	}
	
	//Search a particular file in the path specified
	static void SearchFileName(String path, Scanner sc)
	{
		File f= new File(path);
		System.out.println("Enter the file name to search: ");
		String fsearch = sc.next();
		String finalPath = path + fsearch;
		
        boolean check  = new File(finalPath).exists();
        if(check)
        	System.out.println("The file exists at the path specified");
        else
        	System.out.println("The file does not exist. Try creating it!!");
		
	}

}
