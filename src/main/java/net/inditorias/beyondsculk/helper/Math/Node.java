package net.inditorias.beyondsculk.helper.Math;

/**
 * Represents a node for interpolation.
 *
 * <p>The {@link #tension}, {@link #bias} and {@link #continuity} fields
 * are parameters for the Kochanek-Bartels interpolation algorithm.</p>
 */
public class Node {

    private Vector3 position;

    private double tension;
    private double bias;
    private double continuity;

    public Node() {
        this(Vector3.ZERO);
    }

    public Node(Node other) {
        this.position = other.position;

        this.tension = other.tension;
        this.bias = other.bias;
        this.continuity = other.continuity;
    }

    public Node(Vector3 position) {
        this.position = position;
    }


    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getContinuity() {
        return continuity;
    }

    public void setContinuity(double continuity) {
        this.continuity = continuity;
    }

}
