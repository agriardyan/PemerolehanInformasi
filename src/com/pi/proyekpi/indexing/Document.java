package com.pi.proyekpi.indexing;

public class Document implements Comparable {

    protected String document;
    private int df;

    public Document(){

    }

    public Document(String pDocument) {
        document = pDocument;
    }

    public String getDocument() {
        return document;
    }

    public int compareTo(Object o) {
        return document.compareTo(((Document) o).getDocument());
    }

    public String toString() {
        return document;
    }

    /**
     * @return the df
     */
    public int getDf() {
        return df;
    }

    /**
     * @param df the df to set
     */
    public void setDf(int df) {
        this.df = df;
    }



//    protected String document;
//    protected LinkedListOrderedUnique<documentFrequency> dflist;
//
//    public Document(String pDoc) {
//        document = pDoc;
//    }
//
//    public String getDocument() {
//        return document;
//    }
//
//    public LinkedListOrderedUnique<documentFrequency> getDFlist() {
//        return dflist;
//    }
//
//    public int compareTo(Object o) {
//        return document.compareTo(((Document) o).getDocument());//casting karena tipenya o nya Object yaitu kelas Term
//    }
//
//    @Override
//    public String toString() {
//        String temp = document + " => ";
//        temp = temp + dflist;
//        return temp;
//    }
}
