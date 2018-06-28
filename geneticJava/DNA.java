package geneticJava;
import java.util.Map;
import java.util.Random;

public class DNA extends SettingUp {
	Random rand = new Random();
	char[] genes;
	float fitness;
	int highestScore = 0;

	public DNA() {
		// TODO Auto-generated constructor stub
	}
	//Generating Population
	public String generatePopulation(int num){
		genes = new char[num];
		for (int i = 0; i < genes.length; i++) {
			genes[i] = newChar();	//Making phrase character by character
		}
		return getPhrase();
		
	}
	
	//Build the phrase
	String getPhrase() {
		return new String(genes);
	}
	
	//Generate random characters
	private char newChar() {
		int c = 65 + rand.nextInt(59);
		if (c == 123)
			c = 32;
		if (c == 124)
			c = 46;
		return (char) c;
	}
	
	//Calculates fitness
	public int fitness(String target, String pop) {
		char[] genes = pop.toCharArray();	//Converts phrase into character array
		int score = 0;						//Keeping record of that phrase's score
		for (int i = 0; i < genes.length; i++) {
			if (genes[i] == target.charAt(i)) {		//If the character matches then
				score++;							//Increase the score
			}
			if(score > highestScore){				//If score is greater than highscore in that generation then
				highestScore = score;				//assign that score to highScore	
			}	
		}
		fitnessScore.put(score, String.valueOf(genes));		//Put score and string in map
		return score;
	}
	
	public void display() throws InterruptedException{
		for(Map.Entry m : fitnessScore.entrySet()){
			if(m.getKey().equals(highestScore)){
//				System.out.println(m.getValue());		//Display phrase on console
				
				//Setting the Phrase on Label for GUI
				PhraseGui.display.setText(String.valueOf(m.getValue()));
				Thread.sleep(100);
			}
		}
	}

	public void matingPoolGenerate() {
		for (Map.Entry m : fitnessScore.entrySet()) {
			for (int j = 0; j < (int) m.getKey(); j++) {	//loop according to the score of that phrase
				matingPool.add((String) m.getValue());	//Add the phrase in matingPool
			}
		}
	}

	public String crossover() {
		
		//Get any 2 random parents from the matingPool
		String firstParent = matingPool.get(rand.nextInt(matingPool.size()));
		String secondParent = matingPool.get(rand.nextInt(matingPool.size()));
		
		//Get any random crossover point from the phrase
		int crossoverPoint = rand.nextInt(genes.length);
		
		//Combine both the parents according to the crossover point
		String crossover = firstParent.substring(0, crossoverPoint) + 
				secondParent.substring(crossoverPoint, genes.length);
		return crossover;
	}
	
	public String mutation(float mutationRate, String chromosome, String target) {
		char [] genes = chromosome.toCharArray();
		for (int i = 0; i < genes.length; i++) {
			if(Math.random()<mutationRate){
				if(genes[i] != target.charAt(i)){	//If the characters don't match then get a new character
					genes[i]=newChar();
				}
			}
		}
		String child = new String(genes); //Stores the child phrase after mutation
		return child;
	}
}
