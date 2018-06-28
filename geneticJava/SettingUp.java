package geneticJava;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingUp {
//	static ArrayList<Integer> fitnessScore = new ArrayList<Integer>();
	static HashMap<Integer, String> fitnessScore = new HashMap<Integer, String>();
	static ArrayList<String> matingPool = new ArrayList<String>();
	public static void main(String[] args){
		// TODO Auto-generated method stub
		String target = "Royal Challengers Bangalore"; 
 		int popmax = 200000;
		float mutationRate =  1f;
		Population population = new Population(target, popmax, mutationRate);
	}

}
