package geneticJava;

import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.dom.MatchingIterator;

class Population{
	String target;
	int popmax;
	float mutationRate;
	//DNA[] population;
	String[] pop; //
	static boolean isFinished = false;
	int bestScore = 0;
	int isItTheBest = 0;
	int generations = 0;
	DNA d = new DNA();
	Random rand = new Random();

	public Population(String target, int popmax, float mutationRate) throws InterruptedException{
		this.target = target;
		this.popmax = popmax;
		this.mutationRate = mutationRate;
		//population = new DNA[popmax];
		pop = new String[popmax]; //
		bestScore = target.length();
		for (int i = 0; i < popmax; i++) {
			pop[i] = d.generatePopulation(target.length());
//			System.out.println(pop[i]);
			// population[i] = new DNA(target.length());
			// System.out.println(i+")"+String.valueOf(population[i].genes));
		}
		GeneticAlgo();
	}

	private void calcFitness() {
		// TODO Auto-generated method stub
//		System.out.println("From calcFitnessFunction");
		for (int i = 0; i < pop.length; i++) {
			isItTheBest = d.fitness(target, pop[i]);
//			System.out.println(isItTheBest);
			if(isItTheBest == bestScore){
				isFinished = true;
				break;
			}
//			if(generations%3 == 0){
//				if(isItTheBest == 1 || isItTheBest == 2){
//					pop[i] = d.generatePopulation(target.length());
//				}
//			}
		}
	}

	/*public void getBest(){
		calcFitness();
		d.matingPoolGenerate();
//		System.out.println(generations);
		if (isItTheBest == bestScore) {
			System.out.println("The End");
		} 
			else {
			loopThrough();
		}
	}

	public void loopThrough(){

		for (int i = 0; i < population.length; i++) {
			// d.display();
			// DNA child = population[i].crossover();
			String child = d.crossover();
			pop[i] = d.mutation(mutationRate, child);
//			System.out.println(pop[i]);
		}
		generations++;
		getBest();
	}*/
	public void GeneticAlgo() throws InterruptedException{
		while(!(isFinished)){
			calcFitness();
//			if(isItTheBest == bestScore){
////				isFinished = true;
//				break;
//			}
			d.matingPoolGenerate();
			for(int i = 0; i < pop.length; i++){
				String child = d.crossover();
				pop[i] = d.mutation(mutationRate, child, target);
//				System.out.println(pop[i]);
			}
			generations++;
//			System.out.println("Generations: "+generations);
			PhraseGui.genValue.setText(String.valueOf(generations));
			d.display();
			if(isItTheBest == bestScore){
//				isFinished = true;
				break;
			}
		}
	}
	// public String getBest(){
	// int worldrecord = 0;
	// int index = 0;
	// for (int i = 0; i < population.length; i++) {
	// if (population[i].fitness > worldrecord) {
	// index = i;
	// worldrecord = (int) population[i].fitness;
	// }
	// }
	//
	// if (worldrecord == bestScore ) isFinished = true;
	// return population[index].getPhrase();
	// }

}
