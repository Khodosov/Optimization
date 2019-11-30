public class Simplex {
    // Для многомерной f1(x, y) = 100(y - x)^2 + 5(1 - x)^2
    //                 f2(x, y) = (x^2 + y - 11)^2 + (x + y^2 - 7)^2

    // Использован класс Vector, в котором реализованиы действия
    // над векторами (+, -, * alpha ...), его координатный вывод

    public static Vector simplex() {
        // Const description
        double alpha = 1.0;
        double betta = 0.5;
        double gamma = 2.0;
        int maxiter = 20;

        Vector v1 =  new Vector(0,0);
        Vector v2 = new Vector(1.0, 0);
        Vector v3 = new Vector(0, 1.0);

        Vector best = null;
        Vector good = null;
        Vector worst = null;

        for (int i = 0; i < maxiter; i++){
            double f_v1 = func(v1.c());
            double f_v2 = func(v2.c());
            double f_v3 = func(v3.c());
            /*System.out.println("========================");
            System.out.println(f_v1);
            System.out.println(f_v2);
            System.out.println(f_v3);
            System.out.println("========================");*/
            // Sort =========================С=======
            if (f_v1 <= f_v2 && f_v1 <= f_v3){
                best = v1;
                if (f_v2 <= f_v3){
                    good = v2;
                    worst = v3;
                }else {
                    good = v3;
                    worst = v2;
                }
            }
            if (f_v2 <= f_v1 && f_v2 <= f_v3){
                best = v2;
                if (f_v1 <= f_v3){
                    good = v1;
                    worst = v3;
                }else {
                    good = v3;
                    worst = v1;
                }
            }
            if (f_v3 <= f_v2 && f_v1 <= f_v1){
                best = v3;
                if (f_v2 <= f_v1){
                    good = v2;
                    worst = v1;
                }else {
                    good = v1;
                    worst = v2;
                }
            }
            // Sort ================================


            // mid = ((x1+x2) / 2; (y1+y2) / 2)
            Vector mid = new Vector((good.getX() + best.getX()) / 2, (good.getY() + best.getY()) / 2);

            // reflection

            // xr = mid + alpha * (mid - worst)
            Vector xr = mid.add(mid.sub(worst).num_mul(alpha));

            if (func(xr.c()) < func(good.c())){
                worst = xr;
            }else{
                if (func(xr.c()) < func(worst.c())){
                    worst = xr;
                }
                Vector c = worst.add(mid).div_by_num(2);
                if (func(c.c()) < func(worst.c())){
                    worst = c;
                }
            }
            if (func(xr.c()) < func(best.c())){
                // expansion расстяжение

                // xe = mid + gamma * (xr - mid)
                Vector xe = mid.add(xr.sub(mid).num_mul(gamma));

                if (func(xe.c()) < func(xr.c())){
                    worst = xe;
                }else {worst = xr;}
            }
            if (func(xr.c()) < func(good.c())){
                // contraction сжатие
                // xc = mid + betta * (worst - mid)
                Vector xc = mid.add(worst.sub(mid).num_mul(betta));
                if (func(xc.c()) < func(worst.c())){
                    worst = xc;
                }
            }
            v1 = worst;
            v2 = good;
            v3 = best;

        }
        return best;
    }
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
