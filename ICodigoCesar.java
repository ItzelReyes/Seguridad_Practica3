public interface ICodigoCesar {
	String codificar(String mensaje, int corrimiento);
	String decodificar(String codigo, int corrimiento);
	int buscarCorrimiento(String texto);
}