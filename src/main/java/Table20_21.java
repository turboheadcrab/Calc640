import java.util.Scanner;

/**
 * Created by Apraxin Vladimir on 3.4.17.
 */
public class Table20_21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i;
        int nSum = 0;
        int step;
        double sampleMeanStar = 0;
        double varianceStar = 0;
        double standardDeviationStar;

        System.out.print("i = ");
        i = scanner.nextInt();
        System.out.println();

        int[] n_iArray = new int[i];
        int[] x_iArray = new int[i];
        int[] x_iPlusArray = new int[i];
        double[] x_iStarArray = new double[i];
        double[] x_iSampleMeanDiffArray = new double[i - 1];
        double[] x_iPlusSampleMeanDiffArray = new double[i - 1];
        double[] z_iArray = new double[i - 1];
        double[] z_iPlusArray = new double[i - 1];


        System.out.println("n_i Table");
        for (int j = 0; j < i; j++) {
            System.out.print("n_" + (j + 1) + " = ");
            n_iArray[j] = scanner.nextInt();
            nSum += n_iArray[j];
        }

        System.out.println("nSum = " + nSum);
        System.out.println();

        System.out.print("x_1 = ");
        x_iArray[0] = scanner.nextInt();
        System.out.println();

        System.out.print("step = ");
        step = scanner.nextInt();
        System.out.println();

        System.out.println("x_i Table");
        System.out.println("x_1 = " + x_iArray[1]);
        for (int j = 1; j < i; j++) {
            x_iArray[j] = x_iArray[j - 1] + step;
            System.out.println("x_" + (j + 1) + " = " + x_iArray[j]);
        }
        System.out.println();

        System.out.println("x_iPlus Table");
        for (int j = 0; j < i; j++) {
            x_iPlusArray[j] = x_iArray[j] + step;
            System.out.println("x_" + (j + 1) + "Plus = " + x_iPlusArray[j]);
        }
        System.out.println();

        System.out.println("x_iStar Table");
        for (int j = 0; j < i; j++) {
            x_iStarArray[j] = (x_iArray[j] + x_iPlusArray[j]) / (double) 2;
            System.out.println("x_" + (j + 1) + "Star = " + x_iStarArray[j]);
        }
        System.out.println();

        System.out.print("Sample Mean Star = ");
        for (int j = 0; j < i; j++) {
            sampleMeanStar += x_iStarArray[j] * n_iArray[j];
        }
        sampleMeanStar = sampleMeanStar / (double) nSum;
        System.out.println(sampleMeanStar);

        System.out.print("Variance Star = ");
        for (int j = 0; j < i; j++) {
            double intermediate = x_iStarArray[j] - sampleMeanStar;
            intermediate = rrround(intermediate, 2);

            intermediate = intermediate * intermediate;
            intermediate = rrround(intermediate, 2);

            intermediate = intermediate * n_iArray[j];
            intermediate = rrround(intermediate, 2);

            varianceStar += intermediate;
        }
        varianceStar = varianceStar / (double) (nSum - 1);
        varianceStar = rrround(varianceStar, 2);
        System.out.println(varianceStar);

        standardDeviationStar = Math.sqrt(varianceStar);
        standardDeviationStar = rrround(standardDeviationStar, 2);
        System.out.println("Standard Deviation Star = " + standardDeviationStar);
        System.out.println();

        System.out.println("x_iDiff Table");
        for (int j = 0; j < i - 1; j++) {
            x_iSampleMeanDiffArray[j] = x_iArray[j + 1] - sampleMeanStar;
            x_iSampleMeanDiffArray[j] = rrround(x_iSampleMeanDiffArray[j], 2);
            System.out.println("x_" + (j + 2) + "Diff = " + x_iSampleMeanDiffArray[j]);
        }
        System.out.println();

        System.out.println("x_iPlusDiff Table");
        for (int j = 0; j < i - 1; j++) {
            x_iPlusSampleMeanDiffArray[j] = x_iPlusArray[j] - sampleMeanStar;
            x_iPlusSampleMeanDiffArray[j] = rrround(x_iPlusSampleMeanDiffArray[j], 2);
            System.out.println("x_" + (j + 1) + "Plus Diff = " + x_iPlusSampleMeanDiffArray[j]);
        }
        System.out.println();

        System.out.println("z_i Table");
        for (int j = 0; j < i - 1; j++) {
            z_iArray[j] = x_iSampleMeanDiffArray[j] / standardDeviationStar;
            z_iArray[j] = rrround(z_iArray[j], 2);
            System.out.println("z_" + (j + 2) + " = " + z_iArray[j]);
        }
        System.out.println();

        System.out.println("z_iPlus Table");
        for (int j = 0; j < i - 1; j++) {
            z_iPlusArray[j] = x_iPlusSampleMeanDiffArray[j] / standardDeviationStar;
            z_iPlusArray[j] = rrround(z_iPlusArray[j], 2);
            System.out.println("z_" + (j + 1) + "Plus = " + z_iPlusArray[j]);
        }
        System.out.println();
    }

    private static double rrround(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
