package ds.sorter;

import java.util.Comparator;
import java.util.List;

import ds.fruit.Fruit;

public class CustomSorting {

	/**
	 * This method must sort the fruit alphabetically by their type. Fruits must be
	 * sorted in the order Apple, Banana, Grape, Pear. The weight and ripeness of a
	 * fruit should not be considered.
	 * 
	 * @param list The list to sort.
	 * @return A sorted list.
	 */
	public static List<Fruit> sortByType(List<Fruit> list) {

		list.sort(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit object1, Fruit object2) {
				return object1.getType().toString().compareTo(object2.getType().toString());
			}
		});

		return list;

	}

	/**
	 * This method must sort the fruit by their ripeness value, from 100% ripe to 0%
	 * ripe. The type and weight of the fruit should not be considered.
	 * 
	 * @param list The fruit to sort
	 * @return A sorted list.
	 */
	public static List<Fruit> sortByRipeness(List<Fruit> list) {

		list.sort(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit object1, Fruit object2) {

				if (object1.getRipeness() < object2.getRipeness())
					return 1;
				else if (object1.getRipeness() > object2.getRipeness())
					return -1;
				return 0;
			}
		});

		return list;

	}
}
