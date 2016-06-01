package util;


import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String str = "r 84120001,1,5000300D,1,10100,处理成功";
		String ret = null;
		ret = new BASE64Encoder().encode(str.getBytes());
		System.out.println("加密前:"+str+" 加密后:"+ret);
		str = "ciA4NDEyMDAwMSwxLDUwMDAzMDBELDEsMTAxMDAstKbA7bPJuaY=";
		try {
			ret = new String(new BASE64Decoder().decodeBuffer(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println("解密前:"+str+" 解密后:"+ret);

	}

}
