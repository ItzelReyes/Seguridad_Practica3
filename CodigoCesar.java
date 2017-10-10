import java.math.BigInteger;

public class CodigoCesar {
		String str = "";
		String str2 = "";
		String encrypt1 = "";
		String decrypt1 = "";
		String result1 = "";
		String result2 = "";
		char []claveA = new char[100];
		String miniClave = "";
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		String reverse = "";

	public String codificar(String mensaje, int corrimiento, String clave) {
		String codigo = "";
		char codigoC = '\0';
		char letra = '\0';
		char letraC = '\0';
		String bini = "";
		String biniC = "";
		int key = clave.length();
		String claveB = clave;
		String claveC = clave;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

		while(claveC.length()<mensaje.length()){
			claveC += claveB;
		}

		mensaje = mensaje.toLowerCase();

		encrypt1 = encrypt(2,mensaje);

		for (int i=0; i<encrypt1.length(); i++) {

			letra = encrypt1.charAt(i);

			if (letra == ' '){
				codigo += '@';
			}

			else if (letra+corrimiento > 'z') {
				codigo += (char)((letra+corrimiento-'a') % ('z'-'a') + 'a'-1);
			}
			else
				codigo += (char)(letra+corrimiento);

			StringBuilder builder = new StringBuilder(codigo);
			reverse = builder.reverse().toString();
			System.out.println("SOy reverse: " + reverse);

			codigoC = codigo.charAt(i); 
			bini = Integer.toBinaryString(codigoC);
			sb.append(bini);
			result1 = sb.toString();
		}

		for (int j=0; j<claveC.length(); j++) {
			letraC = claveC.charAt(j);
			biniC = Integer.toBinaryString(letraC);

			sb2.append(biniC);
			result2 = sb2.toString();
		}

		for (int k=0; k<result1.length(); k++) {
			sb3.append((result1.charAt(k) ^ result2.charAt(k)));
		}

		str = sb3.toString();


		int b;
		String s3 = " ";
		//String s4 = "";

		for (int m = 0; m < str.length()/7; m++) {
        	b = Integer.parseInt(str.substring(7*m,(m+1)*7),2)+90;
        	System.out.println(str);
        	s3 += (char)(b);
    	}

		return encrypt1 + " " + s3;
	}

	public String decodificar(String codigo, int corrimiento) {

		int a;
		String s2 = "";

		for (int k=0; k<result1.length(); k++) {
			sb4.append((str.charAt(k) ^ result2.charAt(k)));
		}

		str2 = sb4.toString();

		for (int i = 0; i < str2.length()/7; i++) {

        	a = Integer.parseInt(str2.substring(7*i,(i+1)*7),2);
        	s2 += (char)(a);
    	}

		StringBuilder builder2 = new StringBuilder(reverse);
		String reverse2 = builder2.reverse().toString();
		System.out.println("SOy reverse2: " + reverse2);

		String mensaje = "";

		for (int i=0; i<s2.length(); i++) {
			char letra = s2.charAt(i);
			if (letra == '@') {
				mensaje += ' ';
			}
			else if (letra-corrimiento < 'a') {
				mensaje += (char)(letra-'a'-corrimiento+'z'+1);
			}
			else {
				mensaje += (char)(letra-corrimiento);
			}
		}

		decrypt1 = decrypt(2,mensaje);

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