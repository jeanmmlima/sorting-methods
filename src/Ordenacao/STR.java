package Ordenacao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * ;;@author Josiele Queiroz
 */
// A classe Ex3 é fornecida, para testar o código de Quicksort
class STR {
    
    
    static final int tamanho = 1000;
    static boolean is_sorted(LinkedList<Integer> l) {
         int v = Integer.MIN_VALUE;
         for (int x : l) {
             if (!(v <= x))
                 return false;
             v = x;
         }
         return true;
     }

     static int[] occurrences(LinkedList<Integer> l) {
         int[] occ = new int[M];
         for (int x : l)
             occ[x]++;
         return occ;
     }

     static boolean is_permut(LinkedList<Integer> l1, LinkedList<Integer> l2) {
         int[] occ1 = occurrences(l1);
         int[] occ2 = occurrences(l2);
         for (int i = 0; i < M; i++)
             if (occ1[i] != occ2[i])
                 return false;
         return true;
     }

     static LinkedList<Integer> random_list(int len) {
         LinkedList<Integer> l = new LinkedList<Integer>();
         for (int i = 0; i < len; i++)
             l.add((int) (M * Math.random()));
         return l;
     }
    
    static boolean is_sorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (!(a[i-1] <= a[i])) return false;
        return true;
    }
    static final int M = 1000; // os elementos estão entre 0..M-1
    static int[] occurrences(int[] a) {
        int[] occ = new int[M];
        for (int i = 0; i < a.length; i++)
            occ[a[i]]++;
        return occ;
    }
    static boolean is_permut(int[] occ1, int[] occ2) {
        for (int i = 0; i < M; i++)
            if (occ1[i] != occ2[i]) return false;
        return true;
    }
    static String print(int[] a) {
        String s = "[";
        for (int i = 0; i < a.length; i++)
            s += (i == 0 ? "" : ", ") + a[i];
        return s + "]";
    }
    static int[] random_array(int len) {
        int[] a = new int[len];
        int i =0;
        for ( i = 0; i < len; i++){
            a[i] = (int)(M * Math.random());
        }
         System.out.print("a = [");
         for ( i = 0; i < len-1; i++){
           System.out.print(a[i]+", ");
         }
         System.out.println(a[i] + "]");
         
        return a;
    }
    
    static long test(int[] a, int cod) throws InterruptedException {
        
        long inicio=0,fim=0;
        //System.out.println("  teste com       a = " + print(a));
        int[] occ1 = occurrences(a);
       // Thread.sleep(100);
        if(cod == 1){
        //########################################################
        inicio = System.nanoTime();  
        Quicksort.quicksort(a);
        fim  = System.nanoTime();}
        //#########################################################
        if(cod == 2){
	    inicio = System.nanoTime();  
        Bubblesort.bubbleSort(a);
        fim  = System.nanoTime();}
        if(cod == 3){
        	
        	long timeStart, timeEnd;
        	timeStart = System.nanoTime();
        	
           // System.out.println("teste de split");
            for (int len = 0; len < tamanho; len++) {
                LinkedList<Integer> l = random_list(len);
              //  System.out.println("         l = " + l);
                int occ[] = occurrences(l);
                LinkedList<Integer> l1 = new LinkedList<Integer>(), l2 = new LinkedList<Integer>();
            	
                Mergesort.split(l, l1, l2);
                int[] new_occ = occurrences(l);
                for (int i = 0; i < M; i++)
                    if (occ[i] != new_occ[i]) {
                        System.out.println("ERRO : split modificou seu parametro (l = " + l + ")");
                        System.exit(1);
                    }
              //  System.out.println("  split(l) = " + l1 + " / " + l2);
                int occ0_0[] = occurrences(l1);
                int occ1_1_1[] = occurrences(l2);
                for (int i = 0; i < M; i++)
                    if (occ0_0[i] + occ1_1_1[i] != occ[i]) {
                        System.out.println("ERRO : os elementos diferem");
                        System.exit(1);
                    }
            }
            System.out.println("teste de merge");
            for (int len = 0; len < tamanho/2; len++) {
                LinkedList<Integer> l1 = new LinkedList<Integer>(), l2 = new LinkedList<Integer>();
                for (int i = 0; i < len; i++) {
                    l1.add(2 * i);
                    l2.add(2 * i + 1);
                }
               // System.out.println("            l1 = " + l1);
              //  System.out.println("            l2 = " + l2);
                int occ1_1[] = occurrences(l1);
                int occ2_2[] = occurrences(l2);
                LinkedList<Integer> l = Mergesort.merge(l1, l2);
              //  System.out.println("  merge(l1,l2) = " + l);
                if (!is_sorted(l)) {
                    System.out.println("ERRO : o resultado nao esta ordenado");
                    System.exit(1);
                }
                int occ[] = occurrences(l);
                for (int i = 0; i < M; i++)
                    if (occ1_1[i] + occ2_2[i] != occ[i]) {
                        System.out.println("ERRO : os elementos diferem");
                        System.exit(1);
                    }
            }
           /* System.out.println("teste de mergesort");
            for (int len = 0; len < tamanho; len++)
                for (int j = 0; j <= len; j++)
                    test(random_list(len));
            System.out.println("SUCESSO");*/
            
            timeEnd = System.nanoTime();
            System.out.println("Tempo Corrido: "+(timeEnd-timeStart)/100000000+ " milisegundos");
            return (timeEnd-timeStart)/100000000;
        }
        
        
        
        int[] occ2 = occurrences(a);
        System.out.println("ordenado => a = " + print(a));
        if (!is_sorted(a)) {
            System.out.println("ERRO : o resultado nao esta ordenado");
            System.exit(1);
        }
        if (!is_permut(occ1, occ2)) {
            System.out.println("ERRO : os elementos diferem");
            System.exit(1);
        }
       //tempo = 
        return (fim - inicio)/1000000;
    }
    
    
    
    
    
    public static void main(String[] args) throws InterruptedException {
        //long inicio = System.currentTimeMillis();  
        Scanner sc = new Scanner(System.in);
        int i=0, len=20000;
        System.out.println("teste de quicksort");
        System.out.println("Digite o tamanho do array que deseja ordenar: ");
        len = sc.nextInt();
        int [] a = random_array(len);
        System.out.println("Digite o codigo: 1 - Quicksort, 2 - BubbleSort, 3 - MergeSort: ");
        int c = sc.nextInt();
        System.out.println("tempo de processamento = "+ test(a,c)+ " ms"); 
        //long fim  = System.currentTimeMillis();
        //System.out.println("tempo de processamento = "+ (fim - inicio));
        System.out.println("SUCESSO");
   
        
    }
}
