/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.pkg1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeitorEscritor {
    Semaphore semaforoLeitor;
    Semaphore semaforoEscritor;
    Semaphore semaforoLeitorQuantidade;
    Semaphore semaforoEscritorQuantidade;
    int quantidadeLeitores;
    int quantidadeEscritores;
    int valor;
    
    public LeitorEscritor(  Semaphore semaforoLeitor,
                            Semaphore semaforoEscritor,
                            Semaphore semaforoLeitorQuantidade,
                            Semaphore semaforoEscritorQuantidade){
        
        this.semaforoLeitor = semaforoLeitor;
        this.semaforoEscritor = semaforoEscritor;
        this.semaforoLeitorQuantidade = semaforoLeitorQuantidade;
        this.semaforoEscritorQuantidade = semaforoEscritorQuantidade;
        this.quantidadeLeitores = 0;
        this.quantidadeEscritores = 0;
        this.valor = 0;
    }
    
    public synchronized void realizarLeitura(int id){
        try {
            semaforoLeitor.acquire();
            semaforoLeitorQuantidade.acquire();
            this.quantidadeLeitores++;
            if(this.quantidadeLeitores == 1){
                semaforoEscritor.acquire();
            }
            semaforoLeitorQuantidade.release();
            semaforoLeitor.release();
            
            System.out.println(id + " thread leu: " + this.valor);
            
            semaforoLeitorQuantidade.acquire();
            this.quantidadeLeitores--;
            if(this.quantidadeLeitores == 0){
                semaforoEscritor.release();
            }
            semaforoLeitorQuantidade.release();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(LeitorEscritor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public synchronized void realizarEscrita(int id){
        try {
            semaforoEscritorQuantidade.acquire();
            this.quantidadeEscritores++;
            if(this.quantidadeEscritores == 1){
                semaforoLeitor.acquire();
            }
            semaforoEscritorQuantidade.release();
            semaforoEscritor.acquire();
            
            System.out.println(id + " thread escreveu: " + ++this.valor);
            
            semaforoEscritor.release();
            semaforoEscritorQuantidade.acquire();
            this.quantidadeEscritores--;
            if(this.quantidadeEscritores == 0){
                semaforoLeitor.release();
            }
            semaforoEscritorQuantidade.release();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(LeitorEscritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}