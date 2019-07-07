package proje.pkg1;


import static java.lang.Math.pow;
import java.util.HashMap;


public class Islemler {
    
    
    public void AsciiKarsilik(String[] Kelime_Dizi, int sayi_Kelime,int [] dizi_Ascii){
        
        char harfler;
        int harfinAsciisi;
        for (int i=0;i<sayi_Kelime;i++){
            String words = Kelime_Dizi[i];
            int toplam=0;

            for(int j=0;j<words.length();j++){
                harfler=words.charAt(j);
                harfinAsciisi=(int) harfler;            
                toplam=toplam + harfinAsciisi*(j+1);
                dizi_Ascii[i]=toplam;
    }
    }
    }
    
    public void HashYerlestirme(int[] dizi_Ascii, String[] Kelime_Dizi, int sayi_Kelime,HashMap<Integer,String> hm ,int topOfHash,int [] keyDizi){
        
        
        int anahtar_degeri;
    
         for(int j=0; j<sayi_Kelime;j++) {

            for (int i = 0; i <topOfHash; i++) {
                anahtar_degeri = (int) ((dizi_Ascii[j] + pow(i, 2)) % topOfHash);         
                if (hm.containsKey(anahtar_degeri) == false) {                              
                    hm.put(anahtar_degeri, Kelime_Dizi[j]);
                   yazdırma(anahtar_degeri,Kelime_Dizi[j],dizi_Ascii[j]);
                
                    break;

                }
            }
         }
    }
    
    public int AramaMetodu(String arananKelime,HashMap<Integer,String> hm,int topOfHash){
        int toplam=0;
        char harf;
        int harfAscii;
        for(int j=0;j<arananKelime.length();j++){
            harf=arananKelime.charAt(j);
            harfAscii=(int) harf;
            toplam=toplam + harfAscii*(j+1);
            
           
        }
        int sayac=0;
   
        int anahtar_degeri;
         for (int i = 0; i <topOfHash; i++) {
            anahtar_degeri = (int) ((toplam + pow(i, 2)) % topOfHash);             

                if (arananKelime.equals(hm.get(anahtar_degeri))==true){                  
                System.out.println("kelime bulundu ===" + "  " + arananKelime);
               sayac++;
               break;

            }
                if(arananKelime.equals(hm.get(anahtar_degeri))==false){
                    break;
                }
               
        
        
    }
        return sayac;
    }
    
    public void AramaYerDegistirmeli(String arananKelime,HashMap<Integer,String> hm,int topOfHash){
        
         char[] YeniArananKelime;

       YeniArananKelime=arananKelime.toCharArray();  


        char gecici;   
        
         for(int i=0;i<arananKelime.length()-1;i++){

              gecici=YeniArananKelime[i];
              YeniArananKelime[i]=YeniArananKelime[i+1];
              YeniArananKelime[i+1]=gecici;
              arananKelime=String.valueOf(YeniArananKelime);
              
              AramaMetodu(arananKelime, hm, topOfHash);
              
              gecici=YeniArananKelime[i];
             YeniArananKelime[i]=YeniArananKelime[i+1];
              YeniArananKelime[i+1]=gecici;
              arananKelime=String.valueOf(YeniArananKelime);
    }
         
    
    
        
        
    }
    
    public void AramaHarfCıkarmalı(String arananKelime,HashMap<Integer,String> hm,int topOfHash){
        
      char [] kelime;
      char[] cıkarılanKelime=new char[arananKelime.length()-1];
      
      for(int i=0;i<arananKelime.length();i++){
          kelime=arananKelime.toCharArray();
          for(int j=i;j<arananKelime.length()-1;j++){
              kelime[j]=kelime[j+1];
          }
          for(int z=0;z<arananKelime.length()-1;z++){
              
              cıkarılanKelime[z]=kelime[z];
          }
          
          
       AramaMetodu(String.copyValueOf(cıkarılanKelime) , hm, topOfHash);
          
      }
        
    }
    
 

    private void yazdırma(int anahtar_degeri, String kelime, int Ascii) {
         
           System.out.println(anahtar_degeri+"              "+kelime+"              "+Ascii );
       
    }
}
    

