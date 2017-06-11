package fechas;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dates {

	public static void main(String[] args) {
		
		Dates gc= new Dates();

	}
	
	//Este siguiente es un constructor sin par�metros que directamente imprime al ser instanciada la clase.
	public Dates(){
		/*
		 * En todos los casos con fechas Java convierte los datos desde Date que es un 'objeto'
		 * donde pod�s convertirlo en un String con toString() o manualmente en un String nuevo.
		 *
		 */
		
			//Gregorian calendar le da un formato estructurado de una manera determinada al String y sirve esencialmente si hay par�metros de por medio.
				GregorianCalendar gr_Sin_Param= new GregorianCalendar();	//Creamos objeto Gregorian, si no le das par�metro solo crea un Date()
				Date date_Gr_Sin_Param = gr_Sin_Param.getTime();						//getTime() lo convierte a una serie de n�meros String no identificables por humanos
				String str_date_Gr_Sin_Param = date_Gr_Sin_Param.toString();			//toString() s�lo sirve en este caso.
				System.out.println(str_date_Gr_Sin_Param);					//Imprimimos el String anterior.
			
			//Simple date format impone un formato y luego a Date lo parsea. 
				SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				Date d= new Date();
				String format= f.format(d);
				System.out.println(format);
			
			/*
			 * Date s�lo crea un objeto sin parseo o formato, el m�todo getTime() directamente
			 * lo convierte en un String asi no tenes que hacer todos los pasos pero no es identific.
			 */
				Date dateCrudo= new Date();					//Creamos la fecha
				String convertir= dateCrudo.toString();		//Convertimos el objeto fecha en String con toString() de la clase Object
				System.out.println(convertir);				//Lo imprimimos
				
			/*
			 * Ac� hay algo que ten�s que tener en cuenta, tanto GregorianCalendar es una clase verso si no tiene par�metros,
			 * Porqu�? porque no es necesario crear una instancia de la misma para obtener un mismo resultado, como la hora actual
			 * en cambio si se usan par�metros dentro del GregorianCalendar cambia su uso, ten� en cuenta que ya con el s�lo
			 * hecho de crear una instancia de Date est�s creando un objeto fecha, el cual si llam�s
			 * al m�todos getTime() tampoco necesit�s convertirlo en String, porqu�? porque los de Java
			 * no son pelotudos y dentro del m�todo getTime() est� incluido la funci�n String autom�ticamente
			 * probablemente despu�s de usar getTime() tendr�s que parsearlo para poder entenderlo como humano.
			 */
				Date dateCrudisimo= new Date();		//Creamos el objeto fecha(Date)
				System.out.println(dateCrudisimo);	//Ahora si imprimimos directamente el objeto sale como un String
				
			
			 /*
			  * Porqu� el m�s crudo de todos imprime lo mismo que el GregorianCalendar?
			  * Porque como te dar�s cuenta todos los pasos anteriores son al pedo si
			  * no ten�s par�metros de por medio, ya que aunque Cre�s una clase GregorianCalendar,
			  * SimpleDateFormat, uses toString() o lo que sea, apenas cre�s el Date() Java ya te
			  * cre� un objeto que es un 'String' crudo de la hora actual de tu pc. y todo por no usar par�metros
			  * dentro del contructor de GregorianCalendar o cualquiera de las Clases que usamos.
			  * En resumen el resultado es siempre el mismo.
			  */
				
				
				
			/*
			 * Ac� cambia todo ya que se ingresaron par�metros en Gregorian Calendar
			 * por ende se us� el contructor del mismo y se tiene que hacer manualmente aplicar
			 *  el e�todo getTime(), luego parsearlo a String y finalmente ah� s� imprimirlo.
			 */
				GregorianCalendar gregorian_Parametros= new GregorianCalendar(1995,11-1,21);	//Creamos objeto Gregorian, si no le das par�metro solo crea un Date()
				Date date_Gregorian_Parametros = gregorian_Parametros.getTime();				//getTime() lo convierte a una serie de n�meros String no identificables por humanos
				String str_date_Gregorian_Parametros = date_Gregorian_Parametros.toString();	//toString() s�lo sirve en este caso.
				System.out.println(str_date_Gregorian_Parametros);		
				
			
			/*
			 * Mir� que pasa si a GregorianCalendar u a otra le pas�s par�metros y pretend�s
			 * imprimirlo directamente:
			 */
				
				GregorianCalendar gregorian_con_Parametros= new GregorianCalendar(1995,11-1,21);
				System.out.println(gregorian_con_Parametros);
				
				
			/* La forma m�s moderna de manejar Fechas hoy en java 8 es con:
			 * LocalDateTime, LocaDate, LocalTime, LocalDateTimeFormater.
			 */
				
				LocalDate local= LocalDate.now(); //Como se ve creamos un objeto de referencia y le asignamos una clase est�tica llamada LocalDate de java 8
							System.out.println(local);  //Captura la fecha actual.
				
				LocalDate local_1= LocalDate.of(2017, Month.JULY, 01);	//La misma clase est�tica LocalDate tiene un m�todo 'of' que admite 9999-99-99 para setear una fecha en String.
							System.out.println(local_1);  //Damos formato a la fecha como queramos
				
				//Podemos realizar un parse de una fecha cualquiera de un String adentro de un LocalDate de la siguiente manera;
				
				String fecha_String= "2300-12-04";	//Podemos hacer un String y de ahi parsear el mismo, pero tiene que respetar este formato 9999-99-99; 
				LocalDate local_2= LocalDate.parse(fecha_String);	//Creamos el objeto LocalDate, llamamos a la Clase est�tica y llamamos al m�todo parse, adentro colocamos el String.
							System.out.println(local_2);	//Lo imprimimos por consola.
							
				//Actualemente es el m�todo m�s moderno para la impresi�n de fechas, tiene decenas m�s de m�todos es una clase muy completa y es el �nico que toman en la certificaci�n OCA.
	}

}