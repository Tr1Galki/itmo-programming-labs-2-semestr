package data;

public class Coordinates {
    private long x; //Значение поля должно быть больше -893
    private Double y; //Значение поля должно быть больше -308, Поле не может быть null

    public Coordinates(long x, Double y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
