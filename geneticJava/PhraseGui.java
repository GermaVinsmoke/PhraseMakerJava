package geneticJava;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhraseGui extends JFrame{
	JFrame jf = new JFrame("Phrase Maker");
	static JLabel display = new JLabel();
	static JLabel generation = new JLabel("Generations: ");
	static JLabel genValue = new JLabel();
	static JLabel population = new JLabel("Population: ");
	static JLabel popValue = new JLabel();
	static JLabel mutationRate = new JLabel("Mutation Rate: ");
	static JLabel mutValue = new JLabel();
	
	PhraseGui(){
		jf.setLayout(new GridLayout(4,1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		jp1.setLayout(new FlowLayout());
		jp1.add(display);
		display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		jf.add(jp1);
		
		jp2.setLayout(new FlowLayout());
		jp2.add(generation);
		jp2.add(genValue);
		generation.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		genValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		jf.add(jp2);
		
		jp3.setLayout(new FlowLayout());
		jp3.add(population);
		jp3.add(popValue);
		population.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		popValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		jf.add(jp3);
		
		jp4.setLayout(new FlowLayout());
		jp4.add(mutationRate);
		jp4.add(mutValue);
		mutationRate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		mutValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		jf.add(jp4);
		
		jf.setSize(500,400);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	
}
