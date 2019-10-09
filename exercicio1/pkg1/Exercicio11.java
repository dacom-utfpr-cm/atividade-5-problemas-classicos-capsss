/*
 * Carlos Alexandre Peron dos Santos
 *
 * Implemente e teste duas soluções para o problema dos Leitores-Escritores usando semárofos ou monitores que:
 * não cause inanição (starvation) de leitores ou escritores.
 */
package exercicio1.pkg1;

import java.util.concurrent.Semaphore;

public class Exercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semaforoLeitor = new Semaphore(1);
        Semaphore semaforoEscritor = new Semaphore(1);
        Semaphore semaforoLeitorQuantidade = new Semaphore(1);
        Semaphore semaforoEscritorQuantidade = new Semaphore(1);
        LeitorEscritor leitorEscritor = new LeitorEscritor(semaforoLeitor, semaforoEscritor, semaforoLeitorQuantidade, semaforoEscritorQuantidade);
        
        Thread t;
        
        //iniciando 1 leitor
        t = new Thread(new Leitor(leitorEscritor));
        t.start();
        
        //iniciando 1 escritor
        t = new Thread(new Escritor(leitorEscritor));
        t.start();
        
        //iniciando 50 leitores
        for(int i=0; i<50; i++){
            t = new Thread(new Leitor(leitorEscritor));
            t.start();
        }
        
        //iniciando 50 escritores
        for(int i=0; i<50; i++){
            t = new Thread(new Escritor(leitorEscritor));
            t.start();
        }
        
        //iniciando 10 leitores
        for(int i=0; i<10; i++){
            t = new Thread(new Leitor(leitorEscritor));
            t.start();
        }
    }
    
}
