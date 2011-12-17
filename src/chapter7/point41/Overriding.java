package chapter7.point41;

public class Overriding {
	public static void main(String[] args) {
		Wine[] wines = { new Wine(), new SparklingWine(), new Champagne() };
		for(Wine wine : wines) {
			System.out.println(wine.name());
		}
	}
}

class Wine {
	String name() { return "wine"; }
}

class SparklingWine extends Wine {
	@Override String name() { return "sparkling wine"; }
}

class Champagne extends SparklingWine {
	@Override String name() { return "champagne"; }
}
