package test.collision;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import game.math.Collidable;
import game.math.CollidableCircle;
import game.math.CollisionDetector;

public class CollisionOptimizer {
	public static final int RUNS = 1000;
	public static final int TRIALS = 10;
	
	public static final int MULT = 10;
	public static final int BASE = 10;
	
	public static final boolean MULTIPOINT = false;
	public static final boolean EXP = false;
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1000;
	
	public static void main(String[] args) {
		
		//algAnalysis(4, 10, 10, 0, true);
		
		System.out.println("Max Objects for Playable Refresh Rate of 25ms");
		algMaxAnalysis(25, 10, 10, 10, false);
		System.out.println("Max Objects for Lagging Refresh Rate of 35ms");
		algMaxAnalysis(35, 10, 10, 10, false);
		System.out.println("Max Objects before Unplayable Refresh Rate of 50ms");
		algMaxAnalysis(50, 10, 10, 10, false);
		System.out.println("Max Objects Analysis Complete!");
		
	}
	
	public static void algMaxAnalysis(double max, int trials, int base, int multiplier, boolean exp) {
		double avgTrials = 0;
		long start, end;
		
		int limit;
		
		if (exp) 
			limit = 4; 
		else
			limit = (10000 - base) / multiplier;
		
		List<Collidable> cUnits = new ArrayList<Collidable>();
		
		for (int s = 0; s < 4; s++) {
			
			for (int r = 0; r < limit; r++) {
				int numObj;
				if (exp)
					numObj = (int) Math.pow(base, r);
				else 
					numObj = (int) base + multiplier*r;
				
				for (int t = 0; t < trials; t++) {
					for (int b = 0; b < numObj; b++)
						cUnits.add(CollidableCircle.randBall(5, 0, WIDTH, 0, HEIGHT));
					
					start = new Date().getTime();
					CollisionDetector.optimizer(cUnits, s, HEIGHT, WIDTH);
					end = new Date().getTime();
					long execTime = end - start;
					avgTrials += execTime;
					cUnits.clear();
				}
				
				avgTrials /= trials;
				
				if (avgTrials > max) {
					switch (s) {
					case 0: 
						System.out.println("N2 Algorithm Non-Threaded Max Objects: " + numObj);
						break;
					case 1:
						System.out.println("N2 Algorithm Threaded Max Objects: " + numObj);
						break;
					case 2:
						System.out.println("QTree Algorithm Non-Threaded Max Objects: " + numObj);
						break;
					case 3:
						System.out.println("QTree Algorithm Threaded Max Objects: " + numObj);
						break;
					default:
						break;
					}
					avgTrials = 0;
					break;
				}
				
				avgTrials = 0;
			}
			
		}
		
	}
	
	public static void algAnalysis(int runs, int trials, int base, int multiplier, boolean exp) {
		double avgTrials = 0, avgRuns = 0;
		long start, end, rStart, rEnd;
		
		int state = 0;
		PrintWriter output = null;
		
		try {
			output = new PrintWriter("optimizerOutput.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Collidable> collidableUnits = new ArrayList<Collidable>();
		
		for (int r = 0; r < runs; r++) {
			int numObj;
			if (exp)
				numObj = (int) Math.pow(base, r);
			else 
				numObj = (int) base + multiplier*r;
			System.out.println("Run: " +  (r+1) + " " + numObj + " Objects.");
			output.println("Run: " + (r + 1) + " Number of Objects: " + numObj + " Number of Trials: " + trials);
			for (state = 0; state < 4; state++) {
				switch (state) {
				case 0: 
					System.out.println("State: N2 Algorithm Non-Threaded");
					output.println("\tN2 Algorithm Non-Threaded,");
					break;
				case 1:
					System.out.println("State: N2 Algorithm Threaded");
					output.println("\tN2 Algorithm Threaded,");
					break;
				case 2:
					System.out.println("State: QTree Algorithm Non-Threaded");
					output.println("\tQTree Algorithm Non-Threaded,");
					break;
				case 3:
					System.out.println("State: QTree Algorithm Threaded");
					output.println("\tQTree Algorithm Threaded,");
					break;
				default:
					break;
				}
				
				avgTrials = 0;
				for (int t = 0; t < trials; t++) {
					for (int b = 0; b < numObj; b++)
						collidableUnits.add(CollidableCircle.randBall(5, 0, WIDTH, 0, HEIGHT));
					
					start = new Date().getTime();
					CollisionDetector.optimizer(collidableUnits, state, HEIGHT, WIDTH);
					end = new Date().getTime();
					long execTime = end - start;
					if (MULTIPOINT)
						output.println(execTime + ",");
					avgTrials += execTime;
					double percent = (((double) t+1.0) /((double) trials)) * 100.0;
					updateProgress(percent);
					collidableUnits.clear();
				}
				avgTrials /= trials;
				output.println("\t\tAverage Trial Execution Time," + avgTrials + ",");
				System.out.println("\nAverage Trial Execution Time: " + String.format("%.2f", avgTrials) + "ms");
			}
		}
		
		System.out.println("Algorithmic Analysis Simulation Complete!");
		output.close();
	}
	
	public static void updateProgress(double percentage) {
		final int width = 50;
		
		double per = percentage / 100;
		
		System.out.print("\r[");
		int i = 0;
		for (; i <= (int) (per*width); i++) {
			System.out.print("=");
		}
		for (; i < width; i++) {
			System.out.print(" ");
		}
		System.out.print("]: " + percentage + "%");
	}
	

}
