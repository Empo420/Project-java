package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class PanelEmpleado extends JPanel 
{

	// ----------------------------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------------------------

	
	private InterfazEmpresa principal;
	
	private PanelNavegacion panelNavegacion;
	
	private JLabel labImagen;
	
	
	private JLabel labNombre;
	private JLabel labValorNombre;
	
	
	private JLabel labCedula;
	private JLabel labValorCedula;
	
	
	private JLabel labGenero;
	private JLabel labValorGenero;
	
	
	private JLabel labTipo;
	private JLabel labValorTipo;
	
	
	private JLabel labSalarioBase;
	private JLabel labValorSalarioBase;
	
	
	private JLabel labAuxilioTransporte;
	private JLabel labValorAuxilioTransporte;
	
	
	private JLabel labPagoSalud;
	private JLabel labValorPagoSalud;
	
	
	private JLabel labPagoPension;
	private JLabel labValorPagoPension;
	
	
	private JLabel labPagoFondo;
	private JLabel labValorPagoFondo;
	
	
	private JLabel labSalarioNeto;
	private JLabel labValorSalarioNeto;
	
	
	private JButton butPrimero;
	
	private JButton butSiguiente;
	
	private JButton butAnterior;
	
	private JButton butUltimo;
	
	
	// ----------------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------------
	public PanelEmpleado(InterfazEmpresa pPrincipal)
	{
		
		
		TitledBorder borde = new TitledBorder( "Datos del Empleado" );	
		setBorder( borde );
		
		// Establecer el distribuidor grafico del panel
		setLayout( new BorderLayout( ) );
		
		// Zona izquierda del panel
		labImagen = new JLabel( );
		labImagen.setBorder( new EmptyBorder( 0, 50 , 40, 80 ) );
		
		Image imagen = new ImageIcon( "./data/imagen" ).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT );
		Icon icono = new ImageIcon( imagen );
		labImagen.setIcon( icono );
		add( labImagen, BorderLayout.WEST );
		
		// Zona derecha del panel
		
		labNombre  = new JLabel( "Nombre" );
		labValorNombre = new JLabel( "" );
		
		labCedula = new JLabel( "Cedula" );
		labValorCedula = new JLabel( "" );
		
		labGenero = new JLabel( "Genero" );
		labValorGenero = new JLabel( "" );
		
		labTipo  = new JLabel( "Tipo" );
		labValorTipo = new JLabel( "" );
		
		labSalarioBase  = new JLabel( "Salario Base" );
		labValorSalarioBase = new JLabel( "" );
		
		labAuxilioTransporte = new JLabel( "Auxilio Transporte" );
		labValorAuxilioTransporte = new JLabel( "" );
		
		labPagoSalud = new JLabel( "Pago Salud" );
		labValorPagoSalud = new JLabel( "" );
		
		labPagoPension  = new JLabel( "Pago Pension " );
		labValorPagoPension = new JLabel( "" );
		
		labPagoFondo = new JLabel( "Pago Fondo" );
		labValorPagoFondo = new JLabel( "" );
		
		labSalarioNeto = new JLabel( "Salario Neto" );
		labValorSalarioNeto = new JLabel( "" );
		
		
		
		
		JPanel panelDerecha = new JPanel( );
		panelDerecha.setBorder( new EmptyBorder( 0, 0 , 0, 40 ));
		panelDerecha.setLayout( new GridLayout( 10, 2 ) );
		panelDerecha.add( labNombre );
		panelDerecha.add( labValorNombre );
		panelDerecha.add( labCedula );
		panelDerecha.add( labValorCedula );
		panelDerecha.add( labGenero );
		panelDerecha.add( labValorGenero );
		panelDerecha.add( labTipo );
		panelDerecha.add( labValorTipo );
		panelDerecha.add( labSalarioBase );
		panelDerecha.add( labValorSalarioBase );
		panelDerecha.add( labAuxilioTransporte );
		panelDerecha.add( labValorAuxilioTransporte );
		panelDerecha.add( labPagoSalud );
		panelDerecha.add( labValorPagoSalud);
		panelDerecha.add( labPagoPension );
		panelDerecha.add( labValorPagoPension );
		panelDerecha.add( labPagoFondo );
		panelDerecha.add( labValorPagoFondo );
		panelDerecha.add( labSalarioNeto);
		panelDerecha.add( labValorSalarioNeto );
		
		
		add( panelDerecha, BorderLayout.CENTER );
		
		// Zona sur del panel
		
		panelNavegacion = new PanelNavegacion( pPrincipal);
		add( panelNavegacion, BorderLayout.SOUTH );
		
	}
	
	
	// ----------------------------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------------------------
	public void actualizar( String nombreP, int cedulaP,  String generoP,String tipoP,double salarioP,
			double AuxiloP, double saludP,double pensionP, 
			     double fondoP,  double netoP, String pRutaImagen)
	{
		

		labValorNombre.setText( nombreP);
		
		DecimalFormat ds = new DecimalFormat("$ ##,###");
		DecimalFormat df = new DecimalFormat("$ ###,###");
		DecimalFormat cd = new DecimalFormat("######");
		labValorCedula.setText( cd.format( cedulaP ));
		
		labValorGenero.setText( generoP); 
		
		labValorTipo.setText( tipoP); 
		
		labValorSalarioBase.setText( df.format(salarioP));
		
		labValorAuxilioTransporte.setText( df.format(AuxiloP));
		
		
		labValorPagoSalud.setText( ds.format(saludP));; 
		
		labValorPagoPension.setText( ds.format(pensionP));
		
		labValorPagoFondo.setText( df.format(fondoP)); 
		
		labValorSalarioNeto.setText( df.format(netoP));

		
		
		Image imagen = new ImageIcon( "./data/imagen/" + pRutaImagen ).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT );
		Icon icono = new ImageIcon( imagen );
		labImagen.setIcon( icono );
	}



	
	
	
	
	
	
	
	
	
	
}
