package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService workers = Executors.newFixedThreadPool(3);
        List<Future<String>> respostasDasAtividades = new ArrayList<>();

        for(int i =1;i<=8;i++){

            Future<String> respostaDaAtividade = workers.submit(() ->{
               return CentralDeProtocolos.novoProtocolo();
            });

            respostasDasAtividades.add(respostaDaAtividade);
        }

        for(Future<String> i:respostasDasAtividades){
            try {
                String respostaDesemcapsulada = i.get();
                System.out.println(respostaDesemcapsulada);
            }catch (ExecutionException e){
                System.out.println("A atividade foi interrompida! "+e.getCause().getMessage());
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        workers.shutdown();

    }
}