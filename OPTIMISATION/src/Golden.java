import static java.lang.StrictMath.exp;

public class Golden {
    // f(x) = ax + b/(e^x)
    public double golden_search(double a, double b) {
        double x;
        double x1;
        double x2;

        double F1;
        double F2;
        // Левая и правая границы области
        double left = -100000;
        double right = 100000;
        // ==============================
        // Точность
        double Eps = 0.0000001;

        double FFF = (1 + Math.sqrt(5)) / 2;

        while (Math.abs((right - left)) > Eps) {
            x1 = right - (right - left) / FFF;
            x2 = left + (right - left) / FFF;
            F1 = func(a, b, x1);
            F2 = func(a, b, x2);
            if (F1 >= F2) {
                left = x1;
            } else {
                right = x2;
            }
        }
        x = (left + right) / 2;
        System.out.println("При x = " + x);
        return func(a, b, x);
    }

    private double func(double a, double b, double x) {
        return a * x + b / (exp(x));
    }
}
