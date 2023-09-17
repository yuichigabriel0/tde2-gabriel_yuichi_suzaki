//GABRIEL YUICHI SUZAKI
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hanoi h = new Hanoi();
        System.out.println("==========( D E C R E S C E N T E ? )==========");
        System.out.println("==( Y = 1/ N = 0 )==");
        System.out.println("==( jogo automatico não possui modo reverso.)==");

        int reverso = scanner.nextInt();
        System.out.println("==========( T A M A N H O  D A S  P I L H A S )==========");
        int tamanho = scanner.nextInt();


        Pilha p1 = new Pilha(tamanho, 1);
        Pilha p2 = new Pilha(tamanho, 2);
        Pilha p3 = new Pilha(tamanho, 3);
        h.preencherAleatorio(p1, tamanho);
        p1.imprime();
        System.out.println("==========( M O D O  D E  J O G O )==========");
        System.out.println("==========( modo manual = 1, modo automatico = 2, 0 para sair. )==========");
        int modo = scanner.nextInt();
        if(modo == 1){
            System.out.println(" modo manual");
            h.hanoiJogoManual(reverso,h,scanner,p1,p2,p3);
        }
        if(modo == 2){
            System.out.println(" modo automatico");
            h.hanoiTrocaAutomatico(tamanho,p1,p2,p3,h);
        }
        else{
            return;
        }

        scanner.close();
    }
}
