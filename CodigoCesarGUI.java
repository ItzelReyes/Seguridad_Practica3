import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class CodigoCesarGUI extends JFrame{
    private JLabel lblTexto, lblDecodificado, lblClave,lblCodificado;
    private JTextField txtTexto, txtDecodificado,txtClave,txtCodificado;
    private JButton bttnDecodificar, bttnCodificar;
    private JPanel pDatos, pD;

    public static void main(String[] args){
        CodigoCesarGUI ccgui;
        ccgui = new CodigoCesarGUI();
        ccgui.setVisible(true);
    }

    public CodigoCesarGUI(){
        inicializarComponentes();
    }

    private void inicializarComponentes(){
        setSize(550,550);
        setTitle("Nombre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(5,2, 10, 20);

        pDatos = new JPanel(layout);

        add(pDatos);

        lblTexto = new JLabel("Entrada:  ");
        pDatos.add(lblTexto);
        txtTexto = new JTextField();
        pDatos.add(txtTexto);
        lblClave = new JLabel("Clave: ");
        pDatos.add(lblClave);
        txtClave = new JTextField();
        pDatos.add(txtClave);
        lblCodificado = new JLabel("Texto Codificado: ");
        pDatos.add(lblCodificado);
        txtCodificado = new JTextField();
        pDatos.add(txtCodificado);
        lblDecodificado = new JLabel("Texto Decodificado: ");
        pDatos.add(lblDecodificado);
        txtDecodificado = new JTextField();
        pDatos.add(txtDecodificado);


        //pDatos.add(new JLabel(""));
        //pDatos.add(new JLabel(""));
        //lblDecodificado = new JLabel("...");
        //pDatos.add(lblDecodificado);

		bttnCodificar = new JButton("Codificar");
        bttnDecodificar = new JButton("Decodificar");

        bttnCodificar.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent evt){
			CodigoCesar cc = new CodigoCesar();
			String codificado = cc.codificar(txtTexto.getText(),5);
			String msg = cc.decodificar(codificado,5);
            txtCodificado.setText(codificado);
            }
        });

        bttnDecodificar.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent evt){
			CodigoCesar cc = new CodigoCesar();
			String codificado = cc.codificar(txtTexto.getText(),5);
			String msg = cc.decodificar(codificado,5);
            txtDecodificado.setText(msg);
            }
        });
        pDatos.add(bttnCodificar);
        pDatos.add(bttnDecodificar);
    }
}

