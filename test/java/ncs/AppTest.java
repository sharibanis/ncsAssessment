package ncs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.*;
import org.junit.*;

public class AppTest {
	private static File file;
	private static App app;
	
	@BeforeAll
	public static void setup() {
		String fileName = "C:\\temp\\names.txt";
    	file = new File(fileName);
    	app = new App();
    }	
	
	@Test
	public void createOrderedListTest() {
		Set<String> treeSet2 = new TreeSet<String>();
		try {
	        if (file.exists()) {
	        	BufferedReader br = new BufferedReader(new FileReader(file));
		        String str;
		        while ((str = br.readLine()) != null) {
		        	treeSet2.add(str);
		        }
			}
		} catch (Exception ex) {
			System.out.println("Cannot create Ordered Set");
		}
		Set<String> treeSet1 = new TreeSet<String>();
		treeSet1.add("BAKER, THEODORE");
		treeSet1.add("SMITH, ANDREW");
		treeSet1.add("KENT, MADISON");
		treeSet1.add("SMITH, FREDRICK");
		treeSet2 = app.createOrderedList(file);
		org.assertj.core.api.Assertions.assertThat(treeSet1.containsAll(treeSet2) && treeSet2.containsAll(treeSet1));
	}
}