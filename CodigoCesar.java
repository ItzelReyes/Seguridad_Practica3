public class CodigoCesar {
	public String codificar(String mensaje, int corrimiento) {
		String codigo = "";
		int ascii = 0;
		int []arrayBin = new int [100];

		mensaje = mensaje.toLowerCase();

		for (int i=0; i<mensaje.length(); i++) {
			char letra = mensaje.charAt(i);
			if (letra == ' ')
				codigo += ' ';

			else if (letra+corrimiento > 'z') {
				codigo += (char)((letra+corrimiento-'a') % ('z'-'a') + 'a'-1);
			}
			else
				codigo += (char)(letra+corrimiento);
			
			ascii = (int)(letra);

			for (int i=0; int < 100; i++) {
				arrayBin[i] = Integer.toBinaryString(ascii);
			}
		}

		return codigo + " " + ascii;
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