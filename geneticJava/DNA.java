package geneticJava;

import java.util.Map;
import java.util.Random;

public class DNA extends SettingUp {
	Random rand = new Random();
	char[] genes;
	float fitness;
	int highestScore = 0;
//	DNA(int num) {
//		genes = new char[num];
//		for (int i = 0; i < genes.length; i++) {
//			genes[i] = newChar();
//		}
//	}

	public DNA() {
		// TODO Auto-generated constructor stub
	}
	public String generatePopulation(int num){
		genes = new char[num];
		for (int i = 0; i < genes.length; i++) {
			genes[i] = newChar();
		}
		return getPhrase();
		
	}
	String getPhrase() {
		return new String(genes);
	}

	private char newChar() {
		// TODO Auto-generated method stub
		int c = 65 + rand.nextInt(59);
		if (c == 123)
			c = 32;
		if (c == 124)
			c = 46;
		return (char) c;
	}

	public int fitness(String target, String pop) {
		// TODO Auto-generated method stub
//		System.out.println("From fitness function");
		char[] genes = pop.toCharArray();
		int score = 0;
		for (int i = 0; i < genes.length; i++) {
			if (genes[i] == target.charAt(i)) {
//				System.out.println(genes[i]);
//				System.out.println();
//				System.out.println(target.charAt(i));
//				System.out.println("Yes");
				score++;
			}
			if(score > highestScore){
				highestScore = score;
			}
		}
//		System.out.println(highestScore);
//		System.out.println(score);
//		fitness = (float) score / (float) target.length();
		// fitnessScore.add(score);
//		if(score> Population.bestScore/2)
		fitnessScore.put(score, String.valueOf(genes));
//		if(score == genes.length){
////			System.out.println(score);
//			return genes.length;
//		}else{
//			return 0;
//		}
		return score;
	}
	
	public void display() throws InterruptedException{
		for(Map.Entry m : fitnessScore.entrySet()){
			if(m.getKey().equals(highestScore)){
//				System.out.println(m.getValue());
				PhraseGui.display.setText(String.valueOf(m.getValue()));
				Thread.sleep(100);
			}
		}
	}

	public void matingPoolGenerate() {
		for (Map.Entry m : fitnessScore.entrySet()) {
			for (int j = 0; j < (int) m.getKey(); j++) {
				matingPool.add((String) m.getValue());
			}
		}
	}

	public String crossover() {
		String firstParent = matingPool.get(rand.nextInt(matingPool.size()));
		String secondParent = matingPool.get(rand.nextInt(matingPool.size()));
		int crossoverPoint = rand.nextInt(genes.length);
		String crossover = firstParent.substring(0, crossoverPoint) + 
				secondParent.substring(crossoverPoint, genes.length);
		return crossover;
	}

//	DNA crossover(DNA partner) {
//	    // A new child
//	    DNA child = new DNA(genes.length);
//	    
//	    int midpoint = rand.nextInt(genes.length); // Pick a midpoint
//	    
//	    // Half from one, half from the other
//	    for (int i = 0; i < genes.length; i++) {
//	      if (i > midpoint) child.genes[i] = genes[i];
	
//	      else              child.genes[i] = partner.genes[i];
//	    }
//	    return child;
//	  }
	
	public String mutation(float mutationRate, String chromosome, String target) {
		char [] genes = chromosome.toCharArray();
		for (int i = 0; i < genes.length; i++) {
			if(Math.random()<mutationRate){
				if(genes[i] != target.charAt(i)){
					genes[i]=newChar();
//					System.out.println(genes[i]);
//					System.out.println(this.genes[i]);
				}
			}
		}
//		System.out.println(String.valueOf(genes));
//		return String.valueOf(genes);
		
		String child = new String(genes);
//		System.out.println(child);
//		if(child == target){
//			Population.isFinished = true;
//		}
		return child;
	}

//	void display() {
//		for (String x : matingPool) {
//			System.out.println(x);
//		}
//	}
}
