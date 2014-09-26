import java.util.Random;


public class Neighbors {
	final static Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
	
    public Neighbors(int n) {
        cells = new Living[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j] = new Empty(i,j);
        }
        public void clearNeighborCounts() {
            Fox.neighborCount.setValue(0);
            Rabbit.neighborCount.setValue(0);
            Grass.neighborCount.setValue(0);
            Empty.neighborCount.setValue(0);
        }
        public void eden() {
        	final double x = RNG.nextDouble();
            if (x < 0.1)      return /* Fox    */
            else if (x < 0.3) return /* Rabbit */
            else if (x < 0.6) return /* Grass  */
            else              return /* Empty  */
        }
        public String toString() {
            return "To be complete";
        }
        public void update(Neighbors oldWorld) {
            //borders are taboo
            for (int i = 1; i < size - 1; i++)
                for (int j = 1; j < size - 1; j++)
                    cells[i][j] = oldWorld.cells[i][j].next(oldWorld);
        }
        Living[][] cells;
        private int size;     
}