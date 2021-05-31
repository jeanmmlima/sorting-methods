/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

/**
 *
 * @author jeanmarioml
 */
public class Bubblesort {
    static void bubbleSort(int[] a) {
		int i=0, j=0, aux=0, swap=0;
		for(i= a.length-1 ; i > 0;i--){
			swap = 0;
			for(j=0;j<i;j++)
				if(a[j]>a[j+1]){
					aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
					swap =1; 		
			}
			if(swap==0){
				return;
			}
		}
	}
}
