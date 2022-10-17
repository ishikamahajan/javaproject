package ds.sorter;

import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
        boolean isTrueOrFalse = false;
        int mostSmallest = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(j).compareTo(input.get(i)) < 0) {
                    mostSmallest = j;
                    isTrueOrFalse = true;
                }
            }

            if (isTrueOrFalse) {
                E temp = input.get(i);
                input.set(i, input.get(mostSmallest));
                input.set(mostSmallest, temp);

                isTrueOrFalse = false;
            }
        }
		return input;
   	}

}
