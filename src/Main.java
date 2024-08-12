public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(72);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(37);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(12);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        System.out.println("## Remoção do nó raiz ##");
        System.out.println("## Removendo raiz 80");
        arvoreBinaria.delete(80);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        System.out.println("## Remoção de nós folhas ##");
        System.out.println("## Removendo nó 12 ");
        arvoreBinaria.delete(12);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        System.out.println("## Remoção de nós que possuem apenas um filho ##");
        System.out.println("## Removendo nó 72 ##");
        arvoreBinaria.delete(72);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        System.out.println("## Inserir nó 38 para o nó 37 ficar com dois filhos ##");
        System.out.println("## Inserindo nó 38 ##");
        arvoreBinaria.inserir(38);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        System.out.println("## Remoção de nós que possuem os dois filhos ##");
        System.out.println("## Removendo nó 37");
        arvoreBinaria.delete(37);
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

    }
}
