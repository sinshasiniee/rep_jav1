import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readingPhoneNumbers {
	public static void main(String[] args) {
		File dir = new File("E:/niki"); // current directory
		readFilesRecursively(dir);

}

	public static void readFilesRecursively(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					//System.out.println("directory:" + file.getCanonicalPath());
					readFilesRecursively(file);
				} else {
					System.out.println("directory:" + file.getCanonicalPath());
					displayPhoneNumbers(file);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void displayPhoneNumbers(File file) throws IOException {
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\.|\r\n|\\s|,");
        String regexStr = "^((\\+|0{0,2})91?|[0]?)?[789]\\d{9}$";
        while (sc.hasNext()) {		
        Pattern r = Pattern.compile(regexStr);
          Matcher m = r.matcher(sc.next());
          if (m.find()) {
        	  System.out.println("Found phone number: " + m.group(0) );		
          }
         
        }
	}
}

