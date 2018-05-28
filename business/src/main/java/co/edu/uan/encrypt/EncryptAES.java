package co.edu.uan.encrypt;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptAES {
	
	// Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
	private final static String alg = "AES";
	// Definición del modo de cifrado a utilizar
	private final static String cI = "AES/CBC/PKCS5Padding";
	// Definicón de la llave
	private final static String key = "92AE31A79FEEB2A3";
	// Definición vector de inicialización
	private final static String iv = "0123456789ABCDEF";
		
	public String encriptar(String texto) {
		// TODO Auto-generated method stub
		String resultado = "";
		try {
			Cipher cipher = Cipher.getInstance(cI);
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
			byte[] encrypted = cipher.doFinal(texto.getBytes());
			resultado = new String(Base64.encodeBase64(encrypted));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public String desencriptar(String texto) {
		// TODO Auto-generated method stub
		String resultado = "";
		try {
			Cipher cipher = Cipher.getInstance(cI);
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			byte[] enc = Base64.decodeBase64(texto);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
			byte[] decrypted = cipher.doFinal(enc);
			resultado = new String(decrypted);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

}
