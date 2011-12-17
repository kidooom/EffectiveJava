package chapter7.point39;

import java.util.Date;

public final class Period {
	private final Date start;
	private final Date end;

	/**
	 * 脆弱性のあるコンストラクタ
	 * 
	 * @param start
	 * @param end
	 * @throws IllegalArgumentException startがendの後の場合
	 * @throws NullPointerExcepton startがnullの場合
	 */
//	public Period(Date start, Date end) {
//		if (start.compareTo(end) > 0) {
//			throw new IllegalArgumentException(start + " after " + end);
//		}
//		this.start = start;
//		this.end = end;
//	}


	/**
	 * 防御的コピーにより脆弱性を解消したコンストラクタ
	 * 
	 * @param start
	 * @param end
	 * @throws IllegalArgumentException startがendの後の場合
	 * @throws NullPointerExcepton startがnullの場合
	 */
	public Period(Date start, Date end) {
		// TICTOU攻撃対策 先にコピーしてから制約チェック
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if (start.compareTo(end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}
	
	/**
	 * 脆弱性のあるアクセッサ
	 */
//	public Date start() {
//		return start;
//	}

	/**
	 * 防御的コピーにより脆弱性を解消したアクセッサ
	 */
	public Date start() {
		return new Date(start.getTime());
	}
	
	/**
	 * 脆弱性のあるアクセッサ
	 */
//	public Date end() {
//		return end;
//	}

	/**
	 * 防御的コピーにより脆弱性を解消したアクセッサ
	 */
	public Date end() {
		return new Date(end.getTime());
	}
}
