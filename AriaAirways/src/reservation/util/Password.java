package reservation.util;


public class Password {
	
	private String password;
	private String securityQuestion;
	private String answer;

	public Password() {
	}
	
	public Password(String password) {
		this.password = password;
	}
	
	public Password(String passWord, String securityQuestion, String answer) {
		this.password = passWord;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	public void setSecurityQuestion(String question) {
		this.securityQuestion = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void printSecurityQuestion() {
		System.out.println(securityQuestion);
	}
	
	@Override
	public String toString() {
		return password;
	}

}