public class ConjugateGradient {
    // Для многомерной f1(x, y) = 100(y - x)^2 + 5(1 - x)^2
    //                 f2(x, y) = (x^2 + y - 11)^2 + (x + y^2 - 7)^2

    // Использован класс Vector, в котором реализованиы действия
    // над векторами (+, -, * alpha ...), его координатный вывод

    // функции, для которых необходимо реализовать методы
    private static double func(double[] point){
        double x = point[0];
        double y = point[1];
        return 100 * Math.pow((y - x), 2) + 5 * Math.pow((1 - x), 2);
    }
    /*private static double func(double[] point){
        double x = point[0];
        double y = point[1];
        return Math.pow((Math.pow(x, 2)) + y - 11, 2) +Math.pow((x + Math.pow(y, 2) - 7), 2);
    }*/
    // ==========================
    public static final double EPS = 0.00000001;
    public static final double INF = 1000000000;

    public static Vector conjugateGradient(){
        int iterCount = 0;
        double alpha;
        double beta;
        Vector v2 = new Vector(-10, -5);
        Vector v1;

        double gradientSquere = v2.gradientSqure();
        double newGradientSqure;

        while (gradientSquere > EPS){
            iterCount++;
            alpha = v2.dihotomia();
            v1 = v2;
            v2 = v2.getNextVector(alpha);
            newGradientSqure = v2.gradientSqure();

            if (iterCount % 10 == 0){
                beta = 0;
            }else {beta = newGradientSqure/gradientSquere}
        }

    }
}
