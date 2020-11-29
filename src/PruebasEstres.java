import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class NumerosAleatorios{
	
	public static int[] generarNumeros(int cantidad){
		int[] nums = new int[cantidad];
		for (int i = 0; i < nums.length; i++) {
			nums[i]=(int)(Math.random()*cantidad);
		}
	    return nums;
	}
}


class MetodosOrdenamiento{
	
	static class Burbuja{
		
		static long tInicio, tFin;
		
		
		public static void ordenacionBurbuja1(int [] nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio=System.nanoTime();
			recorridos+=1;
			for (int i=1; i<=numeros.length-1; i++) {
				recorridos+=1;
				for (int j=0; j<=numeros.length-i-1; j++) {
					comparaciones+=1;
					if (numeros[j]>numeros[j+1]) {
						intercambios+=1;
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
			tFin = System.nanoTime();
			tiempo = tFin-tInicio;
			System.out.print("Burbuja1:	");
			System.out.print(tiempo + "    ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "    ");
			System.out.println(intercambios);
			
		}// Burbuja1
		
		public static void ordenacionBurbuja2(int [] nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio = System.nanoTime();
			recorridos+=1;
            for(int i=1; i<numeros.length; i++) {
            	recorridos+=1;
				for(int j=0; j<numeros.length-i; j++) {
					comparaciones+=1;
					if(numeros[j]>numeros[j+1]) {
						intercambios+=1;
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
            tFin = System.nanoTime();
			tiempo = tFin-tInicio;
			System.out.print("Burbuja2:	");
			System.out.print(tiempo + "    ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "    ");
			System.out.println(intercambios);
			
		}// Burbuja2
		
		public static void ordenacionBurbuja3(int [] nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			 tInicio = System.nanoTime();
	           int i=1;
	           recorridos+=1;
	     	   do {
	     		  recorridos+=1;
	     		   for(int j=0; j<numeros.length-i; j++) {
	     			  comparaciones+=1;
	 					if(numeros[j]>numeros[j+1]) {
	 						intercambios+=1;
	 						int aux = numeros[j];
	 						numeros[j] = numeros[j+1];
	 						numeros[j+1] = aux;
	 					}
	 				}
	     		   
	     		   i=1+i;
	     	   }while(i<numeros.length);
	     	    tFin = System.nanoTime();
				tiempo = tFin-tInicio;
				System.out.print("Burbuja3:	");
				System.out.print(tiempo + "    ");
				System.out.print(recorridos + "    ");
				System.out.print(comparaciones + "    ");
				System.out.println(intercambios);
				
		}// Burbuja3
		
		
	}//class Burbuja
	
	
	
	static class Insercion{
		
		static long tInicio, tFin;
		
		public static void ordenar(int[]nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio=System.nanoTime();
			int aux;
			recorridos+=1;
			for (int i = 0; i < numeros.length; i++) {
				aux = numeros[i];
				comparaciones+=1;
				recorridos+=1;
				for (int j = i-1; j > 0 && numeros[j]>aux; j--) {
					comparaciones+=1;
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
					intercambios+=1;
				}
				
			}
			tFin = System.nanoTime();
			tiempo = tFin-tInicio;
			System.out.print("Inserción:	");
			System.out.print(tiempo + "    ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "    ");
			System.out.println(intercambios);
		}
	}//class insercion
	
	
	
	static class Seleccion{
		
		static long tInicio, tFin;
		
		public static void ordenamiento(int []nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio=System.nanoTime();
			recorridos+=1;
			for (int i = 0; i < numeros.length-1; i++) {
				recorridos+=1;
				for (int j = i; j < numeros.length; j++) {
					comparaciones+=1;
					if(numeros[i]> numeros[j]) {
						intercambios+=1;
						int minimo = numeros[i];
						numeros[i]=numeros[j];
						numeros [j] = minimo;
					}
					
				}
			}
			tFin = System.nanoTime();
			tiempo = tFin-tInicio;
			System.out.print("Selección:	");
			System.out.print(tiempo + "    ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "    ");
			System.out.println(intercambios);
		}
		
	}//class Seleccion
	
	
	
	static class Quicksort{
		
		public static int[] ordenar (int[]nums, int izq, int der) {
			int numeros [] = nums.clone();

			int pivote = numeros[izq];
			int i = izq, j = der;
			int aux;
			
			while (i<j) {
				while(numeros[i]<=pivote && i<j) i++;
				while(numeros[j]>pivote) j--;
				if(i<j) {
					aux = numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=aux;
				}
				
			}
			numeros[izq] = numeros[j];
			numeros[j] = pivote;
			
			if(izq<j-1) {
				ordenar(numeros,izq,j-1);
			}
				
			if(j+1 < der) {
				ordenar(numeros,j+1,der);
			}
				
			
			return numeros;
			
			
		}
		
	}//quicksort
	
	
	static class Shellsort{
		
		static long tInicio, tFin;
		
		public static void ordenar(int[] nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio=System.nanoTime();
			int intervalo;
			intervalo = numeros.length/2;
			recorridos+=1;
			while(intervalo>0) {
				recorridos+=1;
				for(int i = intervalo; i<numeros.length; i++) {
					int j=i-intervalo;
					recorridos+=1;
					while(j>=0) {
						int k=j+intervalo;
						comparaciones+=1;
						if(numeros[j] <= numeros[k]) {
							j-=1;
						}else {
							int aux = numeros[j];
							intercambios+=1;
							numeros[j] = numeros[k];
							numeros[k] = aux;
							j-=intervalo;
						}
					}
				}
				intervalo=intervalo/2;
			}
			tFin = System.nanoTime();
			tiempo = tFin-tInicio;
			System.out.print("Shellsort:	");
			System.out.print(tiempo + "    ");
			System.out.print(recorridos + "    ");
			System.out.print(comparaciones + "    ");
			System.out.println(intercambios);
			
		}//public void ordenar
		
	}//class shellsort
	
	
	
	static class Radix{
		
		static long tInicio, tFin;
		
		public static void orden(int[]nums) {
			int numeros [] = nums.clone();
			long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
			tInicio=System.nanoTime();
		      if(numeros.length == 0)
		          return;
		          int[][] np = new int[numeros.length][2];
		          int[] q = new int[0x100];
		          int i,j,k,l,f = 0;
		          recorridos+=1;
		          for(k=0;k<4;k++) {
		        	  recorridos+=1;
		             for(i=0;i<(np.length-1);i++)
		             np[i][1] = i+1;
		             np[i][1] = -1;
		             recorridos+=1;
		             for(i=0;i<q.length;i++)
		             q[i] = -1;
		             recorridos+=1;
		             for(f=i=0;i<numeros.length;i++) {
		                j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
		                if(q[j] == -1)
		                l = q[j] = f;
		             else {
		                l = q[j];
		                recorridos+=1;
		                while(np[l][1] != -1)
		                l = np[l][1];
		                np[l][1] = f;
		                l = np[l][1];
		                intercambios+=1;
		             }
		             f = np[f][1];
		             np[l][0] = numeros[i];
		             np[l][1] = -1;
		             intercambios+=1;
		          }
		          for(l=q[i=j=0];i<0x100;i++)
		          for(l=q[i];l!=-1;l=np[l][1])
		        	  numeros[j++] = np[l][0];
		       }//for
		       tFin = System.nanoTime();
				tiempo = tFin-tInicio;
				System.out.print("Radix:		");
				System.out.print(tiempo + "    ");
				System.out.print(recorridos + "    ");
				System.out.print(comparaciones + "    	");
				System.out.println(intercambios);
		}//orden
		
	}//class Radix
	
	
	


}//class MetodosOrdenamiento

class LlamadaMetodos{
	public static void llamar(int []n) {
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(n);
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(n);
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(n);
		MetodosOrdenamiento.Insercion.ordenar(n);
		MetodosOrdenamiento.Seleccion.ordenamiento(n);
		//MetodosOrdenamiento.Quicksort.ordenar(n, 0, n.length);
		MetodosOrdenamiento.Shellsort.ordenar(n);
		MetodosOrdenamiento.Radix.orden(n);
	}
}

public class PruebasEstres {

	public static void main(String[] args) {
		
		System.out.println("--------------------1000 números");
		LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(1000));
		System.out.println();
		System.out.println("--------------------10000 números");
		LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(10000));
		System.out.println();
		System.out.println("--------------------100000 números");
		//LlamadaMetodos.llamar(NumerosAleatorios.generarNumeros(100000));
		


	}

}
