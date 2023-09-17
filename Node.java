//CLASSE NODE
public class Node {
    private Integer info;
    private Node prox;

    public Node()
    {
        this.info = null;
        this.prox = null;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Integer getInfo() {
        return info;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    public Node getProx() {
        return prox;
    }
}
//CLASSE PILHA
class Pilha {
    private Node comeco;
    private Integer tamanho;
    private Integer id;
    private Integer tamanhoAtual;
    public Pilha(Integer valor,Integer id) {
        tamanho = valor;
        comeco = null;
        tamanhoAtual = 0;
        this.id = id;
    }

    public void adicionar(Integer info) {
        if(tamanhoAtual < tamanho){
        Node No = new Node();
        No.setInfo(info);

        if (comeco == null) {
            comeco = No;
            tamanhoAtual +=1;
        } else {
            No.setProx(comeco);
            comeco = No;
            tamanhoAtual+=1;
        }}
        else{
            System.out.println("Pilha cheia");
        }
    }

    public void remover() {
        if (comeco == null) {
            System.out.println("pilha vazia");
        } else {
            comeco = comeco.getProx();
            tamanhoAtual -=1;
        }
    }
    public Node getComeco(){
            return comeco;
    }
    public Boolean verificaVazio(){
        if(tamanhoAtual == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean verificaCheio(){
        if(tamanhoAtual == tamanho){
            return true;
        }
        else {
            return false;
        }
    }

    public void imprime(){
        Node atual = comeco;
        while (atual != null) {
            System.out.print(atual.getInfo()+ " -> ");
            atual= atual.getProx();
            if(atual == comeco){
                break;
            }
        }
        System.out.println("id:" + id);
    }
    }

