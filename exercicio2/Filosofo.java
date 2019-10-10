package exercicio2;

public class Filosofo implements Runnable{
    SemaforoFilosofos semaforo;
    int idFilosofo;
    
    public Filosofo(int idFilosofo, SemaforoFilosofos semaforo){
        this.idFilosofo = idFilosofo;
        this.semaforo = semaforo;
    }
    
    @Override
    public void run() {
        semaforo.pegarGarfos(idFilosofo);
    }
        
}
