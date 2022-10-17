package ds.sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		List<E> l = new ArrayList<>();
		List<E> r = new ArrayList<>();
		int c;
		if (input.size() == 1) {
			return input;
		} else {
			c = input.size() / 2;
			for (int i = 0; i < c; i++) {
				l.add(input.get(i));
			}
			for (int i = c; i < input.size(); i++) {
				r.add(input.get(i));
			}
			l = sort(l);
			r = sort(r);
			merge(l, r, input);
		}
		return input;
	}

	void merge(List<E> left, List<E> right, List<E> original) {
		int lIndex = 0;
		int rIndex = 0;
		int mainIndex = 0;

		while (lIndex < left.size() && rIndex < right.size()) {

			if (left.get(lIndex).compareTo(right.get(rIndex)) < 0) {
				original.set(mainIndex, left.get(lIndex));
				lIndex++;
			} else {
				original.set(mainIndex, right.get(rIndex));
				rIndex++;
			}
			mainIndex++;
		}

		while (lIndex < left.size()) {
			original.set(mainIndex, left.get(lIndex));
			mainIndex++;
			lIndex++;
		}
		while (rIndex < right.size()) {
			original.set(mainIndex, right.get(rIndex));
			mainIndex++;
			rIndex++;
		}
	}
}
