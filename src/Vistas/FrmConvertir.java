package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmConvertir extends JFrame {

	private JPanel contentPane;
	private JTextField txtImporte;
	private JTextArea taResultado;
	private JTextField txtResultado2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConvertir frame = new FrmConvertir();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConvertir() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Aplicación de conversión de moneda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitulo = new JLabel("Convetir monedas");
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTitulo.setBounds(78, 11, 134, 24);
		contentPane.add(lbTitulo);
		
		JLabel lbSeleccion = new JLabel("Seleccione la conversión:");
		lbSeleccion.setBounds(10, 46, 148, 14);
		contentPane.add(lbSeleccion);
		
		final JComboBox cbMoneda = new JComboBox();
		cbMoneda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione la moneda a convertir", "De Peso $ a Dolar USD", "De Peso $ a Euro €", "De Peso a Libras £", "De Peso a Yen ¥", "De Peso a Won Coreano ₩", "De Dolar USD a Peso $", "De Euro € a Dolar USD", "De Libras £ a Pesos $"}));
		cbMoneda.setBounds(168, 46, 256, 22);
		contentPane.add(cbMoneda);
		
		JLabel lbImporte = new JLabel("Importe a convertir:");
		lbImporte.setBounds(35, 84, 110, 14);
		contentPane.add(lbImporte);
		
		txtImporte = new JTextField();
		txtImporte.addKeyListener(new KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				int tablero = evt.getKeyChar();
				boolean numero = tablero >= 48 && tablero <= 57;
				if(!numero) {
					evt.consume();
				}
				
			}
		});
		txtImporte.setBounds(168, 81, 212, 20);
		contentPane.add(txtImporte);
		txtImporte.setColumns(10);
		
		//taResultado = new 
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel modelo = new DefaultComboBoxModel();
				//this.setLocationReltiveTo(null);
				String seleccion = cbMoneda.getSelectedItem().toString();
				int indice = cbMoneda.getSelectedIndex();
				double valor = Double.parseDouble(txtImporte.getText());
				
				switch(indice) {
				   case 0:
					   JOptionPane.showMessageDialog(rootPane, "Ud No ha hecho una seleccion correspondiente ");	
					   txtImporte.setText("");
						cbMoneda.setSelectedIndex(0);
						txtResultado2.setText("");
				   break;
				   
				   case 1:
					   //de peso a dolar 
					   double rto1 = Math. floor(valor * 0.0049);
					   
					   txtResultado2.setText(rto1 + "");  //de esta forma se convierte un double a string
					   
				   break;
				   
				   case 2:
					   //de peso a euro
					   double rto2 = Math. floor(valor * 0.0045);
					   System.out.println("Ud selecciono la opcion   " + seleccion + indice);
					   txtResultado2.setText(rto2 + "");
				   break;
				   
				   case 3:
					   //Instrucciones de peso a libra
					   double rto3 = Math. floor(valor * 0.0040);
					   txtResultado2.setText(rto3 + "");
				   break;
				   
				   case 4:
					   //Instrucciones de peso a yen
					   double rto4 = Math. floor(valor * 0.64);
					   txtResultado2.setText(rto4 + "");
					   
				   break;
				   
				   case 5:
					   //Instrucciones de peso a won
					   double rto5 = Math. floor(valor * 6.31);
					   txtResultado2.setText(rto5 + "");
					   
				   break;
				   
				   case 6:
					   //Instrucciones de dolar a peso
					   double rto6 = Math. floor(valor * 205.26);
					   txtResultado2.setText(rto6 + "");
					   
				   break;
				   
				   case 7:
					   //Instrucciones de euro a dolar
					   double rto7 = Math. floor(valor * 1.08);
					   txtResultado2.setText(rto7 + "");
					   
				   break;
				   
				   case 8:
					   //Instrucciones de libras a pesos
					   double rto8 = Math. floor(valor * 250.97);
					   txtResultado2.setText(rto8 + "");
					   
				   break;
				}
				
				JOptionPane.showMessageDialog(rootPane, "Ud selecciono " + seleccion);
				
				
			}
		});
		btnConvertir.setBounds(168, 112, 113, 23);
		contentPane.add(btnConvertir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtImporte.setText("");
				//this.taResulado.setText("");
				cbMoneda.setSelectedIndex(0);
				txtResultado2.setText("");
			}
		});
		btnCancelar.setBounds(291, 112, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lbResultado = new JLabel("Resultado de conversión");
		lbResultado.setBounds(168, 146, 166, 14);
		contentPane.add(lbResultado);
		
		txtResultado2 = new JTextField();
		txtResultado2.setEditable(false);
		txtResultado2.setBounds(167, 171, 213, 20);
		contentPane.add(txtResultado2);
		txtResultado2.setColumns(10);
	}
}
