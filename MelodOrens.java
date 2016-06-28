package teste;
import java.util.Arrays;
import java.util.Scanner;
import jm.JMC;
import jm.music.data.*;
import jm.util.Write;

 // @author lorensov
 
public class MelodOrens implements JMC {
   
    public static int imprimeNotas(int i) {
        int valorNota = 0;
        switch (i){
            case 0: valorNota = 60; System.out.print("C4-"); break;
            case 1: valorNota = 62; System.out.print("D4-");break;
            case 2: valorNota = 64; System.out.print("E4-");break;
            case 3: valorNota = 65; System.out.print("F4-");break;
            case 4: valorNota = 67; System.out.print("G4-");break;
            case 5: valorNota = 69; System.out.print("A4-");break;
            case 6: valorNota = 71; System.out.print("B4-");break; 
            case 7: valorNota = 72; System.out.print("C5-");break;
            }
        return valorNota;
    } 
    
   public static boolean analiseSequencia (int[] notas){
            int contadorSalto = 0;
            int contadorRepetição = 0;
            int contadorMuitasNotas = 0;
            boolean regraTonica = false, regraTerminação = false, regraTrítono = false, regraSaltoGrande = false, regraRepetição = false, regraSalto = false, regraMuitasNotas = false;
     System.out.println("O_O Avaliando a Sequência Musical!!!");
         //if ((notas[0] == notas[notas.length-1]) || (notas[0] == (notas[notas.length-1] - 12))){System.out.println("Regra Tônica: OK"); regraTonica = true;
         if (notas[0] == notas[notas.length-1]){System.out.println("Regra Tônica: OK"); regraTonica = true;
          if (Math.abs(notas[notas.length-2]) - Math.abs(notas[notas.length-1]) <= (2)){ System.out.println("Regra da Terminação: OK"); regraTerminação = true;
                    for (int avaliador = 0; avaliador < (notas.length-1); avaliador++){
                        if ( (Math.abs(notas[avaliador]) - Math.abs(notas[avaliador+1])) != (6)){ System.out.println("Sem trítono: OK"); regraTrítono = true;
                         if ( (Math.abs(notas[avaliador]) - Math.abs(notas[avaliador+1])) <= (7)){ System.out.println("Sem saltos grandes: OK"); regraSaltoGrande = true;
                          if ((Math.abs(notas[avaliador])) == (Math.abs(notas[avaliador+1]))){contadorRepetição++; 
                            if ((Math.abs(notas[avaliador]) - Math.abs(notas[avaliador+1])) >= (3)){contadorSalto++;}
                          }
                         }else{System.out.println("A Sequência possui muitos saltos grandes!");return false;}
                        }else{System.out.println("A Sequência possui Trítono como salto!");return false;}
                    }
          }else{System.out.println("A Sequência possui Terminação Incorreta!");return false;}
         }else{System.out.println("A Sequência possui erro com Tônica!");return false;}
                if (contadorRepetição <= (2)){ System.out.println("Sem repetições: OK"); regraRepetição = true;}else{System.out.println("A Sequência possui muitas repetições!");return false;}
                if (contadorSalto <= (2)){System.out.println("Sem salto excessivo: OK"); regraSalto = true;}else{System.out.println("A Sequência possui saltos excessivos!");return false;}
                
            for (int a=0; a < notas.length-1; a++){for(int b=0; b < notas.length-1; b++){if (notas[a] == notas[b]){contadorMuitasNotas++;}}}
            if (contadorMuitasNotas <= (notas.length+4)){regraMuitasNotas = true;}else{System.out.println("A Sequência possui muitas notas iguais!");}
            
   if ((regraTonica && regraTerminação && regraTrítono && regraSaltoGrande && regraRepetição && regraSalto && regraMuitasNotas) == true){System.out.println("Tudo está OK!"); return true;}
      return false;          
   }
   
    public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
                
        System.out.println("Quantas notas podemos usar?");
        //int quantidadeNotas = sc.nextInt(); //caso o programa fique dinamico, descomentar esta linha e comentar a proxima
        int quantidadeNotas = 7;

        System.out.println("Quantos compassos que tem?");
        //int quantidadeCompasso = sc.nextInt();
        int quantidadeCompasso = 6;
        int deucerto = 0;
        int [] notas = new int [quantidadeCompasso];
        //int possibilidades = quantidadeNotas * quantidadeCompasso;
        double possibilidades = Math.pow(quantidadeNotas, quantidadeCompasso);
        System.out.println("Existe um máximo de "+possibilidades+" possibilidades :D");
        
       //Rest pausa = new Rest(0.2);
       Phrase frase = new Phrase();
       Score partitura = new Score("cantusfirmus");
       Part parte = new Part("Choral", OOH, 1);
       System.out.println("CRIAÇÃO DE FORÇA BRUTA!");
        int i,j,k,l,m,n,o,p,q,r,s,t,ciclo = 0;
        for (i=0;i<=quantidadeNotas;i++){
         for (j=0;j<=quantidadeNotas;j++){
          for (k=0;k<=quantidadeNotas;k++){
           for(l=0;l<=quantidadeNotas;l++){
            for(m=0;m<=quantidadeNotas;m++){
             for(n=0;n<=quantidadeNotas;n++){
              /**for(o=0;o<=quantidadeNotas;o++){ //i had a problem with recursive functions :/
               for(p=0;p<=quantidadeNotas;p++){
                for(q=0;q<=quantidadeNotas;q++){
                 for(r=0;r<=quantidadeNotas;r++){
                  for(s=0;s<=quantidadeNotas;s++){
                   for(t=0;t<=quantidadeNotas;t++){*/
              notas[0] = imprimeNotas(i);
              notas[1] = imprimeNotas(j); 
              notas[2] = imprimeNotas(k);
              notas[3] = imprimeNotas(l);
              notas[4] = imprimeNotas(m);
              notas[5] = imprimeNotas(n);
              /**notas[6] = imprimeNotas(o);
              notas[7] = imprimeNotas(p);
              notas[8] = imprimeNotas(q);
              notas[9] = imprimeNotas(r);
              notas[10] = imprimeNotas(s);
              notas[11] = imprimeNotas(t);*/
              ciclo++;
            System.out.println();
            System.out.println("O valor sensual das notas é:"+Arrays.toString(notas));
            System.out.println();          
            
      if (analiseSequencia(notas) == true){
         System.out.println("Adicionando valor correto!");
                frase.addNoteList(notas, 0.5, F);
         //       frase.addRest(pausa);
                frase.setPan(PAN_CENTRE);
                parte.addPhrase(frase);
                partitura.addPart(parte);
                Write.midi(partitura,"cantifirmi_"+ciclo+"_.mid");
                System.out.println("Valor correto adicionado!");
                deucerto++;
         System.out.println();} else{
             System.out.println("++++++++++");
             System.out.println("A sequência não está conforme as regras! :( ");
             System.out.println("++++++++++");}
         
          System.out.println("Limpando memória...");
          partitura.removeAllParts();
                parte.removeAllPhrases();
                while (frase.getSize() > 0){frase.removeLastNote();}
                System.out.println("Limpeza Concluída!");
                System.out.println();
                System.out.print("_*¬*_");
                System.out.println();
                  /** }
                  }
                 }
                }
               }
              }*/
             }
            }
           }
          }
         }
        }
       
        //if (avaliacao == true){
        System.out.println("WOOOW!!! O programa fez "+ciclo+" tentativas!");
        System.out.println("E DE TODAS... "+deucerto+" DERAM DELAS CERTO!");
                System.out.println("(͡°͜ʖ͡°)");
                System.out.println("lorensov qualified code!");
                System.out.println("(͡°͜ʖ͡°)");
 }
}
