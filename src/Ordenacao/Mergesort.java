/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;
import java.util.LinkedList;
/**
 *
 * @author jeanmario
 */
public class Mergesort {
    public static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
        // a ser completada
        
        for(int i=0; i < l.size()-1 ; i=i+2){
            int j = 0;
            l1.add(j, l.get(i));
            l2.add(j, l.get(i+1));
            j++;
        }
        if(l.size()%2 == 1){
            l1.add(l1.size(),l.get(l.size()-1) );        
        }
    }
    public static LinkedList<Integer> merge(LinkedList<Integer> l1,
                                     LinkedList<Integer> l2) {
        
       int i = 0,j = 0;
       int ind = 0;
        LinkedList<Integer> temp = new LinkedList<Integer>();
        while((i < l1.size()) && (j < l2.size())){
            
            if (l1.get(i) < l2.get(j)){
                temp.add(ind, l1.get(i));
                i++;
            }
            else{
                temp.add(ind, l2.get(j));
                j++;
            }
            ind++;
        }
        while(i < l1.size()){
            temp.add(ind, l1.get(i));
            i++;
            ind++;
        }
        while(j < l2.size()){
            temp.add(ind, l2.get(j));
            j++;
            ind++;
        }
        return temp;
    }
    
    public static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
        if(l.size() <=1)
            return l;
        LinkedList<Integer> l1 = new LinkedList<Integer>() , l2 = new LinkedList<Integer>();
        split(l,l1,l2);
        l1 = mergesort(l1);
        l2 = mergesort(l2);
        l = merge(l1,l2);
        return l;
    }
}
