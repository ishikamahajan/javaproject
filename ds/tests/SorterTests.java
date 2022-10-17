package ds.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import ds.sorter.MergeSorter;
import ds.sorter.SelectionSorter;
import ds.sorter.Sorter;
import ds.sorter.TimSorter;

class SelectionSorterTest {

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
	}

	static Stream<Sorter<Integer>> IntegerSorters() {
		return Stream.of(new SelectionSorter<Integer>(), new MergeSorter<Integer>(), new TimSorter<Integer>());
	}

	@ParameterizedTest
	@MethodSource("IntegerSorters")
	void testSort(Sorter<Integer> sorter) {

		int minimum = 0;
		int maximum = 15;

		ArrayList<Integer> input = new ArrayList<Integer>(
				IntStream.range(minimum, maximum).map(i -> maximum - i - 1).boxed().toList());

		ArrayList<Integer> expected = new ArrayList<Integer>(IntStream.range(minimum, maximum).boxed().toList());

		Collection<?> sorted = sorter.sort(input);

		System.out.print("Sorted array: ");
		Stream.of(sorted).forEach(System.out::println);

		System.out.print("Expected output: ");
		Stream.of(expected).forEach(System.out::println);

		assertArrayEquals(sorted.toArray(), expected.toArray(),
				"Reversed integer list is not sorted correctly using " + sorter.getClass());
	}

	@ParameterizedTest
	@MethodSource("IntegerSorters")
	void testReversedSort(Sorter<Integer> sorter) {
		int min = 0;
		int max = 15;

		ArrayList<Integer> input = new ArrayList<Integer>(IntStream.range(min, max).boxed().toList());

		ArrayList<Integer> expected = new ArrayList<Integer>(IntStream.range(min, max).boxed().toList());

		Collection<?> sorted = sorter.sort(input);

		assertArrayEquals(sorted.toArray(), expected.toArray());
	}
}
