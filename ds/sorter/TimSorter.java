package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {

	static int RUN = 32;

	int min(int a1, int a2) {
		if (a1 < a2)
			return a1;
		else
			return a2;
	}

	// insertion sort
	void insertionSort(List<E> input, int start, int ending) {

		int i, j;
		E temp;
		for (i = start + 1; i <= ending; i++) {
			temp = input.get(i);
			j = i - 1;

			while (j >= start && temp.compareTo(input.get(j)) <= 0) {
				input.set(j + 1, input.get(j));
				j = j - 1;
			}
			input.set(j + 1, temp);
		}

	}

	@Override
	public List<E> sort(List<E> input) {
		int totalSize = input.size();
		for (int i = 0; i < totalSize; i += RUN)
			insertionSort(input, i, min((i + RUN - 1), (totalSize - 1)));
		for (int size = RUN; size < totalSize; size = 2 * size) {
			for (int start = 0; start < totalSize; start += 2 * size) {

				int center = start + size - 1;
				int end = min((start + 2 * size - 1), (totalSize - 1));
				List<E> left = new ArrayList<>();
				List<E> right = new ArrayList<>();
				if (input.size() == 1) {
					return input;
				} else {
					center = start + size - 1;
					for (int i = 0; i < center; i++) {
						left.add(input.get(i));
					}
					for (int i = center; i < end; i++) {
						right.add(input.get(i));
					}
					left = sort(left);
					right = sort(right);
				}
				if (center < end) {
					MergeSorter<E> mergeSorter = new MergeSorter<E>();
					mergeSorter.merge(input, left, right);
				}

			}
		}
		return input;
	}

}
