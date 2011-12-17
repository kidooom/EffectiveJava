package chapter7.point38;

public class GoodFlatterMan implements FlatterMan {

	private final String defaultTarget;
	private final String afterMaru = "○";
	private final String afterSan = "凸";
	private final String sanKakkee = "△";

	public GoodFlatterMan() {
		defaultTarget = "";
	}

	/**
	 * 褒める相手をオブジェクトに保持するためのコンストラクタ
	 * 
	 * @param name nullであってはいけない
	 * @throws IllegalArgumentException nameがnullの場合
	 */
	public GoodFlatterMan(String name) {
		if (name == null) {
			// パラメータの制約違反しているので速やかに終わらせる。
			throw new IllegalArgumentException(
					"default name must not be null!");
		} else {
			defaultTarget = name;
		}
	}

	@Override
	public void flatter() {
		System.out.println(defaultTarget + sanKakkee);
	}

	@Override
	public void flatter(String name) {
		if (isContainMarusan(name)) {
			System.out.println(translateMarusan(name) + sanKakkee);
		} else {
			System.out.println(name + sanKakkee);
		}
	}

	
	/**
	 * 指定回数褒める
	 * 
	 * @param name 褒める相手
	 * @param repeatCount 褒める回数。正の数でなければならない
	 * @throws IllegalArgumentException repeatCountの正の数でない場合
	 */
	@Override
	public void multipleFlatter(String name, int repeatCount) {
		if (repeatCount <= 0) {
			// パラメータの制約違反しているので速やかに終わらせる。
			throw new IllegalArgumentException(
					"repeatCount must be positive number!");
		}

		System.out.println(repeatCount + "回褒めます");
		for (int i = 0; i < repeatCount; i++) {
			flatter(name);
		}
	}

	/**
	 * Marusanらしき単語が含まれるか否かを返す
	 * 
	 * @param name
	 * @return 含まれる場合はtrue, 含まれない場合やnameがnullの場合はfalse
	 */
	private boolean isContainMarusan(String name) {
		assert name != null;
		if (name == null) {
			// パラメータの制約違反しているので速やかに終わらせる。
			return false;
		}

		for (Maru maru : Maru.values()) {
			if (name.contains(maru.toString())) {
				return true;
			}
		}
		for (San san : San.values()) {
			if (name.contains(san.toString())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Marusanらしき単語を変換
	 * 
	 * @param name
	 * @return 変換後の文字列。nameがnullの場合は空文字を返す。
	 */
	private String translateMarusan(String name) {
		assert name != null;
		if (name == null) {
			// パラメータの制約違反しているので速やかに終わらせる。例外を投げてもOK
			return "";
		}
		
		String afterName = name;
		for (Maru maru : Maru.values()) {
			afterName = afterName.replace(maru.toString(), afterMaru);
		}

		for (San san : San.values()) {
			afterName = afterName.replace(san.toString(), afterSan);
		}

		return afterName;
	}
}
