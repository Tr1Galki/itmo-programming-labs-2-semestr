package data.vehiclec;

import java.io.Serializable;

/**
 * The Coordinates.
 *
 * @author Alever
 */
public class Coordinates implements Serializable {
    /**
     * The X.
     */
    private long x; //Значение поля должно быть больше -893
    /**
     * The Y.
     */
    private Double y; //Значение поля должно быть больше -308, Поле не может быть null\2

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(long x, Double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x coordinate.
     *
     * @return the x long
     */
    public long getX() {
        return x;
    }

    /**
     * Sets x coordinate.
     *
     * @param x the x long
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * Gets y coordinate.
     *
     * @return the y Double
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y Double
     */
    public void setY(Double y) {
        this.y = y;
    }
}
