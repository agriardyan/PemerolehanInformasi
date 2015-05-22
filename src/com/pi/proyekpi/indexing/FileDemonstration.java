// Fig. 14.4: FileDemonstration.java
// Demonstrating the File class.
package com.pi.proyekpi.indexing;

//import cekFile.searchSentence;
//import tokenizer.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDemonstration {

    private Scanner input;
    // display information about file user specifies

    public FileDemonstration() {
    }

    public void analyzePath(String path) throws IOException {
//        try {
        File name = new File("./Koleksi");
        InvertedIndexBasic coba = new InvertedIndexBasic();
        InvertedIndexBasic coba2 = new InvertedIndexBasic();
        if (name.exists()) {
            if (name.isDirectory()) {
                String[] fileNameList = name.list();
//                System.out.println("\n\nDirectory contents:\n");
                for (String file : fileNameList) {
//                    System.out.printf("%s\n", directoryName);
                    try // read records from file using Scanner object
                    {
                        input = new Scanner(new File(name.getAbsolutePath() + "\\" + file));

//                        System.err.println("\nIsi dari file " + file+" :");

                        while (input.hasNext()) {
                            String sentence = input.nextLine();
//                            System.err.println(sentence);
                            
                            StringTokenizer token = new StringTokenizer(sentence);
                            while (token.hasMoreTokens()) {

//                                int df = 1;
                                String tk = token.nextToken();
                                coba.add(tk, file);
                                coba2.addNonUnique(tk, file);
                                // System.out.println(token.nextToken());
                            } // end main
                            // end main
                        } // end while
                        
                        // end while
                    } // end try
                    catch (FileNotFoundException e) {
                        Logger.getLogger(FileDemonstration.class.getName()).log(Level.SEVERE, null, e);
                    } catch (NoSuchElementException elementException) {
                        System.err.println("File improperly formed.");
                        input.close();
                        System.exit(1);
                    } // end catch
                    // end catch
                    catch (IllegalStateException stateException) {
                        System.err.println("Error reading from file.");
                        System.exit(1);
                    } // end catch
                    // end catch
                } // end method readRecords
                // end method readRecords
            } else {
                // not file or directory, output error message
                System.out.printf("%s %s", path, "does not exist.");
            }
        } // end class FileDemonstration
//        coba.printInvertedIndexBasic();
        coba2.wordCount();


        System.out.print("\nMasukan 1 kata : ");
        Scanner cari = new Scanner(System.in);
        coba.printSearch(cari.nextLine());

        Scanner scan = new Scanner(System.in);
        System.out.println("\n(OR)Masukan 2 kata (Pisahkan dengan spasi) : ");
        String cari2 = scan.nextLine();
        LinkedList list = new LinkedList();
        StringTokenizer token2 = new StringTokenizer(cari2);
        String test = coba.printSearch2(token2.nextToken());
        StringTokenizer token3 = new StringTokenizer(test, " .,-'[]{}/|@#!$%^&*_-+=?<>:;()txt");
        while (token3.hasMoreTokens()) {
            list.add(token3.nextToken());
        }
        while (token2.hasMoreTokens()) {
            String test2 = coba.printSearch2(token2.nextToken());
            StringTokenizer token4 = new StringTokenizer(test2, " .,-'[]{}/|@#!$%^&*_-+=?<>:;()txt");
            while (token4.hasMoreTokens()) {
                String abc = token4.nextToken().toString();
                list.add(abc);
                new InvertedIndexBasic().duplikasiList(list);
            }

        }

        System.out.print(list.toString());
        
        Scanner scan2 = new Scanner(System.in);
        System.out.println("\n(AND) Masukan 2 kata (pisahkah dengan spasi) :");
        String cari3 = scan2.nextLine();
        LinkedList list2 = new LinkedList();
        StringTokenizer token4 = new StringTokenizer(cari3);
        String test2 = coba.printSearch2(token4.nextToken());
        StringTokenizer token5 = new StringTokenizer(test2, " .,-'[]{}/|@#!$%^&*_-+=?<>:;()txt");
        while (token5.hasMoreTokens()) {
            list2.add(token5.nextToken());
        }
        
        while (token4.hasMoreTokens()) {
            String test3 = coba.printSearch2(token4.nextToken());
            StringTokenizer token6 = new StringTokenizer(test3, " .,-'[]{}/|@#!$%^&*_-+=?<>:;()txt");
            while (token6.hasMoreTokens()) {
                String hasil = token6.nextToken().toString();
                list2.add(hasil);
            }
        }
        
        new InvertedIndexBasic().check(list2);
    }
}
