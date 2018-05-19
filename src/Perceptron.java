import java.util.Random;

public class Perceptron {

	public static void main(String[] args) {
		Random rnd = new Random();
		double TreinamentoIn[][] = { { 1, 0, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 1 } };
		double TreinamentoOut[][] = { { 0 }, { 0 }, { 0 }, { 1 } };

		double w[] = new double[3];
		w[0] = (rnd.nextDouble() * 2) - 1;
		w[1] = (rnd.nextDouble() * 2) - 1;
		w[2] = (rnd.nextDouble() * 2) - 1;

		// System.out.println("W " + w[0] + " " + w[1]+ " " + w[2]);
		// for (int i = 0; i < TreinamentoIn.length; i++) {
		// double r = neuronio(TreinamentoIn[i], w);
		// System.out.println("In " + TreinamentoIn[i][0] + "," +
		// TreinamentoIn[i][1] + "," + TreinamentoIn[i][2] + " = " + r + " [E="
		// + (TreinamentoOut[i][0] - r + "]"));
		// }

		for (int epoca = 0; epoca < 100; epoca++) {
			double dw[] = new double[3];

			for (int j = 0; j < TreinamentoIn.length; j++) {
				
				double r = neuronio(TreinamentoIn[j], w);
				double e = TreinamentoOut[j][0] - r;

				for (int i = 0; i < TreinamentoIn[j].length; i++) {
					dw[i] = TreinamentoIn[j][i] * e * 0.1;
					System.out.println("In " + TreinamentoIn[i][0] + "," + TreinamentoIn[i][1] + "," + TreinamentoIn[i][2] + " = " + r + " [E=" + (TreinamentoOut[i][0] - r + "]"));
				}
			}
			
			for (int i = 0; i < TreinamentoIn[0].length; i++) {
				w[i] += dw[i];
			}
		}
	}

	public static double neuronio(double in[], double w[]) {
		double soma = 0;
		for (int i = 0; i < in.length; i++) {
			soma += in[i] * w[i];
		}
		if (soma > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
