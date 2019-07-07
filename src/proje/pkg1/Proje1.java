/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg1;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import static java.lang.Math.pow;
import java.util.HashMap;
import java.util.Scanner;


public class Proje1 {

    
    public static void main(String[] args) {
        int[] keyDizi = null;
        int sayi_Kelime=100;
        String[] Kelime_Dizi = new String [sayi_Kelime];
        String kelimeler;
        int topOfHash=211;
        HashMap<Integer , String> hm = new HashMap<>(topOfHash);
        int [] dizi_Ascii= new int[sayi_Kelime];
        Islemler is= new Islemler();
        
         try {
            FileInputStream fstream = new FileInputStream("dosya.txt");
                    
                    
            DataInputStream dstream = new DataInputStream(fstream);
            BufferedReader bRead = new BufferedReader(new InputStreamReader(dstream));
            for (int i = 0; i <= sayi_Kelime; i++) {

                kelimeler = bRead.readLine();
                Kelime_Dizi[i] = kelimeler.toLowerCase();              

            }
            dstream.close();
        } catch (Exception e) {
            System.out.println("");
        }

      
        
        
     
        is.AsciiKarsilik(Kelime_Dizi, sayi_Kelime, dizi_Ascii);
        System.out.println(" KEY    --      KELİME   --    ASCİİ KARSILIGI  -- ");
        is.HashYerlestirme(dizi_Ascii, Kelime_Dizi, sayi_Kelime, hm, topOfHash,keyDizi);
        
    
        
       for(int i=0;i<5;i++){
            System.out.println("Aramak istediginiz kelimeyi giriniz : ");
        Scanner al = new Scanner(System.in);
        String arananKelime=al.next();
      if(is.AramaMetodu(arananKelime, hm, topOfHash)==0) {
      System.out.println("==Kelime bulunamadı fakat benzeri olarak su kelimeler bulundu==  ");
            is.AramaYerDegistirmeli(arananKelime, hm, topOfHash);
            is.AramaHarfCıkarmalı(arananKelime, hm, topOfHash);
          
       }
        
      
    
        
       }
    
      
         
      }
}

    
    
   
    

    
