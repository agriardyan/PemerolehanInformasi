package com.pi.proyekpi.indexing;

import java.util.LinkedList;
import java.util.ListIterator;

//gunakan general tab
public class LinkedListOrderedUnique<E> extends LinkedList<E> { //untuk menghemat casting maka gunakan dari java

    int tf = 1;
//    private LinkedListOrderedUnique<Term> termList;
////documentFrequency dokfreq = new documentFrequency();
//    ListIterator<Term> iterator = termList.listIterator();
//    Term vTerm = iterator.next();
//    ListIterator<Document> iterator2 = vTerm.postinglist.listIterator();
//    Document pDoc = iterator2.next();

//Document dok = new Document();
    public boolean addSort(E e) {
        ListIterator<E> iterator = this.listIterator(); //ngambil dari dirinya sendiri
        while (iterator.hasNext()) {
            Document dok = new Document();
            E temp = iterator.next();//temp bertipe E karena menggunakan general, jika tidak maka pake Object
            if (((Comparable) temp).compareTo(e) > 0) { //membandingkan dengan e (objek)
                //berhenti jika temp lebih besar dari e
                iterator.previous();
                iterator.add(e);

                tf = 1;
//                vTerm.getPostinglist().get(pDoc).setDf(tf);
                dok.setDf(tf);

                return true;
            } else if (((Comparable) temp).compareTo(e) == 0) { //membandingkan dengan e (objek)
                //jika sama maka tf nya ditambah satu


                tf = tf + 1;
//                dok.setDf(tf);
//                vTerm.getPostinglist().get(pDoc).setDf(tf);
                dok.setDf(tf);

                return true;
            }
        }
        iterator.add(e);
        return true;
    }
    
    public boolean addSortNonUnique(E e) {
        ListIterator<E> iterator = this.listIterator(); //ngambil dari dirinya sendiri
        while (iterator.hasNext()) {
            Document dok = new Document();
            E temp = iterator.next();//temp bertipe E karena menggunakan general, jika tidak maka pake Object
            if (((Comparable) temp).compareTo(e) >= 0) { //membandingkan dengan e (objek)
                //berhenti jika temp lebih besar dari e
                iterator.previous();
                iterator.add(e);

                tf = 1;
//                vTerm.getPostinglist().get(pDoc).setDf(tf);
                dok.setDf(tf);

                return true;
            } else  { //membandingkan dengan e (objek)
                //jika sama maka tf nya ditambah satu
                
                //berhenti jika temp lebih besar dari e
                iterator.previous();
                iterator.add(e);

                tf = 1;
//                vTerm.getPostinglist().get(pDoc).setDf(tf);
                dok.setDf(tf);

                return true;


//                tf = tf + 1;
////                dok.setDf(tf);
////                vTerm.getPostinglist().get(pDoc).setDf(tf);
//                dok.setDf(tf);
//
//                return true;
            }
        }
        iterator.add(e);
        return true;
    }

    public E get(E e) {
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            E temp = iterator.next();
            if (((Comparable) temp).compareTo(e) == 0) { //membandingkan dengan e (objek)
                return temp;
            }
        }
        return null;
    }

    public String toString() {
        String temp = "";
        ListIterator<E> iterator = this.listIterator();
        while (iterator.hasNext()) {
            temp = temp + iterator.next() + "\n ";
        }
        return temp;
    }
//    void addSort(Document document) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
}
