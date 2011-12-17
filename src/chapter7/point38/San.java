package chapter7.point38;

public enum San {
	YAMA_KANJI("山"), 
	YAMA_HIRAGANA("やま"), 
	YAMA_KATAKANA("ヤマ"), 
	YAMA_ALPHA("yama");
	
	private final String watchWord;

	San(String word) {
		this.watchWord = word;
	}

	@Override
	public String toString() {
		return watchWord;
	}
}
