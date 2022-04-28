/*
 * Name: Alan Wu
 * Pennkey: wualan
 * 
 * Recitation: 208
 * 
 * Execution: java Nbody double simulationTime double timeStep String fileName
 * 
 * This program simulates a solar system using Newton's laws of gravitation within 
 * the specified time defined in the args array.the
 */

public class NBody {
    public static void main(String[] args) {
        // Variables to be used later in the program
        double simulationTime = Double.parseDouble(args[0]); // Length of sim
        double timeStep = Double.parseDouble(args[1]); // Time increments
        String fileName = args[2]; // Which file to use
        
        In inStream = new In(fileName); // Sets up file reader
        
        int numBodies = inStream.readInt(); // Number of celestial bodies in sim
        double radius = inStream.readDouble(); // Radius of our simulated universe
        
        double timeElapsed = 0; // Time elapsed in the simulation
        
        // Arrays of values for the simulation
        double[] m = new double[numBodies]; // Mass of celestial body
        double[] px = new double[numBodies]; // Initial x position of body
        double[] py = new double[numBodies]; // Initial y position of body
        double[] vx = new double[numBodies]; // Initial x velocity of body
        double[] vy = new double[numBodies]; // Initial y velocity of body
        String[] img = new String[numBodies]; // Image of body
        
        // Initializes the arrays
        for (int i = 0; i < numBodies; i++) {
            m[i] = inStream.readDouble();
            px[i] = inStream.readDouble();
            py[i] = inStream.readDouble();
            vx[i] = inStream.readDouble();
            vy[i] = inStream.readDouble();
            img[i] = inStream.readString();
        }
        
        // Enables animation
        PennDraw.enableAnimation(30);
        
        // Creates the time loop
        while (timeElapsed < simulationTime) {
            // Defines the gravitational constatn
            double G = 6.67e-11;
            
            // Clears the canvas
            PennDraw.clear();
            
            // Draws the canvas
            PennDraw.setXscale(-radius, radius);
            PennDraw.setYscale(-radius, radius);
            PennDraw.picture(0.5, 0.5, "starfield.jpg");
        
            // Draws the celestial bodies
            for (int i = 0; i < numBodies; i++) {
                PennDraw.picture(px[i], py[i], img[i]);
            }
            
            //Updates velocities
            for (int i = 0; i < numBodies; i++) {
                double force = 0;
                double forceX = 0; // Force in the x direction
                double forceY = 0; // Force in the y direction
                double accelerationX = 0; // Acceleration in the x direction
                double accelerationY = 0; // Acceleration in the y direction
                
                
                for (int j = 0; j < numBodies; j++) {
                    if (i != j) {
                        double d = Math.sqrt((px[j] - px[i]) * (px[j] - px[i]) + 
                                             (py[j] - py[i]) * (py[j] - py[i]));
                        force = ((G * m[j]) / (d * d)) * m[i];
                        forceX += force * ((px[j] - px[i]) / d);
                        forceY += force * ((py[j] - py[i]) / d);
                    }
                }

                accelerationX = forceX / m[i];
                accelerationY = forceY / m[i];
                vx[i] += accelerationX * timeStep;
                vy[i] += accelerationY * timeStep;
                
            }
           
            // Updates the position of the bodies
            for (int i = 0; i < numBodies; i++) {
                px[i] += vx[i] * timeStep;
                py[i] += vy[i] * timeStep;
            }
            
            timeElapsed += timeStep;
            PennDraw.advance();
        }
        
        System.out.printf("%d\n", numBodies);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numBodies; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", m[i], 
                              px[i], py[i], vx[i], vy[i], img[i]);
        }
    }
}