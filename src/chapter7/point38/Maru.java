package chapter7.point38;

public enum Maru {
	MARU_KANJI("丸"), 
	MARU_HIRAGANA("まる"), 
	MARU_KATAKANA("マル"), 
	MARU_ALPHA("maru");

	private final String watchWord;

	Maru(String word) {
		this.watchWord = word;
	}

	@Override
	public String toString() {
		return watchWord;
	}
}
