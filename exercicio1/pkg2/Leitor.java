/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.pkg2;

public class Leitor implements Runnable{

    LeitorEscritor leitorEscritor;
    
    public Leitor(LeitorEscritor leitorEscritor){
        this.leitorEscritor = leitorEscritor;
    }
    
    
    @Override
    public void run() {
        leitorEscritor.realizarLeitura((int) Thread.currentThread().getId());
    }
    
}
