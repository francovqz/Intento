////hay que ponerle la operacion en el siguiente formato:
////num1 op1 num2 op2  ||||| ej: 123+432-213

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

	 public static void main(String [] Args){
	        
	        int salida = 0;
	        while(salida != 1){
				System.out.println("Ingrese el calculo a realizar:");

				Scanner scan = new Scanner(System.in);
				String linea = scan.nextLine();
				
				ArrayList<String> operadores = new ArrayList<String>();
				ArrayList<String> numeros = new ArrayList<String>();
				
				leerCuenta(linea, operadores, numeros);
				
				int resultado = calcular(operadores, numeros);
					
				System.out.println(resultado);
				
					
				System.out.println("Ingrese '1' para salir o '0' para hacer otra operacion");
				try {
					salida = scan.nextInt();
					}
				catch(Exception e){
						System.out.println("ingreso un valor no entero");
						break;
					}
				
				
			}
		}
		
		public static void leerCuenta(String cuenta, ArrayList<String> operadores, ArrayList<String> numeros){
			String buffer = "";
			for(int i = 0; i < cuenta.length(); i++){
						
						String caracter = String.valueOf(cuenta.charAt(i));
						if(!caracter.equals("+") && !caracter.equals("-") && !caracter.equals("*") && !caracter.equals("/") && !caracter.equals("%"))
							buffer = buffer.concat(String.valueOf(cuenta.charAt(i)));
						else{
							
							if(caracter.equals("+"))
								operadores.add("+");
							
							if(caracter.equals("-"))
								operadores.add("-");
								
							if(caracter.equals("*"))
								operadores.add("*");
							
							if(caracter.equals("/"))
								operadores.add("/");
								
							if(caracter.equals("%"))
								operadores.add("%");
								
							numeros.add(buffer);
							buffer = "";
						}
				}
			numeros.add(buffer);
		}
		
		public static int calcular(ArrayList<String> operadores, ArrayList<String> numeros){
		
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
						if(dato.equals("*"))
							if(j == 1){/////quiere decir que es el primer operador
								resultado = resultado * Integer.valueOf(numeros.get(j)).intValue();
								break;
							}
						if(dato.equals("/"))
							if(j == 1){/////quiere decir que es el primer operador
								resultado = resultado / Integer.valueOf(numeros.get(j)).intValue();
								break;
							}
						if(dato.equals("%"))
							if(j == 1){/////quiere decir que es el primer operador
								resultado = resultado % Integer.valueOf(numeros.get(j)).intValue();
								break;
							}		
					}
			}
			return resultado;	
		}

}
