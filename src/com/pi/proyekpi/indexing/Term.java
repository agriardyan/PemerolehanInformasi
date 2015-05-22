//id.ac.usd.ti.winda.ir
package com.pi.proyekpi.indexing;

public class Term implements Comparable {

    private String term;
    protected LinkedListOrderedUnique<Document> postinglist; //tipenya apa

//    protected LinkedListOrderedUnique<

    public Term(){

    }

    public Term(String pTerm) {
        term = pTerm;
    }

    public String getTerm() {
        return term;
    }

    public LinkedListOrderedUnique<Document> getPostinglist() {
        return postinglist;
    }

//    public LinkedListOrderedUnique<Document> getPostinglist() {
//        return postinglist;
//    }

    public int compareTo(Object o) {
        return term.compareTo(((Term) o).getTerm());//casting karena tipenya o nya Object yaitu kelas Term
    }

    @Override
    public String toString() {
        String temp = term + " => ";
        temp = temp + postinglist.toString();
        return temp;
    }
}
