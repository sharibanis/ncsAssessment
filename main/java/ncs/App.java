package ncs;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	private static Scanner in;
	private static File file;
	private static BufferedWriter output;
	
	
	
	public static TreeSet<String> createOrderedList(File file) {
    	BufferedReader br;
    	String str;
    	TreeSet<String> treeSet = new TreeSet<String>();
		try {
			br = new BufferedReader(new FileReader(file));
		    while ((str = br.readLine()) != null) {
		    	treeSet.add(str);
		    }
		    //System.out.println(treeSet);
		} catch (Exception e) {
			System.out.println("Cannot create Ordered Set");
		}
		return treeSet;
	}
	
	
	public static void main(String[] args) {
		try {
			//sort-names C:\\temp\\names.txt
			//sort-names D:\\Temp\\names.txt
			//sort-names \\names.txt
			in = new Scanner(System.in);
			String s = in.nextLine().trim();
	        System.out.println("Command: " + s);
	        String[] cmd = s.split(" ");
	        String fileName = cmd[1];
        	file = new File(fileName);
	        Set<String> treeSet = new TreeSet<String>();
	        if (cmd[0].equals("sort-names")) {
		        if (file.exists()) {
		        	treeSet = createOrderedList(file);
		        } else {
		        	throw new FileNotFoundException("File Not Found. " + cmd[1]);
		        }
	        } else {
	        	throw new Exception("Invalid command." + cmd[0]);
	        }
	        
	        FileWriter fileWriter = new FileWriter("C:\\temp\\names-sorted.txt");
	        output = new BufferedWriter(fileWriter);
	        for (String str : treeSet) {
	        	output.write(str);
	        	output.newLine();
	        }
		} catch (Exception ex) {
	        System.out.println(ex.toString());
		} finally {
	        try {
		        in.close();
		        output.flush();
				output.close();
	        	System.out.println("Finished: created names-sorted.txt");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
