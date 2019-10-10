/*
 * Carlos Alexandre Peron dos Santos
 *
 * Implemente uma solução para o problema do Jantar dos Filósofos que não resulte em impasse (deadlock).
 */
package exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {
        int quantosFilosofos = 5000;
        
        SemaforoFilosofos semaforo = new SemaforoFilosofos(quantosFilosofos);
        
        Thread filosofos[] = new Thread[quantosFilosofos];
        
        //inicia todos os filosofos juntos querendo o recurso pra ja dar impasse...
        for(int i=0; i<quantosFilosofos; i++){
            filosofos[i] = new Thread(new Filosofo(i, semaforo));
            filosofos[i].start();
        } 
    }
    
}
