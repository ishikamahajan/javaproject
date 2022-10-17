package ds.fruit;

public class Fruit implements Comparable<Fruit> {

	public enum TYPE {
		APPLE, PEAR, BANANA, GRAPE
	}

	private TYPE type;
	private double weight;
	private double ripeness;

	public Fruit(TYPE type, double weight, double ripeness)
			throws InvalidFruitWeightException, InvalidFruitRipenessException {
		// TODO Auto-generated constructor stub
		if (weight <= 0)
			throw new InvalidFruitWeightException();
		else if (!(ripeness >= 0 && ripeness <= 1))
			throw new InvalidFruitRipenessException();
		else {
			this.type = type;
			this.weight = weight;
			this.ripeness = ripeness;
		}
	}

	public TYPE getType() {
		return type;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getRipeness() {
		return ripeness;
	}

	@Override
	public int compareTo(Fruit o) {
		TYPE otype = o.getType();

		if (type == otype || ((type == Fruit.TYPE.APPLE) && (otype == Fruit.TYPE.GRAPE))
				|| ((type == Fruit.TYPE.GRAPE) && (otype == Fruit.TYPE.APPLE))) {
			if (Math.abs(weight - o.getWeight()) <= 0.05) {
				if (ripeness > o.getRipeness())
					return 1;
				return 0;
			}

			else {
				if (weight > o.getWeight())
					return 1;
				return 0;
			}
		}

		if (type == Fruit.TYPE.PEAR)
			return 1;
		else if (type == Fruit.TYPE.GRAPE || type == Fruit.TYPE.APPLE)
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Fruit: " + getType().toString() + ", " + getWeight().toString() + ", " + getRipeness().toString();
	}

}
