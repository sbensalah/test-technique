package test.technique.soumaya.server;

import java.util.ArrayList;
import java.util.List;

public class Algorithme {

	public static int countPairsWithDiff(int diff, Integer[] array) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((Math.abs(array[i] - array[j]) == 2)) {
					list.add(array[i]);
					if (!list.contains(array[j])) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
