

public class BicubicInterpolator extends CubicInterpolator {
	private double[] arr = new double[4];

	public double getValue(double[][] p, double x, double y) {
		int xi = (int) x;
		x -= xi;
		arr[0] = getValue(p[Math.max(0, xi - 1)], y);
		arr[1] = getValue(p[xi], y);
		arr[2] = getValue(p[Math.min(p.length - 1,xi + 1)], y);
		arr[3] = getValue(p[Math.min(p.length - 1, xi + 2)], y);
		return getValue(arr, x+ 1);
	}



	public class CubicInterpolator {
		public double getValue(double[] p, double x) {
			int xi = (int) x;
			x -= xi;
			double p0 = p[Math.max(0, xi - 1)];
			double p1 = p[xi];
			double p2 = p[Math.min(p.length - 1,xi + 1)];
			double p3 = p[Math.min(p.length - 1, xi + 2)];
			return p1 + 0.5 * x * (p2 - p0 + x * (2.0 * p0 - 5.0 * p1 + 4.0 * p2 - p3 + x * (3.0 * (p1 - p2) + p3 - p0)));
		}
	}

}
