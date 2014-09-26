import java.util.Random;


public class Simulation {
    final static Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
    
    public static void main(String[] args) {
        Neighbors odd = new Neighbors(10), even = new Neighbors(10);
        int i, cycles = 10;
        even.eden(); //generate initial World
        System.out.println(even); //print initial state
        for (i = 0; i < cycles; i++) {
            System.out.println("Cycle = " + i + "\n\n");
            if (i % 2 == 1) {
                even.update(odd);
                System.out.println(even);
            }
            else {
                odd.update(even);
                System.out.println(odd);
            }
        }
    }
}
