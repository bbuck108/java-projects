package components;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author Benjamin Buck
 * @see Question
 * @see Answer
 */
public class Test {
	//Fields
	
	/**
	 * The name of the test.
	 */
	String name;
	
	
	/**
	 * An ArrayList which contains all of the questions on the test.
	 */
	private ArrayList<Question> qlist;
	
	
	/**
	 * The maximum number of possible points.
	 */
	int totalPoints;
	
	
	
	
	//Contructors
	
	/**
	 * Constructs a Test from a valid JSONObject.
	 * @param p_1 A valid JSONObject
	 */
	public Test(JSONObject p_1){
		//Sets the name of the Test
		name = p_1.getString("name");
		
		//Builds the list of questions
		qlist = new ArrayList<Question>();
		JSONArray t_1 = p_1.getJSONArray("questions");
		for(int i = 0; i < t_1.length(); i++){
			getQList().add(new Question(t_1.getJSONObject(i), this));
		}
	}
	
	
	
	
	//Mutator methods
	
	/**
	 * Adds questions to the test
	 * @param p_1 A Question to add to the test.
	 */
	public void addtoQList(Question p_1){
		getQList().add(p_1);
	}
	
	
	
	
	//Accessor methods
	
	/**
	 * Returns the ArrayList of questions on the test.
	 * @return The ArrayList of questions on the test.
	 */
	public ArrayList<Question> getQList(){
		return qlist;
	}
	
	/**
	 * Returns the name of the test.
	 * @return The name of the test.
	 */
	public String getName(){
		return name;
	}
	
	
	
	
	//Other methods
	
	/*public boolean isFinished(){
	boolean t_1 = true;
	for(Question t_2 : getQList()){
		if(!t_2.answered){
			t_1 = false;
		}
	}
	return t_1;
	}*/
	
	/**
	 * Grades all of the questions and returns the grade for the test out of 100%.
	 * @return The test grade out of 100%.
	 */
	public int gradeTest(){
		int t_1 = 0;
		totalPoints = 0;
		
		for(Question t_2 : qlist){
			totalPoints++;
			if(t_2.markedAnswer.correct){
				t_1++;
			}
		}
		
		t_1 = (100*t_1)/totalPoints;
		
		return t_1;
	}
}
