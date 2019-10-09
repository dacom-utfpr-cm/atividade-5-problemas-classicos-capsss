/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.pkg2;

public class Escritor implements Runnable{
    
    LeitorEscritor leitorEscritor;
    
    public Escritor(LeitorEscritor leitorEscritor){
        this.leitorEscritor = leitorEscritor;
    }
    
    
    @Override
    public void run() {
        leitorEscritor.realizarEscrita((int) Thread.currentThread().getId());
    }
}
