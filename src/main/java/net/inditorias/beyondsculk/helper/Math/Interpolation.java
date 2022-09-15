package net.inditorias.beyondsculk.helper.Math;

import java.util.List;

/**
 * Represents an arbitrary function in &#8477; &rarr; &#8477;<sup>3</sup>.
 */
public interface Interpolation {

    /**
     * Sets nodes to be used by subsequent calls to
     * {@link #getPosition(double)} and the other methods.
     *
     * @param nodes the nodes
     */
    void setNodes(List<Node> nodes);

    /**
     * Gets the result of f(position).
     *
     * @param position the position to interpolate
     * @return the result
     */
    Vector3 getPosition(double position);

    /**
     * Gets the result of f'(position).
     *
     * @param position the position to interpolate
     * @return the result
     */
    Vector3 get1stDerivative(double position);

    /**
     * Gets the result of &int;<sub>a</sub><sup style="position: relative; left: -1ex">b</sup>|f'(t)| dt.<br />
     * That means it calculates the arc length (in meters) between positionA
     * and positionB.
     *
     * @param positionA lower limit
     * @param positionB upper limit
     * @return the arc length
     */
    double arcLength(double positionA, double positionB);

    /**
     * Get the segment position.
     *
     * @param position the position
     * @return the segment position
     */
    int getSegment(double position);

}
