package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Traverser {

    private static final Logger logger = LogManager.getLogger();
    private Coordinates coordinates; 
    private Path path;
    private MovementPattern movement;
    private MovementAlgorithm navigator;

    public Traverser(Maze maze, Coordinates start, MovementAlgorithm algorithm) {
        logger.info("Traverser instantiated: current coordinates (" + start.getX() + "," + start.getY() + ")"); 
        this.path = new Path();
        this.coordinates = start;
        this.movement = new RightMovement();
        this.navigator = algorithm;
    }

    public void move(Maze maze) {
        logger.info("Move one step."); 
        Path move = navigator.getNextMoves(maze, coordinates, movement);
        path.addSteps(move);
        logger.info("Movement Complete: X: " + coordinates.getX() + " Y: " + coordinates.getY()); 
    }

    public String getPath() {
        return path.getSequence();
    }

    public String getCanonical() {
        return path.getCanonical();
    }

    public String getFactorized() {
        return path.getFactorized();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}