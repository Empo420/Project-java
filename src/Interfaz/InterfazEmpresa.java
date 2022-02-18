package Interfaz;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;
import mundo.*;





public class InterfazEmpresa extends JFrame
{
	
	// ----------------------------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------------------------
	
	private PanelEmpleado panelEmpleado;
	
	private PanelOpciones panelOpciones;
	
	private PanelNavegacion panelNavegacion;
	
	private Empresa buscar;
	
	
	
	// ----------------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------------
	public InterfazEmpresa() throws Exception
	{
		
		try {
			File archivo = new File("./data/empleados.data");
			Empresa empresa = new Empresa(archivo);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Empleados no cargados", JOptionPane.INFORMATION_MESSAGE);
			
		}

		
		
		setSize( 800, 700 );
		setTitle( "Gestion empleados" );
		setResizable( false );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		// Creacion de los paneles
		
		panelEmpleado = new PanelEmpleado( this );
	
		panelOpciones = new PanelOpciones( this );
		
		
		// Distribucion de los paneles en la ventana
		setLayout( new BorderLayout( ) );
		
		// Panel Norte de la ventana
		JLabel labImagen = new JLabel( );
		labImagen.setIcon( new ImageIcon( "./data/logo.jpg" ) );
		add( labImagen, BorderLayout.NORTH );
		
		// Panel Centro de la ventana
		JPanel panelCentro = new JPanel( );
		add( panelCentro, BorderLayout.CENTER );
		
		panelCentro.setLayout( new BorderLayout( ) );
		panelCentro.add( panelEmpleado, BorderLayout.CENTER );
		
		
		// Panel Sur de la ventana
		JPanel panelSur = new JPanel( );
		add( panelSur, BorderLayout.SOUTH );
		
		panelSur.setLayout( new BorderLayout( ) );
		panelSur.add( panelOpciones, BorderLayout.SOUTH );
		
		//Creacion del mundo del problema
		
		File archivo = new File("./data/empleados.data");
		
		buscar = new Empresa(archivo);
		
		Empleado empleado = buscar.darEmpleadoActual();
		
		panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
				empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
				empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
				empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());

		
	}
	
	
	// ----------------------------------------------------------------------------
	// Requisitos Funcionales
	// ----------------------------------------------------------------------------
		
	
	public void verAnterior()
	{
		try 
		{
			Empleado empleado = buscar.darEmpleadoAnterior();
			panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
					empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
					empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
					empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver Empleado anterior ", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void verSiguiente()
	{
		try 
		{
			Empleado empleado = buscar.darEmpleadoSiguiente();
			panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
					empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
					empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
					empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver Empleado siguiente ", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void verPrimero()
	{
		try 
		{
			Empleado empleado = buscar.darPrimerEmpleado();
			panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
					empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
					empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
					empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver primer Empleado ", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void verUltimo()
	{
		try 
		{
			Empleado empleado = buscar.darUltimoEmpleado();
			panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
					empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
					empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
					empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver ultimo Empleado ", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	public void buscarEmpleado()
	{
		 
		String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado");
		if(nombre != null  && !nombre.isEmpty( ))
		{
			try {
				Empleado empleado= buscar.darEmpleadoPorNombre(nombre);
				if(empleado != null)
				{
					
					panelEmpleado.actualizar(empleado.darNombre(), empleado.darCedula(), empleado.darGenero(), 
						empleado.darTipo(), empleado.darSalarioBase(), empleado.darAuxilioTransporte(), 
						empleado.darDescuentoSalario(), empleado.darDescuentoPension(),  
						empleado.darDescuentoFondo(), empleado.darSalarioNeto(), empleado.darImagen());
				}
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog( this,e.getMessage(), "Buscar Empleado",  JOptionPane.INFORMATION_MESSAGE );
			}
			
		}
		 

		
		
	}
	

	
	
	public void ReqFuncOpcion1( )
	{
		String respuesta = buscar.metodo1();
		JOptionPane.showMessageDialog(this, respuesta, "empleado", JOptionPane.INFORMATION_MESSAGE);
	}

	public void ReqFuncOpcion2()
	{
		String respuesta = buscar.metodo2();
		JOptionPane.showMessageDialog(this, respuesta, "empleado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	// ----------------------------------------------------------------------------
	// Main
	// ----------------------------------------------------------------------------
			
	public static void main( String [] args )
	{
		try {
			InterfazEmpresa interfaz = new InterfazEmpresa( );
			interfaz.setVisible( true );
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage( ), "Informacion Empleado", JOptionPane.ERROR_MESSAGE);
		}
	}
}
