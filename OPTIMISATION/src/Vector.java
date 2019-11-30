public class Vector {
    private double x;
    private double y;
    private final double EPS = 0.00000001;
    private final double INF = 1000000000;
    public double d1 = 999999999;
    public double d2 = 999999999;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final void setX(double x) {
        this.x = x;
    }

    public final void setY(double y) {
        this.y = y;
    }

    public String repr() {
        return "{" + x + ", " + y + "}";
    }

    public Vector add(Vector other) {
        double newX = x + other.x;
        double newY = y + other.y;
        return new Vector(newX, newY);
    }

    public Vector sub(Vector other) {
        double newX = x - other.x;
        double newY = y - other.y;
        return new Vector(newX, newY);
    }

    public Vector div_by_num(double number) {
        double newX = x / number;
        double newY = y / number;
        return new Vector(newX, newY);
    }

    public Vector num_mul(double number) {
        double newX = x * number;
        double newY = y * number;
        return new Vector(newX, newY);
    }

    public double[] c() {
        return new double[]{x, y};
    }

    // Значение первой функции
    public double f() {
        return 100 * Math.pow((y - Math.pow(x, 2)), 2) + 5 * Math.pow((1 - x), 2);
    }

    // Значение второй функции
    /*public double f(){
        return Math.pow((Math.pow(x, 2)) + y - 11, 2) +Math.pow((x + Math.pow(y, 2) - 7), 2);
    }*/
    public double gradientSquare() {
        return Math.pow(fdx1(), 2) + Math.pow(fdx2(), 2);
    }

    // для первой функции:
    // Значения производных берутся с обратным знаком из-за специфики алгоритма (направление антиградиента)
    public double fdx1() {
        double result = -1;
        if (d1 != 999999999){
            return d1;
        }
        return result * (400 * Math.pow(x, 3) - 400 * x * y + 10 * x - 10);
    }

    public double fdx2() {
        double result = -1;
        if (d2 != 999999999){
            return  d2;
        }
        return result * (200 * y - 200 * Math.pow(x, 2));
    }

    // для второй функциии:
    /*public double fdx1(){
        double result = -1;
        return result * (4 * x * (Math.pow(x, 2) + y - 11) + 2 * (x + Math.pow(y , 2) - 7));
    }
    public double fdx2(){
        double result = -1;
        return result * (2 * (Math.pow(x, 2) + y - 11) + 4 * y * (x + Math.pow(y, 2) - 7));
    }*/
    public double dihotomia() {
        double l = -1 * INF;
        double r = INF;
        double cl;
        double cr;
        while (Math.abs(r - l) > EPS) {
            cl = (r + l) * 0.5 - 0.1 * EPS;
            cr = (r + l) * 0.5 + 0.1 * EPS;
            Vector vector1 = new Vector(x + cl + fdx1(), y + cl * fdx2());
            Vector vector2 = new Vector(x + cr + fdx1(), y + cr * fdx2());
            if (vector1.f() <= vector2.f()) {
                r = cr;
            } else {
                l = cl;
            }
        }
        return (r + l) / 2;
    }

    public Vector getNextVector(double alpha) {
        return new Vector(x + alpha * fdx1(), y + alpha * fdx2());
    }
}
