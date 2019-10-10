package exercicio2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaforoFilosofos{
    Semaphore semaforos[];
    
    public SemaforoFilosofos(int quantosFilosofos){
        this.semaforos = new Semaphore[quantosFilosofos];
        for(int i=0; i<quantosFilosofos; i++){
            semaforos[i] = new Semaphore(1);
        }

    }
    
    public void pegarGarfos(int idFilosofo){
        int timeout = 2;
        try {
            boolean conseguiu = false;
            while(!conseguiu){
                semaforos[idFilosofo].acquire();
                System.out.println("filosofo " + idFilosofo + " conseguiu o primeiro garfo");
                int qualSemaforo = idFilosofo - 1;
                if(qualSemaforo < 0){
                    qualSemaforo = semaforos.length -1;
                }
            
                if(semaforos[qualSemaforo].tryAcquire(timeout, TimeUnit.SECONDS)){
                    System.out.println("filosofo " + idFilosofo + " conseguiu o segundo garfo");
                    System.out.println("filosofo " + idFilosofo + " 'comendo' por 3 segundos...");
                    Thread.sleep(3000);
                    System.out.println("filosofo " + idFilosofo + " terminou de comer");
                    System.out.println("filosofo " + idFilosofo + " liberando o segundo garfo...");
                    semaforos[qualSemaforo].release();
                    System.out.println("filosofo " + idFilosofo + " liberando o primeiro garfo...");
                    semaforos[idFilosofo].release();
                    conseguiu = true;
                } else {
                    semaforos[idFilosofo].release();
                    System.out.println("filosofo " + idFilosofo + " desistiu de esperar o segundo garfo");
                    Random r = new Random();
                    int x = r.nextInt(4);
                    System.out.println("filosofo " + idFilosofo + " tentando de novo em " + (x+2) + " segundos");
                    Thread.sleep((x + 2) * 1000);
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(SemaforoFilosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
