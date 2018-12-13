package model;

/**
 * Class for points (x and y), representing coordinates used for vectors and positions on the plane.
 *
 */
public class Point {
    private double x; //x coordinate
    private double y; //y coordinate

    /**
     * Constructor for initializing instances with a x and y coordinate.
     * @param x
     * @param y
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this(point.getX(), point.getY());
    }

    /**
     *
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Sets x coordinate to value of argument
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets y coordinate to value of argument
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }


    /**
     * Sets coordinates x and y to values given in argument by
     * calling the setX() and setY() methods.
     * See methods setX() and setY().
     * @param x
     * @param y
     */
    public void setPoint(double x, double y){
        this.setX(x);
        this.setY(y);
    }


    /**
     * Sets coordinates to same as those of argument by
     * calling the setPoint(double, double) method.
     * @param point
     */
    public void setPoint(Point point){
        setPoint(point.getX(), point.getY());
    }


    /**
     * Checks if the x and y coordinate values equal those of the Point given in argument.
     * @param other
     * @return
     */
    public boolean equals(Point other){
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}
