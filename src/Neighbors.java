import java.util.Random;


public class Neighbors {
    //determines the sequence of random numbers
    final static Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
    
    public Living[][] cells;
    private int size;
    
    //constructor of Neighbors which can be used to create a new one
    public Neighbors(int n) {
        cells = new Living[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j] = new Empty(i,j);
        }
        
        //Set all the counts of each "species" to zero
        public void setCountToZero() {
            Fox.counting.setValue(0);
            Rabbit.counting.setValue(0);
            Grass.counting.setValue(0);
            Empty.counting.setValue(0);
        }
        
        //Called in the method eden() to generate the world
        public Living gen(int r, int c) {
            final double x = RNG.nextDouble();
            if (x < 0.1)      return new Fox(r, c, 0);
            else if (x < 0.3) return new Rabbit(r, c, 0);
            else if (x < 0.6) return new Grass(r, c);
            else              return new Empty(r, c);
            }
        
        //Method which generate the first world
        public void eden() {
            for (int row=1; row<size-1; row++) {
                for (int col=1; col<size-1; col++) {
                    cells[row][col] = gen(row, col);
                }
            }
        }
        public String toString() {
            return "To be complete";
        }
        
        //Method which update the new rows
        public void update(Neighbors oldNeighbors) {
            //borders are taboo
            for (int i = 1; i < size - 1; i++)
                for (int j = 1; j < size - 1; j++)
                    cells[i][j] = oldNeighbors.cells[i][j].next(oldNeighbors);
            }
        }
