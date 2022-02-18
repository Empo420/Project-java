package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class PanelNavegacion extends JPanel implements ActionListener
{
	// ----------------------------------------------------------------------------
	// Constantes
	// ----------------------------------------------------------------------------

	
	public static  final  String PRIMER_EMPLEADO = "Primer Empleado";
	
	public static  final  String ULTIMO_EMPLEADO = "Ultimo Empleado";
	
	public static  final  String SIGUIENTE_EMPLEADO = "Siguiente Empleado";
	
	public static  final  String ANTERIOR_EMPLEADO = "Anterior Empleado";
	
	// ----------------------------------------------------------------------------
	// Atributos
	// -	

	private JButton butPrimero;
	
	private JButton butUltimo;
	
	private JButton butSiguiente;
	
	private JButton butAnterior;
	
	private InterfazEmpresa principal;
	
	
	// ----------------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------------

	public PanelNavegacion(InterfazEmpresa pPrincipal )
	{
		principal = pPrincipal;
		
		// Establecer el distribudor grafico
		setLayout( new GridLayout( 1, 4 ) );
		
		// Crear los objetos
		butPrimero  = new JButton( "Primer Empleado" );
		butPrimero.setActionCommand( PRIMER_EMPLEADO);
		butPrimero.addActionListener(this);
		
		butAnterior = new JButton( "Anterior Empleado" );
		butAnterior.setActionCommand( ANTERIOR_EMPLEADO );
		butAnterior.addActionListener(this);
		
		butSiguiente = new JButton( "Siguiente Empleado" );
		butSiguiente.setActionCommand( SIGUIENTE_EMPLEADO );
		butSiguiente.addActionListener(this);
		
		butUltimo = new JButton( "Ultimo Empleado" );
		butUltimo.setActionCommand( ULTIMO_EMPLEADO );
		butUltimo.addActionListener(this);
		
		
		
		// Agregar los objetos al panel
		add( butPrimero );
		add( butAnterior );
		add( butSiguiente );
		add( butUltimo );
	}
	
	
	// ----------------------------------------------------------------------------
	// Metodos
	// -


	@Override
	public void actionPerformed(ActionEvent evento) 
	{
	
			String comando = evento.getActionCommand();
			
			if(comando.equals(PRIMER_EMPLEADO))
			{
				principal.verPrimero();
			}
			else if(comando.equals(ANTERIOR_EMPLEADO))
			{
				principal.verAnterior();
			}
			else if(comando.equals(SIGUIENTE_EMPLEADO))
			{
				principal.verSiguiente();
			}
			else if(comando.equals(ULTIMO_EMPLEADO))
			{
				principal.verUltimo();
			}
			
	}
}
