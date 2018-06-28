package geneticJava;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingUp {
//	static ArrayList<Integer> fitnessScore = new ArrayList<Integer>();
	static HashMap<Integer, String> fitnessScore = new HashMap<Integer, String>();
	static ArrayList<String> matingPool = new ArrayList<String>();
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String target = "Royal Challengers Bangalore"; 
 		int popmax = 2000;
		float mutationRate =  0.3f;
		PhraseGui.popValue.setText(String.valueOf(popmax));
		PhraseGui.mutValue.setText(String.valueOf(mutationRate));
		new PhraseGui();
		Population population = new Population(target, popmax, mutationRate);
	}

}
