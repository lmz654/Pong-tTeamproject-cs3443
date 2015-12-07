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
	public static final int RUNS = 4;
	public static final int TRIALS = 20;
	
	public static final int ROOT = 10;
	public static final int BASE = 10;
	
	public static final boolean MULTIPOINT = true;
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1000;
	
	public static void main(String[] args) {
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
		
		for (int r = 0; r < RUNS; r++) {
			int numObj = (int) (ROOT * Math.pow(BASE, r));
			System.out.println("Run: " +  (r+1));
			output.println("Run: " + (r + 1) + " Number of Objects: " + numObj + " Number of Trials: " + TRIALS);
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
				
				for (int t = 0; t < TRIALS; t++) {
					for (int b = 0; b < numObj; b++)
						collidableUnits.add(CollidableCircle.randBall(5, 0, WIDTH, 0, HEIGHT));
					
					start = new Date().getTime();
					CollisionDetector.optimizer(collidableUnits, state, HEIGHT, WIDTH);
					end = new Date().getTime();
					long execTime = end - start;
					if (MULTIPOINT)
						output.println(execTime + ",");
					avgTrials += execTime;
					double percent = (((double) t+1.0) /((double) TRIALS)) * 100.0;
					System.out.println("Percentage Complete: " + String.format("%.0f", percent) + "% in " + execTime + "ms");
					collidableUnits.clear();
				}
				avgTrials /= TRIALS;
				output.println("\t\tAverage Trial Execution Time," + avgTrials + ",");
				System.out.println("Average Trial Execution Time: " + String.format("%.2f", avgTrials) + "ms");
			}
			
		}
	
		output.close();

	}
	

}
