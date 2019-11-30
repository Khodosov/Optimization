public class Gradient {
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



}
