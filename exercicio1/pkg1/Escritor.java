/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.pkg1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor implements Runnable{
    
    LeitorEscritor leitorEscritor;
    
    public Escritor(LeitorEscritor leitorEscritor){
        this.leitorEscritor = leitorEscritor;
    }
    
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " thread escritor criada");
        leitorEscritor.realizarEscrita((int) Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getId() + " thread escritor finalizada");
    }
}
