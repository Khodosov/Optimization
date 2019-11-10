import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Для одномерной оптимизации f(x) = ax + b/(e^x)
    // Для многомерной f1(x, y) = 100(y - x)^2 + 5(1 - x)^2
    //                 f2(x, y) = (x^2 + y - 11)^2 + (x + y^2 - 7)^2

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Dihotomia dihotomia = new Dihotomia();
        Golden golden = new Golden();
        Simplex simplex = new Simplex();
        System.out.println(Simplex.simplex().repr());

        /*double a = 0;
        double b = 0;
        // ввод параметров
        System.out.println("Enter A");
        try {
            a = scanner.nextDouble();
        } catch (Exception e) {
            throw new IOException();
        }
        System.out.println("Enter B");
        try {
            b = scanner.nextDouble();
        } catch (Exception e) {
            throw new IOException();
        }
        // ================

        System.out.println("Дихотомия ===============================================================================");
        System.out.println("Функция f(x) = " + a + "*x + " + b + "/(e^x) " + "достигает своего минимума "
                + dihotomia.dihotomia(a, b));
        System.out.println("Метод золотого сечения  =================================================================");
        System.out.println("Функция f(x) = " + a + "*x + " + b + "/(e^x) " + "достигает своего минимума "
                + golden.golden_search(a, b));
        System.out.println("=========================================================================================");
*/
    }
}
