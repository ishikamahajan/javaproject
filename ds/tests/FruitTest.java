package ds.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds.fruit.Fruit;
import ds.fruit.InvalidFruitRipenessException;
import ds.fruit.InvalidFruitWeightException;

class FruitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFruitConstructor() throws InvalidFruitWeightException, InvalidFruitRipenessException {

		Fruit f = new Fruit(Fruit.TYPE.APPLE, 0.3, 1);

		assertEquals(Fruit.TYPE.APPLE, f.getType(), "Fruit type is incorrect");
		assertEquals(0.3, f.getWeight(), "Fruit weight is incorrect");
		assertEquals(1, f.getRipeness(), "Fruit ripeness is incorrect");

		assertThrows(InvalidFruitWeightException.class, () -> {
			new Fruit(Fruit.TYPE.APPLE, -1.0, .5);
		});

		assertThrows(InvalidFruitRipenessException.class, () -> {
			new Fruit(Fruit.TYPE.APPLE, 1.0, 1.1);
		});
	}

}
