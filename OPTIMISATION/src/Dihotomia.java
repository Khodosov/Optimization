import static java.lang.StrictMath.exp;

public class Dihotomia {
    // f(x) = ax + b/(e^x)
    public double dihotomia(double a, double b) {
        double x;
        double F1;
        double F2;
        // Левая и правая границы области
        double left = -100000;
        double right = 100000;
        // ==============================
        // Точность
        double Delta = 0.0000001;
        double Eps = 2 * Delta + 0.00000001;
        while (Math.abs((right - left)) >= Eps) {
            x = (left + right) / 2;
            F1 = func(a, b, x - Delta);
            F2 = func(a, b, x + Delta);
            /*так как ищем min спавниваем следующим образом
            если будет нужно искать максимум, то знак неравенства необходимо поменять на противоположный
            */
            if (F1 < F2) {
                right = x;
            } else {
                left = x;
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
