package daily.coding.problem;

/*
 * Write a function that takes a natural number as input and returns the number of digits the input has. 
 * Constraint: don't use any loops.
 */
public class Problem372 {

	public static void main(String[] args) {
		System.out.println(getNumberDigits(12345));
		System.out.println(getNumberDigits(1));
		System.out.println(getNumberDigits(123));
	}

	private static int getNumberDigits(int number) {
		if (number < 10)
			return 1;

		return getNumberDigits(number / 10) + 1;
	}
}
