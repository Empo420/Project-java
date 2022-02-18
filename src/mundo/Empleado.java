package mundo;

/**
 * Clase que representa un Empleado.
 */
public class Empleado {
	
	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
     * tipo ADMINISTRATIVO que es igual a 1.
     */
	public static  final  int ADMINISTRATIVO = 1;
	
	/**
     * tipo OPERATIVO que es igual a 2.
     */
	public static  final  int OPERATIVO = 2;
	
	/**
     * tipo CONTRATISTA que es igual a 3.
     */
	public static  final  int CONTRATISTA = 3;
	
	/**
     * Constante que es el salario minimo legal vigente.
     */
	public static  final  double SMMLV = 781242;
	
	/**
     * Constante que es el salario del contratista de tamaño fijo.
     */
	public static  final  double SALARIO_CONTRATISTA = SMMLV * 2.5;
	
	/**
     * Constante que es el salario del operativo de tamaño fijo.
     */
	public static  final  double SALARIO_OPERATIVO = SMMLV;
	
	/**
     * Constante que es el salario del administraivo de tamaño fijo.
     */
	public static  final  double SALARIO_ADMINISTRATIVO = SMMLV * 3;
	
	/**
     * Constante que es el auxulio de transporte de tamaño fijo.
     */
	public static  final  double AUXILIO__TRANSPORTE = 88211;
	
	/**
     * Constante del decuento del fondo de tanaño fijo.
     */
	public static  final  double DESCUENTO_FONDO = 30000;
	
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/**
     * Nombre del empleado.
     */
	private String nombre;
	
	/**
     * Cedula del empleado.
     */
	private int cedula;
	
	/**
     * genero del empleado
     */
	private String genero;
	
	/**
     * categoria del empleado.
     */
	private int categoria;
	
	/**
     * afiliado del empleado.
     */
	private boolean afiliado;
	
	/**
     * imagen del empleaodo.
     */
	private String imagen;
	
	
	// -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

	/**
	 * * Crea un empleado con la información dada por parámetro. 
	 * @param nombreP Nombre del empleado. nombreP != null .
	 * @param cedulaP cedula del empleado. cedulaP != " 0".
	 * @param generoP genero del empleado. nombreP != null .
	 * @param categoriaP categoria del empleado. categoriaP != null .
	 * @param afiliadoP afiliado del empleado. afiliadoP != null 
	 */
	public Empleado(String nombreP, int cedulaP, String generoP, int categoriaP, boolean afiliadoP, String imagenP   ) 
	{
		nombre = nombreP;
		cedula = cedulaP;
		genero = generoP;
		categoria = categoriaP;
		afiliado = afiliadoP;
		imagen = imagenP;
	}
	
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	
	/**
	 * Retorna el nombre del empleado.
	 * @return
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Retorna el cedula del empleado.
	 * @return
	 */
	public int darCedula() {
		return cedula;
	}

	/**
	 * Retorna el genero del empleado.
	 * @return
	 */
	public String darGenero() {
		return genero;
	}
	
	/**
	 * Retorna el categoria del empleado.
	 * @return
	 */
	public int darCategoria() {
		return categoria;
	}
	
	/**
	 * Retorna el imagen del empleado.
	 * @return
	 */
	public String darImagen() {
		return imagen;
	}

	/**
	 * Retorna si el empleado esta afiliado.
	 * @return
	 */
	public boolean estaAfiliadoFondo() 
	{	
		boolean fondo = false;
		boolean S = true;
		
		if(afiliado == S)
		{
		    fondo = true;
		}
		return fondo;
		
	}
	
	/**
	 * Retorna el tipo del empleado.
	 * @return
	 */
	public String darTipo()
	{
		if(darCategoria() == 3)
		{
			return "Contratista";
		}
		else if(darCategoria() == 2)
		{
			return "Operativo";
		}
		else {
			return "Administrativo" ;
		}
		
	}
	
	/**
	 * Retorna el salario del empleado.
	 * @return
	 */
	public double darSalarioBase() 
	{
		if(darCategoria() == 3)
		{
			return SALARIO_CONTRATISTA;
		}
		else if(darCategoria() == 2)
		{
			return SALARIO_OPERATIVO;
		}
		else {
			return SALARIO_ADMINISTRATIVO;
		}
		
	}
	
	/**
	 * Retorna el auxilio de transporte del empleado del empleado.
	 * @return
	 */
	public double darAuxilioTransporte() 
	{
		double auxilio = 0.0; 
		
		if(darSalarioBase() <= SMMLV )
		{
			auxilio = AUXILIO__TRANSPORTE;
		}
		
		return auxilio;
	}
	
	/**
	 * Retorna el descuentos de salud del empleado.
	 * @return
	 */
	public double darDescuentoSalario() 
	{
		double descuento = 0.0;
		double ibc = 0.0;
		
		if(darCategoria() == 3)
		{
			ibc =  SALARIO_CONTRATISTA * 40 / 100;
			descuento =  ibc * 12.5 / 100;
			return descuento ;
		}
		
		else if(darCategoria() == 2)
		{
			descuento =  SALARIO_OPERATIVO  * 4 / 100;
			return descuento;
		}
		else
		{
			descuento =  SALARIO_ADMINISTRATIVO * 4 / 100;
			return  descuento;
		}
		
	}
	
	/**
	 * Retorna el descuento de la pension del empleado.
	 * @return
	 */
	public double darDescuentoPension() 
	{
		double descuento = 0.0;
		double ibc = 0.0;
		
		if(darCategoria() == 3)
		{
			ibc =  SALARIO_CONTRATISTA * 40 / 100;
			descuento =  ibc * 16 / 100;
			return descuento;
		}
		
		else if(darCategoria() == 2)
		{
			descuento =  SALARIO_OPERATIVO  * 4 / 100;
			return descuento;
		}
		else
		{
			descuento =  SALARIO_ADMINISTRATIVO * 4 / 100;
			return descuento;
		}
	}
	
	/**
	 * Retorna el descuento del fondo del empleado.
	 * @return
	 */
	public double darDescuentoFondo() 
	{
		double descuento = 0.0;
		
		if(estaAfiliadoFondo() == true)
		{
			descuento = DESCUENTO_FONDO;
		}
		
		return descuento;
	}
	
	/**
	 * Retorna el salario que gana del empleado.
	 * @return
	 */
	public double darSalarioNeto() 
	{
		return darSalarioBase() - darDescuentoSalario() - darDescuentoPension() - darDescuentoFondo() + darAuxilioTransporte();  
	}
	
}	