public class CodigoCesar {
	public String codificar(String mensaje, int corrimiento, String clave) {
		String codigo = "";
		char letra = '\0';
		char letraC = '\0';
		String []arrayBin = new String [100];
		//String clave = "";
		String []arrayBinC = new String [100];
		//int []xor = new int [100];


		mensaje = mensaje.toLowerCase();

		for (int i=0; i<mensaje.length(); i++) {
			letra = mensaje.charAt(i);
			arrayBin[i] = Integer.toBinaryString(letra);

			if (letra == ' ')
				codigo += ' ';

			else if (letra+corrimiento > 'z') {
				codigo += (char)((letra+corrimiento-'a') % ('z'-'a') + 'a'-1);
			}
			else
				codigo += (char)(letra+corrimiento);

		}

		for (int j=0; j<clave.length(); j++) {
			letraC = clave.charAt(j);
			arrayBinC[j] = Integer.toBinaryString(letraC);
		}
/*
		for (int k=0; k<100; k++) {
			xor[k] = arrayBin[k] ^ arrayBinC[k];
		}
*/
		return codigo + " " + arrayBin[0] + " " + arrayBinC[0];
	}
	public String decodificar(String codigo, int corrimiento) {
		String mensaje = "";
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

		return mensaje;
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
}