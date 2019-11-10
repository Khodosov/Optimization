import java.lang.reflect.Array;

public class Vector {
    private double x;
    private double y;
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String repr(){
        return "{" + Double.toString(x) + ", " + Double.toString(y) + "}";
    }
    public Vector add(Vector other){
        double newX = x + other.x;
        double newY = y + other.y;
        return new Vector(newX, newY);
    }
    public Vector sub(Vector other){
        double newX = x - other.x;
        double newY = y - other.y;
        return new Vector(newX, newY);
    }
    public Vector rmul(Vector other){
        double newX = x * other.x;
        double newY = y * other.y;
        return new Vector(newX, newY);
    }
    public Vector div(Vector other){
        double newX = x / other.x;
        double newY = y / other.y;
        return new Vector(newX, newY);
    }
    public Vector div_by_num(double number){
        double newX = x / number;
        double newY = y / number;
        return new Vector(newX, newY);
    }
    public Vector num_mul(double number){
        double newX = x * number;
        double newY = y * number;
        return new Vector(newX, newY);
    }
    public double[] c(){
        return new double[] {x, y};
    }


}
