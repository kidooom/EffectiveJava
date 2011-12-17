package chapter7.point39;

import java.util.Date;

public class PeriodClient {
	public static void main(String[] args) {

		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		end.setYear(78); // pの内部を破壊する！！！
	}
}
