package chapter7.point38;

public class FlatterClient {

	public static void main(String[] args) {

		FlatterMan fman = new GoodFlatterMan(); // パラメータ検査ができてる奴
		// FlatterMan fman = new BadFlatterMan(); //パラメータ検査が甘い奴

		// まず普通の挙動
		fman.flatter("なーが");
		fman.flatter("丸山");

		System.out.println("--------ヌルポ対策できてる？---------");
		checkNullProtection(fman);

//		System.out.println("-------不正な数値を渡されてもだいじょうぶ？-------");
//		checkInvalidNumberProtection(fman);

		System.out.println("-------オブジェクトの状態が不正になるのを防止しよう-------");
		checkInvalidFieldProtection();
	}

	private static void checkNullProtection(FlatterMan fman) {
		fman.flatter(null);
	}

	private static void checkInvalidNumberProtection(FlatterMan fman) {
		// 3回繰り返し
		fman.multipleFlatter("丸山", 3);

		// -1を渡してみる
		fman.multipleFlatter("丸山", -1);
	}

	private static void checkInvalidFieldProtection() {
		// 正常に初期化されて実行できる
		// FlatterMan fmanTanakiyo = new GoodFlatterMan("たなきよ");
		FlatterMan fmanTanakiyo = new BadFlatterMan("たなきよ");
		fmanTanakiyo.flatter();

		// 初期化時にnullを渡されたらどうなる
		FlatterMan fmanNull = new GoodFlatterMan(null);
		// FlatterMan fmanNull = new BadFlatterMan(null);
		fmanNull.flatter();
	}
}
