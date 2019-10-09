/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.pkg1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitor implements Runnable{

    LeitorEscritor leitorEscritor;
    
    public Leitor(LeitorEscritor leitorEscritor){
        this.leitorEscritor = leitorEscritor;
    }
    
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " thread leitor criada");
        leitorEscritor.realizarLeitura((int) Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getId() + " thread leitor finalizada");
    }
    
}
