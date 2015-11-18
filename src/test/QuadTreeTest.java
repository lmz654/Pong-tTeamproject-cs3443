package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import game.core.Ball;
import game.math.Collidable;
import game.math.CollidableCircle;
import game.math.CollisionDetectorThread;
import game.math.structures.CollidableQTree;
import game.math.structures.Vector;

public class QuadTreeTest {

	public static void main(String[] args) {
		long spop, epop, sret, eret, sQT, eQT, sQTS, eQTS, sQTP, eQTP, sN2, eN2; 
		long popTime, retrTime, cCheckTimeQTSeriesSingle, cCheckTimeQTSeries, cCheckTimeQTParallel, cCheckTimeN2=0;
		long runStart, runEnd, runTime;
		int base = 1, multiplier = 10, run = 0, subRun = 0, nRuns = 4, nSubRuns = 10 ;
		
		int[][][] data = new int[nRuns][nSubRuns][6];
		
		//System.out.println("Tree Bounds(Before insertion): \n" + qT.printBounds());
		CollidableCircle cTest = new CollidableCircle(new Ball(Vector.getRand(new int[] { 80, 10 }, new int[] { 80, 10 }),
				Vector.getRand(0, 0), 5));
		
		/*while (run < nRuns) {
			int numBalls = (int) (base*(Math.pow(multiplier, run+1)));
							
			while (subRun < nSubRuns) {	
				
				// Creating Test Units
				runStart = new Date().getTime();
				CollidableQTree qT = new CollidableQTree(0, 0, 100, 0, 100);
				List<Collidable> cUnits = new ArrayList<Collidable>();
				
				for (int i = 0; i < numBalls; i++) {
					cUnits.add(new CollidableCircle(new Ball(Vector.getRand(new int[] {80, 10}, new int[] {80, 10}),
							Vector.getRand(0, 0), 5)));
				}
				
				// Calculating Population time
				spop = new Date().getTime();
				for (int i = 0; i<cUnits.size(); i++) {
					qT.insert(cUnits.get(i));
				}		
				epop = new Date().getTime();				
				popTime = epop-spop;
				
				//System.out.println("Tree Bounds(After insertion): \n" + qT.printBounds());
				//System.out.println(qT.printTree());
				
				// Inserting single Test unit
				qT.insert(cTest);
				cUnits.add(cTest);
				
				// Calculating time for possible collision retrieval
				sret = new Date().getTime();
				List<Collidable> possibleCollisions = qT.retrieve(cTest);
				eret = new Date().getTime();
				retrTime = eret-sret;
				
				// Calculating time for single collision check
				int collisions = 0;
				sQT = new Date().getTime();
				for (int i = 0; i < possibleCollisions.size(); i++) {
					if (cTest.intersects(possibleCollisions.get(i)) != null)
						collisions++;
				}
				eQT = new Date().getTime();
				cCheckTimeQTSeriesSingle = eQT - sQT;
				
				// Calculating time for all collisions using QT in Series
				qT = new CollidableQTree(0, 0, 100, 0, 100);
				cUnits = new ArrayList<Collidable>();
				for (int i = 0; i < numBalls; i++) {
					cUnits.add(new CollidableCircle(new Ball(Vector.getRand(new int[] {80, 10}, new int[] {80, 10}),
							Vector.getRand(0, 0), 5)));
				}
				collisions = 0;
				possibleCollisions.clear();
				sQTS = new Date().getTime();
				for (Collidable a : cUnits) {
					possibleCollisions = qT.retrieve(a);
					for (Collidable b: possibleCollisions) {
						if (a.intersects(b) != null)
							collisions++;
					}
				}
				eQTS = new Date().getTime();
				cCheckTimeQTSeries = eQTS - sQTS;
				
				// Calculating time for all collisions using QT in Parallel
				qT = new CollidableQTree(0, 0, 100, 0, 100);
				cUnits = new ArrayList<Collidable>();
				for (int i = 0; i < numBalls; i++) {
					cUnits.add(new CollidableCircle(new Ball(Vector.getRand(new int[] {80, 10}, new int[] {80, 10}),
							Vector.getRand(0, 0), 5)));
				}
				collisions = 0;
				possibleCollisions.clear();
				sQTP = new Date().getTime();
				// Starting Threads
				List<Thread> threads = new ArrayList<Thread>();
				for (Collidable c: cUnits) {
					Runnable task = new CollisionDetectorParallel(c, qT.retrieve(c), null);
					Thread worker = new Thread(task);
					
					worker.start();
					threads.add(worker);
				}
				
				int running = 0;
				do {
					running = 0;
					for (Thread thread: threads)
						if(thread.isAlive())
							running++;
					// System.out.println(running + " Threads still running");
				} while (running > 0);
				
				eQTP = new Date().getTime();
				cCheckTimeQTParallel = eQTP - sQTP;
				
				
				// Calculating time for all Collisions using N2 
				qT = new CollidableQTree(0, 0, 100, 0, 100);
				cUnits = new ArrayList<Collidable>();
				for (int i = 0; i < numBalls; i++) {
					cUnits.add(new CollidableCircle(new Ball(Vector.getRand(new int[] {80, 10}, new int[] {80, 10}),
							Vector.getRand(0, 0), 5)));
				}
				sN2 = new Date().getTime();
				for (Collidable a: cUnits) {
					for (Collidable b: cUnits) {
						if (a.equals(b)) continue;
						if (a.intersects(b) != null)
							collisions++;
					}
				}
				eN2 = new Date().getTime();
				cCheckTimeN2 = eN2 - sN2;
				
				runEnd = new Date().getTime();
				runTime = runEnd - runStart;
				//double checkRate = 1.0/(cCheckTimeQTSeries/1000.0);
				
				data[run][subRun][0] = numBalls;
				data[run][subRun][1] = (int) popTime;
				data[run][subRun][2] = (int) retrTime;
				data[run][subRun][3] = (int) cCheckTimeN2;
				data[run][subRun][4] = (int) cCheckTimeQTSeries;
				data[run][subRun][5] = (int) cCheckTimeQTParallel;
				
				//System.out.println("Run " + run + " Complete with " + numBalls +" balls in " + runTime +"ms: " + ((double)++subRun/(double)nRuns)*100.0 + "%");
				subRun++;
				qT.clear();
				cUnits.clear();
			}
			
			run++;
			subRun = 0;
			
		}
		
		System.out.println("Run\tSubRun\tNumber of Balls\tPop. Time\tRetr. Time\tCheck Time n^2\tCheck Time QTS\tCheck Time QTP");
		
		for (int i = 0; i < nRuns; i++) {
			System.out.print(i+1);
			for (int j = 0; j < nSubRuns; j++) {
				System.out.print("\t" + (j+1) +"\t");
				for (int k = 0; k < 6; k++) {
					//avg += (double)data[i][j][k];
					System.out.print(data[i][j][k] + "\t\t");
				}
				//avg /= nSubRuns;
				System.out.print("\n");
			}
		}*/
		
		CollidableQTree qT = new CollidableQTree(0, 0, 100, 0, 100);
		List<Collidable> cUnits = new ArrayList<Collidable>();
		
		for (int i = 0; i < 15; i++) {
			Collidable c = new CollidableCircle(new Ball(Vector.getRand(new int[] {80, 10}, new int[] {80, 10}),
					Vector.getRand(0, 0), 5));
			
			qT.insert(c);
			System.out.println(c.getBounds());
		}
		
		System.out.println(qT.printTree());
		System.out.println(qT.printBounds());
		

	}
	

}
