package mundo;

import java.io.*;
import java.util.*;
import javax.swing.*;


/**
 * Clase que representa la Empresa.
 */
public class Empresa {
	
	// -----------------------------------------------------------------
    // atributos
    // -----------------------------------------------------------------

	/**
    *coleccion de empleados.
    */
	private ArrayList <Empleado> empleados;
	
	/**
    * empleado actual
    */
	private int empleadoActual = 0;
	
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	/**
	 * Crea los empleados por medio de el archivo
	 * @param archivo archivo != nul;
	 * @throws Exception
	 */
	public Empresa( File archivo)throws Exception
	{
		
		empleados = new ArrayList<>( );
		
		Properties datos = cargarInfoEmpleados(archivo);
		
		String valor =  datos.getProperty("empresa.cantidadEmpleados");
		
		int cantidadEmpleados = Integer.parseInt(valor);
		
		for(int i = 0; i < cantidadEmpleados; i++)
		{
			int numeroEmpleado = i + 1;
			
			
			String nombre = datos.getProperty("empresa.empleado" + numeroEmpleado + ".nombreEmpleado");	
			
			valor = datos.getProperty("empresa.empleado" + numeroEmpleado + ".cedulaEmpleado");
			int cedula = Integer.parseInt( valor );
			
			String genero = datos.getProperty("empresa.empleado" + numeroEmpleado + ".generoEmpleado");
			
			
			String category = datos.getProperty("empresa.empleado" + numeroEmpleado + ".categoriaEmpleado");
			int categoria = Integer.parseInt( category );
			
			
			String afiliados = datos.getProperty("empresa.empleado" + numeroEmpleado + ".afiliadoFondoEmpleado");
			boolean afiliado = false;
			if(afiliados.equals("S"))
			{
				afiliado = true;
			}
			else {
				afiliado = false;
			}
			

			String imagen = datos.getProperty("empresa.empleado" + numeroEmpleado + ".imagen");
			
			
		
			Empleado empleado = new Empleado (nombre,cedula,genero,categoria,afiliado,imagen);
			empleados.add(empleado);


			}
		}
		
	// -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
	
	/**
	 * carga la informacion de los empleados
	 * @param archivo Nombre del archivo donde se encuentran los datos de los empleados
	 * @return los datos del empelado
	 * @throws Exception Si ocurre algún error cargando los datos.
	 */
	public Properties cargarInfoEmpleados(File archivo)throws Exception
	{
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(archivo);
		datos.load(in);
		in.close();
		return datos;
	}
	
	
	/**
	 * retona la cantidad de empleados
	 * @return
	 */
	public int darCantidadEmpleados()
	{
		return empleados.size();
	}
	
	 /**
     * Retorna el primer empleado. <br>
     * <b>post: </b> Se actualizó la posición del empleado actual.
     * @return El primer empleado, que ahora es el empleado actual.
     * @throws Exception Si ya se encuentra en el primer emleado.
     */
	public Empleado darEmpleadoActual()throws Exception
	{
		Empleado empleado = empleados.get(empleadoActual);
		
		if(empleado == null)
		{
			throw new Exception("no existe ningun empleado");
		}
		return empleado;
	}
	
	 /**
     * Retorna el empleado siguiente al actual. <br>
     * <b>post: </b> Se actualizó la posición del empleado actual.
     * @return El siguiente empleado, que ahora es el empleado actual.
     * @throws Exception Si ya se encuentra en el último empleado
     */
	public Empleado darEmpleadoSiguiente()throws Exception
	{
		if(empleadoActual + 1 < empleados.size())
		{
			empleadoActual++;
			return darEmpleadoActual();
		}
		else {
			 throw new Exception("ya esta en el ultimo empleado");
		}
		
	}
	
	
	/**
     * Retorna el empleado anterior al actual. <br>
     * <b>post: </b> Se actualizó la posición del empleado actual.
     * @return El anterior empleado, que ahora es el vehículo actual.
     * @throws Exception Si ya se encuentra en el primer empleado.
     */
	public Empleado darEmpleadoAnterior()throws Exception
	{
		if( empleadoActual == 0 )
        {
            throw new Exception( "Se encuentra en el primer Empleado." );
        }
		empleadoActual--;
        return darEmpleadoActual( );
	}
	
	/**
     * Retorna el primer empleado. <br>
     * <b>post: </b> Se actualizó la posición del empleado actual.
     * @return El primer empleado, que ahora es el empleado actual.
     * @throws Exception Si ya se encuentra en el primer empleado.
     */
	public Empleado darPrimerEmpleado()throws Exception
	{
		 if( empleadoActual == 0 )
	        {
	            throw new Exception( "Ya se encuentra en el primer Empleado." );
	        }
		 	empleadoActual = 0;
	        return darEmpleadoActual( );
	}
	
	
	 /**
     * Retorna el último empleado. <br>
     * <b>post: </b> Se actualizó la posición del empleado actual.
     * @return El último empleado, que ahora es el empleado actual.
     * @throws Exception Si ya se encuentra en el último empleado
     */
	public Empleado darUltimoEmpleado()throws Exception
	{
		if( empleadoActual == empleados.size() - 1 )
        {
            throw new Exception( "Ya se encuentra en el último empleado." );
        }
		empleadoActual = empleados.size() - 1;
        return darEmpleadoActual( );
		
	}
	
	/**
     * Busca un empleado por el parametro
     * @return El empleado a buscar.
     * @throws Exception No se encontro empleado con ese nombre
     */
	public Empleado darEmpleadoPorNombre(String nombreP) throws Exception
	{	
		boolean existe = false;
		Empleado empleado = null;
		
		for(int i = 0; i < empleados.size() && !existe; i++)
		{
			empleado = empleados.get( i );
			if(empleado.darNombre().equals(nombreP))
			{
				existe = true;
				empleadoActual = i;
			}	
		}
		if(!existe)
		{
			throw new Exception( "No se encontro empleado con ese nombre" );
		}
		
		return empleado;
	}
	
	
	// ----------------------------------------------------------------
    // Puntos de Extensión
    // ----------------------------------------------------------------

    /**
     * Método para la extensión 1 del ejercicio.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2 del ejercicio.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
