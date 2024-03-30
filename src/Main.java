import processing.core.*; // Importing Processing library
import java.util.ArrayList; // Import ArrayList
import processing.core.PApplet;
import peasy.*;

public class Main extends PApplet {
    float x = 0.01f, y = 0, z = 0; // Initial values for the variables x, y, and z
    float a = 10f, b = 28f, c = 8.0f / 3.0f; // Constants used in the Lorenz attractor equations

    ArrayList<PVector> points = new ArrayList<PVector>(); // ArrayList to store the points of the attractor trajectory
    PeasyCam cam; // PeasyCam object for easy camera control

    public void settings() {
        size(800, 600, P3D); // Setting up the canvas size with P3D renderer
    }

    public void setup() {
        cam = new PeasyCam(this, 500); // Initializing the PeasyCam object with distance from the origin
    }

    public void draw() {
        background(0); // Setting background color to black

        float dt = 0.01f; // Time step for numerical integration
        // Calculating the rate of change of variables x, y, and z using the Lorenz attractor equations
        float dx = (a * (y - x)) * dt;
        float dy = (x * (b - z) - y) * dt;
        float dz = (x * y - c * z) * dt;
        // Updating the variables x, y, and z
        x += dx;
        y += dy;
        z += dz;

        points.add(new PVector(x, y, z)); // Adding the new point to the ArrayList
        translate(0, 0, -80); // Translating the origin in the z-direction for better visualization
        scale(5); // Scaling up the visualization for better visibility
        stroke(255); // Setting stroke color to white
        noFill(); // No filling for shapes

        beginShape(); // Begin drawing a shape
        for (PVector v : points) { // Loop through each point in the ArrayList
            stroke(random(0, 255), random(0, 255), random(0, 255)); // Set stroke color randomly
            vertex(v.x, v.y, v.z); // Add a vertex to the shape at the coordinates of the point
        }
        endShape(); // End drawing the shape
    }

    public static void main(String[] args) {
        PApplet.main("Main"); // Launch the Processing sketch
    }
}
