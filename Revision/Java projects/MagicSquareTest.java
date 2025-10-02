import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MagicSquareTest {
	@Test
	public void testMagicSquareFunction_TestReturnsTrueIf2DArrayIsTakenAsArgument() {
		MagicSquare squared = new MagicSquare();
		int[][] array = {{2, 3, 5}, {4, 5, 1}};
		assertTrue(squared.getMagicSquare(array));
	}



}		