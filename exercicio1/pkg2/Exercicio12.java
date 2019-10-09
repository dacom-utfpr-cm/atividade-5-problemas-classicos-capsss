/*
 * Carlos Alexandre Peron dos Santos
 *
 * Implemente e teste duas soluções para o problema dos Leitores-Escritores usando semárofos ou monitores que:
 * priorize os escritores.
 */
package exercicio1.pkg2;

import java.util.concurrent.Semaphore;

public class Exercicio12 {

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
        
        //iniciando um leitor
        t = new Thread(new Leitor(leitorEscritor));
        t.start();
        
        //iniciando um escritor
        t = new Thread(new Escritor(leitorEscritor));
        t.start();
        
        //iniciando outro leitor
        t = new Thread(new Leitor(leitorEscritor));
        t.start();
        
        //iniciando 20 leitores e 10 escritores
        for(int i=0; i<30; i++){
            if(i%3 == 0){
                t = new Thread(new Escritor(leitorEscritor));
                t.start();
            } else {
                t = new Thread(new Leitor(leitorEscritor));
                t.start();
            }
        }
    }
    
}
