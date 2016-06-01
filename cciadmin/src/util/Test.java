package util;

public class Test {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	// ASCII作为数组下标
	final public static String AISCODE = "0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVW`abcdefghijklmnopqrstuvw";
	final public static int AISDECODE[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0,
			// ! " # $ % & ' ( ) * + , - . /
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			// 0 1 2 3 4 5 6 7 8 9 : ; < = > ?
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			// @ A B C D E F G H I J K L M N O
			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
			// P Q R S T U V W X Y Z [ \ ] ^ _
			32, 33, 34, 35, 36, 37, 38, 39, 0, 0, 0, 0, 0, 0, 0, 0,
			// ` a b c d e f g h i j k l m n o
			40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,
			// p q r s t u v w x y z { | } ~
			56, 57, 58, 59, 60, 61, 62, 63, 0, 0, 0, 0, 0, 0, 0, 0 };
	final public static int STRINGDECODE[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0,
			// ! " # $ % & ' ( ) * + , - . /
			32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
			// 0 1 2 3 4 5 6 7 8 9 : ; < = > ?
			48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
			// @ A B C D E F G H I J K L M N O
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			// P Q R S T U V W X Y Z [ \ ] ^ _
			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
			// ` a b c d e f g h i j k l m n o
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			// p q r s t u v w x y z { | } ~
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		String data = "?";
		int index = 0;
		System.out.println(String2BinaryText(data, 6));
		System.out.println(AISCODE.charAt(Integer.parseInt("111111", 2)));
	}
	public static String String2BinaryText(String data, int length) {
		StringBuffer resBuf = new StringBuffer();
		String temp;
		for (int i = 0; i < data.length(); i++) {
			temp = Integer.toString(STRINGDECODE[data.charAt(i) & 0x07f], 2);
			if (temp.length() > length) {
				temp = temp.substring(0, length);
			} else {
				for (int j = temp.length(); j < length; j++) {
					resBuf.append("0");
				}
			}
			resBuf.append(temp);
		}
		return resBuf.substring(0, resBuf.length());
	}
}
