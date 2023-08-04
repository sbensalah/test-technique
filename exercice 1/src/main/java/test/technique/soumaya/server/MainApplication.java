package test.technique.soumaya.server;

public class MainApplication {

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 1, 7, 5, 9, 2, 12, 3};
		int count = Algorithme.countPairsWithDiff(2, array);
		System.out.println("Count is equal to : " + count);
	}
}

