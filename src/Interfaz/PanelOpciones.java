package Interfaz;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*; 



public class PanelOpciones  extends JPanel implements ActionListener
{

	
	    // ----------------------------------------------------------------------------
		// Constantes
		// ----------------------------------------------------------------------------
	
		public static final String BUSCAR_EMPLEADO = "Buscar Empleado";
		public static final String OPCION_1 = "Opcion 1";
		public static final String OPCION_2 = "Opcion 2";
		
		// ----------------------------------------------------------------------------
		// Atributos
		// ----------------------------------------------------------------------------

		private JButton butBuscarEmpleado;
		private JButton butOpcion1;
		private JButton butOpcion2;
		
		
		private InterfazEmpresa principal;
		
		// ----------------------------------------------------------------------------
		// Constructor
		// ----------------------------------------------------------------------------

		public PanelOpciones(InterfazEmpresa pPrincipal )
		{
			principal = pPrincipal;
			
			TitledBorder borde = new TitledBorder( "Opciones" );
			setBorder( borde );
			
			// Se establece el distribuidor grafico
			setLayout( new GridLayout(1, 3) );
			
			// Creacion de objetos del panel
			butBuscarEmpleado = new JButton( "Buscar Empleado" );
			butBuscarEmpleado.setActionCommand( BUSCAR_EMPLEADO );
			butBuscarEmpleado.addActionListener(this);
			add( butBuscarEmpleado );
			
			butOpcion1 = new JButton( "Opcion 1" );
			butOpcion1.setActionCommand( OPCION_1 );
			butOpcion1.addActionListener(this);
			add( butOpcion1 );
			
			butOpcion2 = new JButton( "Opcion 2" );
			butOpcion2.setActionCommand( OPCION_2 );
			butOpcion2.addActionListener(this);
			add( butOpcion2 );
		}

		// ----------------------------------------------------------------------------
		// Metodos
		// ----------------------------------------------------------------------------

		public void actionPerformed(ActionEvent evento) 
		{
			String comando = evento.getActionCommand();
			
			if(comando.equals(OPCION_1))
			{
				principal.ReqFuncOpcion1();
			}
			else if(comando.equals(OPCION_2))
			{
				principal.ReqFuncOpcion2();
			}
			else if(comando.equals(BUSCAR_EMPLEADO))
			{
				principal.buscarEmpleado();
			}
		}
			
}
