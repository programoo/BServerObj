import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class QuestionFeeder extends Thread {

	private boolean run;

	public QuestionFeeder() {
		run = true;
		this.readFile();
	}

	public void run() {
		while (run) {

			 int i = (int) ( Math.random()* Info.questionList.size() );
			 Info.currentQuestion = Info.questionList.get(i);
			 Info.broadCast(Info.currentQuestion.question);
			 qSleep(3000);
			 //hint feeder
			 if(Info.currentQuestion.isAnswer){
				 Info.currentQuestion.isAnswer = false;
				 continue;
			 }
			 
			 String hint1 = hint(Info.currentQuestion.answer,33);
			 Info.broadCast(hint1);
			 qSleep(3000);
			 if(Info.currentQuestion.isAnswer){
				 Info.currentQuestion.isAnswer = false;
				 continue;
			 }
			 String hint2 = hint(Info.currentQuestion.answer,66);
			 Info.broadCast(hint2);
			 qSleep(3000);
			 if(Info.currentQuestion.isAnswer){
				 Info.currentQuestion.isAnswer = false;
				 continue;
			 }
			 String hint3 = hint(Info.currentQuestion.answer,100);
			 Info.broadCast(hint3);
			 qSleep(500);
			 
			 System.out.println(Info.currentQuestion.question);
		}
	}
	public String hint(String answer,int percent){
		String show = answer.substring(0,answer.length()*percent/100);
		int left = answer.length()- answer.length()*percent/100;
		int i=0;
		while(i<left){
			show = show+"*";
			++i;
		}
		
		return show;
	}
	public void qSleep(int millisec){

		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void readFile() {
		File fileDir = new File("question.txt");

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileDir), "UTF-8"));
			String str;

			while ((str = in.readLine()) != null) {
				String strSplit[] = str.split("[?]");
				if (strSplit.length == 2) {
					Info.questionList
							.add(new Question(strSplit[0].replace("*",""), strSplit[1]));
				}
				//System.out.println(strSplit[0]);
			}

			System.out.println("questionList: " + Info.questionList.size());
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
