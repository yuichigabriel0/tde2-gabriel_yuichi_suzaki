import java.util.Random;
import java.util.Scanner;

public class Hanoi {
    private int contador = 0;

    public Pilha escolherPilha(int id, Pilha p1, Pilha p2, Pilha p3){
        if(id == 1){
            return p1;
        }
        if(id == 2){
            return p2;
        }
        if(id == 3 ){
            return p3;
        }
        else {
            System.out.println("numero invalido, colocando 1");
            return p1;
        }
    }
    public void HanoiTroca(int reverso,Pilha origem,Pilha destino){
        if(reverso == 1) {
            if (origem.verificaVazio()) {
                System.out.println("pilha vazia");
                return;
            }
            if (destino.verificaVazio() || origem.getComeco().getInfo() > destino.getComeco().getInfo()) {
                destino.adicionar(origem.getComeco().getInfo());
                origem.remover();
                contador += 1;
            } else if (destino.verificaVazio() || origem.getComeco().getInfo() == destino.getComeco().getInfo()) {
                destino.adicionar(origem.getComeco().getInfo());
                origem.remover();
                contador += 1;
            } else {
                System.out.println("Erro, numero menor");
            }
        }
        else {
            if (origem.verificaVazio()) {
                System.out.println("pilha vazia");
                return;
            }
            if (destino.verificaVazio() || origem.getComeco().getInfo() < destino.getComeco().getInfo()) {
                destino.adicionar(origem.getComeco().getInfo());
                origem.remover();
                contador += 1;
            } else if (destino.verificaVazio() || origem.getComeco().getInfo() == destino.getComeco().getInfo()) {
                destino.adicionar(origem.getComeco().getInfo());
                origem.remover();
                contador += 1;
            } else {
                System.out.println("Erro, numero maior");
            }
        }

    }
    public boolean Hanoiverifica(int Reverso,Pilha pilha) {
        if(Reverso == 1){
            Node atual = pilha.getComeco();
            Node proximo = atual.getProx();

            while (proximo != null) {
                if(atual.getInfo() == proximo.getInfo()){
                    break;
                }
                else if (atual.getInfo() <= proximo.getInfo()) {
                    System.out.println("fora de ordem");
                    return false;
                }
                atual = proximo;
                proximo = proximo.getProx();
            }
            if(pilha.verificaCheio()){
                System.out.println("ordenado!");
                return true;
            }
            else {
                return false;
            }
        }
        else {
            Node atual = pilha.getComeco();
            Node proximo = atual.getProx();

            while (proximo != null) {
                if(atual.getInfo() == proximo.getInfo()){
                    break;
                }
                else if (atual.getInfo() >= proximo.getInfo()) {
                    System.out.println("fora de ordem");
                    return false;
                }
                atual = proximo;
                proximo = proximo.getProx();
            }
            if(pilha.verificaCheio()){
                System.out.println("ordenado!");
                return true;
            }
            else {
                return false;
            }
        }
    }
    public Integer getContador(){
        return contador;
    }

    public Pilha preencherAleatorio(Pilha p1,Integer x){

        Random random = new Random();
        for (int i = 0; i < x; i++) {
            int randomInt;
            randomInt = random.nextInt(100) + 1;
            p1.adicionar(randomInt);

        }
        return p1;
    }

    public void hanoiTrocaAutomatico(int tamanho, Pilha origem, Pilha destino, Pilha auxiliar, Hanoi h) {
        int reverso = 0;
        if (tamanho > 0) {
            hanoiTrocaAutomatico(tamanho - 1, origem, auxiliar, destino, h);

            if (destino.getComeco() == null || (origem.getComeco() != null && origem.getComeco().getInfo() <= destino.getComeco().getInfo())) {

                System.out.println("origem destino1");
                h.HanoiTroca(reverso, origem, destino);

            }
            else if (destino.getComeco() == null || (origem.getComeco() != null && origem.getComeco().getInfo() >= destino.getComeco().getInfo())) {
                System.out.println("origem destino2");
                h.HanoiTroca(reverso, auxiliar, destino);
            }
            else {
                System.out.println("origem auxiliar");
                h.HanoiTroca(reverso, auxiliar, destino);
            }
            System.out.println("======( J O G O  A U T O M Á T I C O )======");
            if(origem.getComeco() != null){
                h.Hanoiverifica(reverso,origem);

            }
            if(destino.getComeco() != null){
                h.Hanoiverifica(reverso,destino);
            }
            if(auxiliar.getComeco() != null){
                h.Hanoiverifica(reverso,auxiliar);
            }

            origem.imprime();
            destino.imprime();
            auxiliar.imprime();

            System.out.println("======X=X=X======");
            hanoiTrocaAutomatico(tamanho - 1, auxiliar, destino, origem, h);
        } else {
            System.out.println("Total de movimentos: " + h.getContador());
        }
    }


    public void hanoiJogoManual(int reverso,Hanoi h, Scanner scanner,Pilha p1, Pilha p2, Pilha p3){
        while(true) {
            if(reverso == 1){
                System.out.println("JOGO INVERTIDO");
            }
            else {
                System.out.println("JOGO NORMAL");
            }
            System.out.println("==========( I N I C I A N D O )==========");
            p1.imprime();
            p2.imprime();
            p3.imprime();
            System.out.println("==========( T R O C A R )==========");
            System.out.println("escolha 1: ORIGEM ");
            int escolha1 = scanner.nextInt();
            System.out.println("escolha 2: DESTINO ");
            int escolha2 = scanner.nextInt();

            h.HanoiTroca(reverso,h.escolherPilha(escolha1, p1, p2, p3), h.escolherPilha(escolha2, p1, p2, p3));
            System.out.println("==========x=x=x==========");
            p1.imprime();
            p2.imprime();
            p3.imprime();
            System.out.println("==========( V E R I F I C A N D O )==========");
            if (p3.getComeco() != null) {
                System.out.println("verificando pilha 3");
                if(h.Hanoiverifica(reverso,p3)){
                    break;
                }
            }
            if (p2.getComeco() != null) {
                System.out.println("verificando pilha 2");
                if(h.Hanoiverifica(reverso,p2)){
                    break;
                }
            }
        }

        System.out.println("==========( F I M  D E  J O G O  )==========");
        System.out.println("Quantidade de movimentos:" + h.getContador());
    }
}




