package org.example;

public class CentralDeProtocolos {
    private static Integer todosProtocolos = 100;

    public static synchronized String novoProtocolo(){
        todosProtocolos++;
        return "A Thread "+Thread.currentThread().getName()+" incrementou a quantidade de protocolos para "+todosProtocolos;
    }
}
