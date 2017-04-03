import java.util.Scanner;

/**
 * Created by Apraxin Vladimir on 3.4.17.
 */
public class Table22_23 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i;
        int nSum = 0;
        double theorProbSum = 0;
        double theorFreqSum = 0;
        double chi = 0;
        double yepSum = 0;

        System.out.print("i = ");
        i = scanner.nextInt();
        System.out.println();

        int[] n_iArray = new int[i];
        double[] phiOfZ_i = new double[i];
        phiOfZ_i[0] = -0.5000;
        double[] phiOfZ_iPlus = new double[i];
        phiOfZ_iPlus[i - 1] = 0.5000;
        double[] theorProbArray = new double[i];
        double[] theorFreqArray = new double[i];
        double[] nDiffArray = new double[i];
        double[] nDiffSqrArray = new double[i];
        double[] chiSqrOverArray = new double[i];
        int[] n_iSqrArray = new int[i];
        double[] yepArray = new double[i];

        System.out.println("n_i Table");
        for (int j = 0; j < i; j++) {
            System.out.print("n_" + (j + 1) + " = ");
            n_iArray[j] = scanner.nextInt();
            nSum += n_iArray[j];
        }

        System.out.println("nSum = " + nSum);
        System.out.println();

        System.out.println("phiOfZ_i Table");
        System.out.println("phiOfZ_1 = " + phiOfZ_i[0]);
        for (int j = 1; j < i; j++) {
            double intermediate;
            System.out.print("phiOfZ_" + (j + 1) + " = ");
            intermediate = scanner.nextDouble();
            phiOfZ_i[j] = intermediate;
            phiOfZ_iPlus[j - 1] = intermediate;
        }
        System.out.println("phiOfZ_" + (i + 1) + " = " + phiOfZ_iPlus[i - 1]);
        System.out.println();

        System.out.println("p_i Table");
        for (int j = 0; j < i; j++) {
            theorProbArray[j] = phiOfZ_iPlus[j] - phiOfZ_i[j];
            theorProbArray[j] = rrround(theorProbArray[j], 4);
            theorProbSum += theorProbArray[j];
            System.out.println("p_" + j + " = " + theorProbArray[j]);
        }
        System.out.println("theorProbSum = " + theorProbSum);
        System.out.println();

        System.out.println("n'_i Table");
        for (int j = 0; j < i; j++) {
            theorFreqArray[j] = theorProbArray[j] * 100;
            theorFreqArray[j] = rrround(theorFreqArray[j], 2);
            theorFreqSum += theorFreqArray[j];
            System.out.println("n'_" + j + " = " + theorFreqArray[j]);
        }
        System.out.println("theorFreqSum = " + theorFreqSum);
        System.out.println();

        System.out.println("n_i - n'_i Table");
        for (int j = 0; j < i; j++) {
            nDiffArray[j] = n_iArray[j] - theorFreqArray[j];
            nDiffArray[j] = rrround(nDiffArray[j], 2);
            System.out.println("nDiff[" + j + "] = " + nDiffArray[j]);
        }
        System.out.println();

        System.out.println("(n_i - n'_i)^2 Table");
        for (int j = 0; j < i; j++) {
            nDiffSqrArray[j] = nDiffArray[j] * nDiffArray[j];
            nDiffSqrArray[j] = rrround(nDiffSqrArray[j], 4);
            System.out.println("nDiff^2[" + j + "] = " + nDiffSqrArray[j]);
        }
        System.out.println();

        System.out.println("Chi^2 over Table");
        for (int j = 0; j < i; j++) {
            chiSqrOverArray[j] = nDiffSqrArray[j] / theorFreqArray[j];
            chiSqrOverArray[j] = rrround(chiSqrOverArray[j], 4);
            chi += chiSqrOverArray[j];
            System.out.println("Chi^2 over[" + j + "] = " + chiSqrOverArray[j]);
        }
        chi = rrround(chi, 2);
        System.out.println("chi = " + chi);
        System.out.println();

        System.out.println("n_iSqr Table");
        for (int j = 0; j < i; j++) {
            n_iSqrArray[j] = n_iArray[j] * n_iArray[j];
            System.out.println("n_" + j + "Sqr = " + n_iSqrArray[j]);
        }
        System.out.println();

        System.out.println("yep Table");
        for (int j = 0; j < i; j++) {
            yepArray[j] = n_iSqrArray[j] / theorFreqArray[j];
            yepArray[j] = rrround(yepArray[j], 4);
            yepSum += yepArray[j];
            System.out.println("yep[" + j + "] = " + yepArray[j]);
        }
        yepSum = rrround(yepSum, 2);
        System.out.println("yep Sum = " + yepSum);
        System.out.println();
    }

    public static double rrround(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
