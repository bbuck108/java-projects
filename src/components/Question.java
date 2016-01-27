package components;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author Benjamin Buck
 * @see Test
 * @see Answer
 */
public class Question {
	//Fields
	
	/**
	 * The test that the question is a part of.
	 */
	private Test test;
	
	/**
	 * The String containing the question.
	 */
	String question;
	
	/**
	 * The question number
	 */
	int number;
	
	/**
	 * The list of answer choices for the question.
	 */
	ArrayList<Answer> alist;
	
	/**
	 * The answer that was selected by the user.
	 */
	private Answer markedAnswer;
	
	/**
	 * Is true if the question has been answered.
	 */
	private boolean answered;
	
	
	
	
	
	//Constructors
	
	/**
	 * Constructs a Question from a valid JSONObject.
	 * @param p_1 A valid JSONObject
	 * @param p_2 The parent Test
	 */
	public Question(JSONObject p_1, Test p_2){
		number = p_1.getInt("number");
		question = p_1.getString("text");
		test = p_2;
		
		alist = new ArrayList<Answer>();
		JSONArray t_1 = p_1.getJSONArray("answers");
		for(int i = 0; i < t_1.length(); i++){
			alist.add(new Answer(t_1.getJSONObject(i), this));
		}
	}
	
	
	
	
	//Mutator methods
	
	/**
	 * Sets the answer that the user has marked. Only works if the Answer is a member of the list of possible answers.
	 * @param p_1 The marked Answer
	 * @return True if the answer was successfully set
	 */
	public boolean setMarkedAnswer(Answer p_1){
		boolean t_1 = false;
		for(Answer t_2: alist){
			if(p_1 == t_2){
				t_1 = true;
			}
		}
		
		if(t_1){
			markedAnswer = p_1;
			setAnswered(true);
		}
		return t_1;
	}
	
	
	
	
	//Accessor methods
	
	/**
	 * Get the Test that the question is a part of.
	 * @return The parent Test
	 */
	public Test getTest() {
		return test;
	}
	
	/**
	 * Gets the question.
	 * @return The question.
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Gets the question number
	 * @return The question number
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * Gets the list of possible answers.
	 * @return The list of possible answers.
	 */
	public ArrayList<Answer> getAList(){
		return alist;
	}




	/**
	 * @return the answered
	 */
	public boolean isAnswered() {
		return answered;
	}




	/**
	 * @param answered the answered to set
	 */
	private void setAnswered(boolean answered) {
		this.answered = answered;
	}




	/**
	 * @return the markedAnswer
	 */
	public Answer getMarkedAnswer() {
		return markedAnswer;
	}
}
