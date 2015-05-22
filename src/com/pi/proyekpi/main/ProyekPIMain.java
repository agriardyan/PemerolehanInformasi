/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.proyekpi.main;

import com.pi.proyekpi.indexing.FileDemonstration;
import com.pi.proyekpi.jawabanSoal.JawabanSoal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basisc08
 */
public class ProyekPIMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            FileDemonstration fd = new FileDemonstration();
            fd.analyzePath("");
        } catch (IOException ex) {
            Logger.getLogger(ProyekPIMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("Maaf, kata tidak ditemukan atau terjadi kesalahan, silahkan coba lagi");
        }
        
//        soalNo1();
//        soalNo2();
        
    }
    
    private static void soalNo1() {
        try {
            new JawabanSoal().soalNo1();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyekPIMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(ProyekPIMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void soalNo2() {
        try {
            new JawabanSoal().soalNo2();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyekPIMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void soalNo3() {
        new JawabanSoal().soalNo3();
    }
}
