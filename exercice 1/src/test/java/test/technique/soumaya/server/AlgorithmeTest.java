package test.technique.soumaya.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlgorithmeTest {
	
	@Test
	 public void countPairsWithDiff() {
		Integer[] array = new Integer[] { 1, 7, 5, 9, 2, 12, 3};
		int count = Algorithme.countPairsWithDiff(2, array);
		assertEquals(4,count);
	}
	

}
