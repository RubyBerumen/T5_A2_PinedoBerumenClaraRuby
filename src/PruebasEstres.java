import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class NumerosAleatoriaos{
	
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
			tInicio=System.nanoTime();
			for (int i=1; i<=numeros.length-1; i++) {
				for (int j=0; j<=numeros.length-i-1; j++) {
					if (numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja1:"+(tFin-tInicio));
		}// Burbuja1
		
		public static void ordenacionBurbuja2(int [] nums) {
			int numeros [] = nums.clone();
			tInicio = System.nanoTime();
            for(int i=1; i<numeros.length; i++) {
				
				for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
            tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja2: " + (tFin-tInicio));
		}// Burbuja2
		
		public static void ordenacionBurbuja3(int [] nums) {
			int numeros [] = nums.clone();
			 tInicio = System.nanoTime();
	           int i=1;
	     	   do {
	     		   
	     		   for(int j=0; j<numeros.length-i; j++) {
	 					
	 					if(numeros[j]>numeros[j+1]) {
	 						int aux = numeros[j];
	 						numeros[j] = numeros[j+1];
	 						numeros[j+1] = aux;
	 					}
	 				}
	     		   
	     		   i=1+i;
	     	   }while(i<numeros.length);
	     	    tFin = System.nanoTime();
				System.out.println("Tiempo de ejecucion en ordenamiento por burbuja3: " + (tFin-tInicio));
		}// Burbuja3
		
		public static void mostrarVector(int [] numeros) {
			System.out.println(Arrays.toString(numeros));
		}
		
	}//class Burbuja
	
	
	
	static class Insercion{
		
		static long tInicio, tFin;
		
		public static void ordenar(int[]nums) {
			int numeros [] = nums.clone();
			tInicio=System.nanoTime();
			int aux;
			for (int i = 0; i < numeros.length; i++) {
				aux = numeros[i];
				
				for (int j = i-1; j > 0 && numeros[j]>aux; j--) {
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
				}
				
			}
			tFin = System.nanoTime();
		}
	}//class insercion
	
	
	
	static class Seleccion{
		
		static long tInicio, tFin;
		
		public static void ordenamiento(int []nums) {
			int numeros [] = nums.clone();
			tInicio=System.nanoTime();
			for (int i = 0; i < numeros.length-1; i++) {
				for (int j = i; j < numeros.length; j++) {
					if(numeros[i]> numeros[j]) {
						int minimo = numeros[i];
						numeros[i]=numeros[j];
						numeros [j] = minimo;
					}
					
				}
			}
			tFin = System.nanoTime();
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
			tInicio=System.nanoTime();
			int intervalo;
			intervalo = numeros.length/2;
			
			while(intervalo>0) {
				for(int i = intervalo; i<numeros.length; i++) {
					int j=i-intervalo;
					while(j>=0) {
						int k=j+intervalo;
						if(numeros[j] <= numeros[k]) {
							j-=1;
						}else {
							int aux = numeros[j];
							numeros[j] = numeros[k];
							numeros[k] = aux;
							j-=intervalo;
						}
					}
				}
				intervalo=intervalo/2;
			}
			tFin = System.nanoTime();
			
		}//public void ordenar
		
	}//class shellsort
	
	
	
	static class Radix{
		
		static long tInicio, tFin;
		
		public static void orden(int[]nums) {
			int numeros [] = nums.clone();
			tInicio=System.nanoTime();
		      if(numeros.length == 0)
		          return;
		          int[][] np = new int[numeros.length][2];
		          int[] q = new int[0x100];
		          int i,j,k,l,f = 0;
		          for(k=0;k<4;k++) {
		             for(i=0;i<(np.length-1);i++)
		             np[i][1] = i+1;
		             np[i][1] = -1;
		             for(i=0;i<q.length;i++)
		             q[i] = -1;
		             for(f=i=0;i<numeros.length;i++) {
		                j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
		                if(q[j] == -1)
		                l = q[j] = f;
		             else {
		                l = q[j];
		                while(np[l][1] != -1)
		                l = np[l][1];
		                np[l][1] = f;
		                l = np[l][1];
		             }
		             f = np[f][1];
		             np[l][0] = numeros[i];
		             np[l][1] = -1;
		          }
		          for(l=q[i=j=0];i<0x100;i++)
		          for(l=q[i];l!=-1;l=np[l][1])
		        	  numeros[j++] = np[l][0];
		       }//for
		       tFin = System.nanoTime();
		}//orden
		
	}//class Radix
	
	
	public static void mostrarVector(int [] numeros) {
		System.out.println("Vector ordenado: "+Arrays.toString(numeros) + "\n\n");
	}

}//class MetodosOrdenamiento

public class PruebasEstres {

	public static void main(String[] args) {


	}

}
