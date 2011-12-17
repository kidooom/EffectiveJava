package chapter7.point42;

public class Dalsim {

	// Simply use
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}

	// bad using
	static int min(int... args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("Too few arguments");
		}
		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i] < min) {
				min = args[i];
			}
		}
		return min;
	}

	// good using
	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs) {
			if (arg < min) {
				min = arg;
			}
		}
		return min;
	}

	// 可変長引数メソッドを１つだけ用意した場合
	public void variableArgument(int... i) { }
	
	// よく使われるパターンに関しては固定長引数のメソッドを用意した場合
	public void fixArgument(int x) { }
	public void fixArgument(int x, int y) { }
	public void fixArgument(int x, int y, int z) { }
	public void fixArgument(int x, int y, int z, int... i) { }

	public static void main(String[] args) {
		Dalsim yoga = new Dalsim();
		long startTime, endTime;
		int c = Integer.MAX_VALUE;
		// int c = 100000;
		
		startTime = System.nanoTime();
		for(int i=0; i< c; i++)
			yoga.fixArgument(1, 2, 3,4);
		endTime = System.nanoTime();
		System.out.println("固定長引数を " + c + "回呼び出した場合 : " + (endTime - startTime)/1000000 + "ms");
				
		startTime = System.nanoTime();
		for(int i=0; i< c; i++)
			yoga.variableArgument(4, 5, 6, 7);
		endTime = System.nanoTime();
		System.out.println("可変長引数を " + c + "回呼び出した場合 : " + (endTime - startTime)/1000000 + "ms");
		
	}
	
}
