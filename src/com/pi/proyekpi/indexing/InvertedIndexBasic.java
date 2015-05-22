package com.pi.proyekpi.indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InvertedIndexBasic {

    private LinkedListOrderedUnique<Term> termList;

    public InvertedIndexBasic() {
        termList = new LinkedListOrderedUnique<Term>();

    }

    public LinkedListOrderedUnique<Term> getTermList() {
        return termList;
    }

    //untuk add dibutuhkan 2 informasi yaitu term dan doc nya
//    public void add(String pTerm, String pDocument, Term index) {
    public void add(String pTerm, String pDocument) {
        //cari term dalam termList

        Term vTerm = termList.get(new Term(pTerm));

        if (vTerm == null) {//jika tidak ditemukan maka buat objek baru
            Term oTerm = new Term(pTerm);
            oTerm.postinglist = new LinkedListOrderedUnique<Document>();//ini baru panah nya saja
            oTerm.postinglist.addSort(new Document(pDocument)); //tambah simpul
            termList.add(oTerm);
        } else {

            vTerm.getPostinglist().addSort(new Document(pDocument));

        }
    }
    
    public void addNonUnique(String pTerm, String pDocument) {
        //cari term dalam termList

        Term vTerm = termList.get(new Term(pTerm));

        if (vTerm == null) {//jika tidak ditemukan maka buat objek baru
            Term oTerm = new Term(pTerm);
            oTerm.postinglist = new LinkedListOrderedUnique<Document>();//ini baru panah nya saja
            oTerm.postinglist.addSortNonUnique(new Document(pDocument)); //tambah simpul
            termList.add(oTerm);
        } else {

            vTerm.getPostinglist().addSort(new Document(pDocument));

        }
    }

    public void printInvertedIndexBasic() {
        ListIterator<Term> iterator = termList.listIterator();
        System.err.println("postinglist : -------------");
        while (iterator.hasNext()) {
            Term vTerm = iterator.next();
//            System.out.print(vTerm.getTerm() + " => ");


            ListIterator<Document> iterator2 = vTerm.postinglist.listIterator();
//            documentFrequency pDF = new documentFrequency();

            while (iterator2.hasNext()) {
                Document pDoc = iterator2.next();
                System.out.print(" " + vTerm.getPostinglist().get(pDoc));
//
//                System.out.println(" df : " + vTerm.getPostinglist().get(pDoc).getDf());
            }
            System.out.println("");
        }
    }
    
    public void wordCount() {
        ListIterator<Term> iterator = termList.listIterator();
        System.err.println("word count : -------------");
        while (iterator.hasNext()) {
            Term vTerm = iterator.next();
            System.out.print(vTerm.getTerm() + " => ");

            ListIterator<Document> iterator2 = vTerm.postinglist.listIterator();
//            documentFrequency pDF = new documentFrequency();

            while (iterator2.hasNext()) {
                Document pDoc = iterator2.next();
                System.out.print(" " + vTerm.getPostinglist().get(pDoc));
//
//                System.out.println(" df : " + vTerm.getPostinglist().get(pDoc).getDf());
            }
            System.out.println("");
        }
    }

    public String printSearch(String cari) throws NullPointerException {
        LinkedList list = new LinkedList();
        Term vTerm = termList.get(new Term(cari));
        System.out.print(vTerm.getTerm() + " => ");
        ListIterator<Document> iterator2 = vTerm.getPostinglist().listIterator();
        while (iterator2.hasNext()) {
            Document vDocument = iterator2.next();
            System.out.print(vDocument.getDocument() + " ");
            list.add(vDocument.getDocument());


        }
        return list.toString();
    }

    public String printSearch2(String cari) throws NullPointerException {
         Term vTerm = termList.get(new Term(cari.toLowerCase()));
//        System.out.print(vTerm.getTerm() + " => ");
        System.out.println("");
        LinkedList list = new LinkedList();
        ListIterator<Document> iterator2 = vTerm.getPostinglist().listIterator();
        while (iterator2.hasNext()) {
            Document vDoc = iterator2.next();
//            System.out.print(vDoc.getDocument() + " ");
            list.add(vDoc.getDocument());
        }
//        System.out.println(list.toString());
        System.out.println("");
        return list.toString();
    }

    public void duplikasiList(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String currentItem = list.get(i);
            while (list.lastIndexOf(currentItem) != i) {
                list.removeLastOccurrence(currentItem);
            }
        }
    }

    public void check(LinkedList<String> list) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            String currentItem = list.get(i);
            if (list.lastIndexOf(currentItem) != i) {
                l.add(list.get(i));
            }
        }
        System.out.println(l);
    }

   

    @Override
    public String toString() {
        return termList.toString();
    }
}
