public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }
    public boolean delete(int chave){
        No atual = raiz;
        No pai = raiz;
        boolean temFilhoEsq = true;
        while(atual.getValor() != chave){
            pai = atual;
            if(chave < atual.getValor()){
                temFilhoEsq = true;
                atual = atual.getEsq();
            }else{
                temFilhoEsq = false;
                atual = atual.getDir();
            }
            if(atual==null)
                return false;
        }
        if(atual.getEsq() == null &&
                atual.getDir() == null){
            if(atual == raiz)
                raiz = null;
            else if(temFilhoEsq)
                pai.setEsq(null);
            else
                pai.setDir(null);
        }else if(atual.getDir()==null)
            if(atual == raiz)
                raiz = atual.getEsq();
            else if(temFilhoEsq)
                pai.setEsq(atual.getEsq());
            else
                pai.setDir(atual.getDir());
        else if(atual.getEsq()==null)
            if(atual == raiz)
                raiz = atual.getDir();
            else if(temFilhoEsq)
                pai.setEsq(atual.getDir());
            else
                pai.setDir(atual.getDir());
        else{//two children
            No successor = getSuccessor(atual);
            if(atual == raiz)
                raiz = successor;
            else if(temFilhoEsq)
                pai.setEsq(successor);
            else
                pai.setDir(successor);
            successor.setEsq(atual.getEsq());
        }
        return true;
    }

    private No getSuccessor(No delNo){
        No successorPai = delNo;
        No successor = delNo;
        No atual = delNo.getDir();
        while(atual != null){
            successorPai = successor;
            successor = atual;
            atual = atual.getEsq();
        }
        if(successor != delNo.getDir()){
            successorPai.setEsq(successor.getDir());
            successor.setDir(delNo.getDir());
        }
        return successor;
    }


}
