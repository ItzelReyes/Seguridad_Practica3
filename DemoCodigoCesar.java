import java.util.Scanner;
import java.io.*;

public class DemoCodigoCesar {
	public static void main(String[] args) throws Exception {
		File f = new File("mensajeOculto.txt");
		Scanner sc = new Scanner(f);
		String texto = "";
		while (sc.hasNextLine()) {
			texto += sc.nextLine() + " ";
		}
		CodigoCesar cc = new CodigoCesar();

		System.out.println(texto);
		String codigo = cc.codificar(texto, 5);
		System.out.println(codigo);

		String msg = cc.decodificar(codigo, 13);
		System.out.println(msg);

	}
}