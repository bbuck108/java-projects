package components;

import org.json.JSONObject;

/**
 * 
 * @author Benjamin Buck
 * @see Test
 * @see Question
 */
public class Answer {
	//Fields
	
	/**
	 * The question that the Answer belongs to.
	 */
	Question question;
	
	/**
	 * The String containing the answer.
	 */
	String answer;
	
	/**
	 * The letter of the answer choice.
	 */
	String letter;
	
	/**
	 * True if this is the correct answer.
	 */
	boolean correct;
	
	
	
	
	//Constructors
	
	/**
	 * Construct an Answer from a valid JSONObject
	 * @param p_1 A valid JSONObject
	 * @param p_2 The parent Question
	 */
	public Answer(JSONObject p_1, Question p_2) {
		question = p_2;
		answer = p_1.getString("text");
		letter = p_1.getString("letter");
		correct = p_1.getBoolean("correct");
	}
	
	
	
	
	
	//Accessor methods
	
	/**
	 * Gets the answer.
	 * @return The answer
	 */
	public String getAnswer(){
		return answer;
	}
	
	/**
	 * Gets the letter of the answer.
	 * @return The letter
	 */
	public String getLetter(){
		return letter;
	}
}
