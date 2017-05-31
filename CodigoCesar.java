public class CodigoCesar {
		String encrypt1 = "";
		String decrypt1 = "";

	public String codificar(String mensaje, int corrimiento, String clave) {
		String codigo = "";
		String result1 = "";
		String result2 = "";
		char codigoC = '\0';
		char letra = '\0';
		char letraC = '\0';
		String bini = "";
		String biniC = "";
		int key = clave.length();
		int []shift = new int [100];
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

		mensaje = mensaje.toLowerCase();

		encrypt1 = encrypt(2,mensaje);

		for (int i=0; i<encrypt1.length(); i++) {

			letra = encrypt1.charAt(i);

			if (letra == ' ')
				codigo += ' ';

			else if (letra+corrimiento > 'z') {
				codigo += (char)((letra+corrimiento-'a') % ('z'-'a') + 'a'-1);
			}
			else
				codigo += (char)(letra+corrimiento);

			codigoC = codigo.charAt(i); 
			bini = Integer.toBinaryString(codigoC);
			sb.append(bini);
			result1 = sb.toString();
		}

		for (int j=0; j<clave.length(); j++) {
			letraC = clave.charAt(j);
			biniC = Integer.toBinaryString(letraC);

			sb2.append(biniC);
			result2 = sb2.toString();
		}

		for (int k=0; k<result1.length(); k++) {
			sb3.append((result1.charAt(k) ^ result2.charAt(k)));
		}

			String str = sb3.toString();

		return encrypt1 + " " + codigo + " " + str;
	}

	public String decodificar(String codigo, int corrimiento) {
		String mensaje = "";

		decrypt1 = decrypt(2,encrypt1);

		codigo = codigo.toLowerCase();

		for (int i=0; i<codigo.length(); i++) {
			char letra = codigo.charAt(i);
			if (letra == ' ') {
				mensaje += ' ';
			}
			else if (letra-corrimiento < 'a') {
				mensaje += (char)(letra-'a'-corrimiento+'z'+1);
			}
			else {
				mensaje += (char)(letra-corrimiento);
			}
		}

		return decrypt1;
	}

	public int buscarCorrimiento(String texto) {
		int[] letras = new int['z'-'a'+1];
		for (int i=0; i<texto.length(); i++) {
			char letra = texto.charAt(i);
			if (letra != ' ') {
				letras[letra - 'a']++;
			}
		}
		int mayor = 0;
		int mayorIndice = 0;
		for (int i=0; i<letras.length; i++) {
			if (letras[i] > mayor) {
				mayor = letras[i];
				mayorIndice = i;
			}
		}

		return mayorIndice;
	}

	public static String encrypt(int key, String plainT){
     char[] res = new char[plainT.length()];
     int k = 0;

     for (int j = 0; j < key; j++) {
        for (int i = j; i < plainT.length(); i += key) {
            res[k++] = plainT.charAt(i);
        }
    }

    return String.copyValueOf(res);
	}

	public static String decrypt(int key, String encT){
     char[] res = new char[encT.length()];
     int k = 0;

     for (int j = 0; j < key; j++) {
        for (int i = j; i < encT.length(); i += key) {
            res[i] = encT.charAt(k++);
        }
    }

    return String.copyValueOf(res);
	}
}