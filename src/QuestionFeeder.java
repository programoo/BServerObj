import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class QuestionFeeder extends Thread {

	public QuestionFeeder() {
		this.readFile();
	}

	public void readFile() {
		File fileDir = new File("question.txt");

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileDir), "UTF8"));
			String str;

			while ((str = in.readLine()) != null) {
				//PrintStream out = new PrintStream(System.out, true, "UTF-8");
				//out.println(str);
				System.out.println(str);
			}

			in.close();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
