////hay que ponerle la operacion en el siguiente formato:
////  num1 op1 num2 op2 = ||||| ej: 123+432-213=
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class prog{
    
    public static void main(String [] Args){
        
        int salida = 0;
        while(salida != 1){
			System.out.println("Ingrese la suma:");

			Scanner scan = new Scanner(System.in);
			String linea = scan.nextLine();
			String buffer = "";
			ArrayList<String> operadores = new ArrayList<String>();
			ArrayList<String> numeros = new ArrayList<String>();
			for(int i = 0; i < linea.length(); i++){
					
					String caracter = String.valueOf(linea.charAt(i));
					if(!caracter.equals("+") && !caracter.equals("=") && !caracter.equals("-"))
						buffer = buffer.concat(String.valueOf(linea.charAt(i)));
					else{
						
						if(caracter.equals("+"))
							operadores.add("+");
						
						if(caracter.equals("-"))
							operadores.add("-");
							
						if(caracter.equals("=")){
							numeros.add(buffer);
							
							int resultado = 0;
							for(int j = 0; j < numeros.size(); j++){
								if(j == 0)
									resultado = Integer.valueOf(numeros.get(j)).intValue();
								else{
										String dato = operadores.get(j-1);
										if(dato.equals("+"))                            
											resultado += Integer.valueOf(numeros.get(j)).intValue();
										if(dato.equals("-"))
											resultado -= Integer.valueOf(numeros.get(j)).intValue();
									}
								}
							
							System.out.println(resultado);
							System.out.println("ingrese '1' para salir o '0' para hacer otra operacion");
							salida = scan.nextInt();
							break;
						}
						numeros.add(buffer);
						buffer = "";
					}
			}
		}
	}
}
