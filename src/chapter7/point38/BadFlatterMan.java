package chapter7.point38;

public class BadFlatterMan implements FlatterMan {

	private final String defaultTarget;
	private final String afterMaru = "○";
	private final String afterSan = "凸";
	private final String sanKakkee = "△";

	public BadFlatterMan() {
		defaultTarget = "";
	}

	public BadFlatterMan(String name) {
		// パラメータ検査が甘い
		defaultTarget = name;
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

	@Override
	public void multipleFlatter(String name, int repeatCount) {
		// パラメータ検査が甘い
		System.out.println(repeatCount + "回褒めます");
		for (int i = 0; i < repeatCount; i++) {
			flatter(name);
		}
	}

	private boolean isContainMarusan(String name) {
		// パラメータ検査が甘い
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

	private String translateMarusan(String name) {

		// パラメータ検査が甘い
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
