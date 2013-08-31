import java.net.ServerSocket;
import java.net.Socket;


public class Question {
	public String question;
	public String answer;
	public boolean isAnswer;
	public Question(String question,String answer){
		this.question = question;
		this.answer = answer;
		isAnswer = false;
	}
}