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
public class Quicksort {
    static void swap(int[] a, int i, int j) {
		int aux=0;
		aux=a[i];
		a[i]=a[j];
		a[j]=aux;
	}
	static int partition(int[] a, int l, int r) {
		int i=l, j=i+1, m=j;
		while(i<r && j<=r){
			if(a[i]>a[j]){
				swap(a, m, j);		
				m++;
				j++;
			}else{	
				j++;		
			}				
		}
		swap(a, i , m-1);
		return m-1;
	}
	static void quickrec(int[] a, int l, int r) {
		if(l<r){
			int aux;
			aux=partition(a, l, r);
			quickrec(a,l,aux-1);
			quickrec(a,aux+1,r);
		}
	}
	static void quicksort(int[] a) {
		if(a.length!=0){
          quickrec(a,0,a.length-1);
		}
	}

}
