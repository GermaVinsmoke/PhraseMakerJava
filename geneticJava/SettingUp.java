package geneticJava;

import java.util.ArrayList;
import java.util.HashMap;

//Basic Setup class for providing all the inputs to the program
public class SettingUp {
	
	//This HashMap is used to store the score as the key and the string
	static HashMap<Integer, String> fitnessScore = new HashMap<Integer, String>();
	
	/*This ArrayList is used to generate matingPool and store the number of strings as per the score
	 * For eg - 4 strings in population --> A, B, C and D
	 * Score of A is 4, B is 3, C is 2 and D is 1
	 * So matingPool will be like this --> |A|A|A|A|B|B|B|C|C|D|*/
	static ArrayList<String> matingPool = new ArrayList<String>();
	
	//Throws InterruptedException because we're using Thread.sleep();
	public static void main(String[] args) throws InterruptedException{
		
		//Target phrase which you want the algorithm to make
		String target = "Genetic Algorithm implementation";
		
		//Population for the algorithm
 		int popmax = 20000;
 		
 		//MutationRate for the algorithm
		float mutationRate =  0.1f;
		
		//Setting the population value on Label for GUI
		PhraseGui.popValue.setText(String.valueOf(popmax));
		
		//Setting the Mutation Rate value on Label for GUI
		PhraseGui.mutValue.setText(String.valueOf(mutationRate));
		
		//Calling PhraseGUI class constructor to create the window
		new PhraseGui();
		
		/*Calling Population class and sending our phrase, population and 
		 * Mutation Rate as arguments */
		Population population = new Population(target, popmax, mutationRate);
	}

}
