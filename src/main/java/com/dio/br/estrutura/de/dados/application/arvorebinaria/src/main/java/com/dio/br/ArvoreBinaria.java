package com.dio.br;

public class ArvoreBinaria<T extends Comparable<T>> {

    private NoBinario<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    /**
     * @param conteudo recebe o conteúdo de um nó
     */
    public void inserir(T conteudo) {
        NoBinario<T> novoNo = new NoBinario<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    /**
     * @param atual se for nulo, o nó atual estará na raiz, senão será comparado com o novoNo e se for menor do que 0 irá para a esqueda, senão para a direita.
     * @param novoNo passa a ser a raiz
     * @return retorna o nó atual
     */
    private NoBinario<T> inserir(NoBinario<T> atual, NoBinario<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsquerdo(inserir(atual.getNoEsquerdo(), novoNo));
        } else {
            atual.setNoDireito(inserir(atual.getNoDireito(), novoNo));
        }
        return atual;
    }

    /**
     * Exibe em ordem
     */
    public void exibirEmOrdem() {
        System.out.println("\nExibindo em ordem...");
        exibirEmOrdem(this.raiz);
    }

    /**
     * @param atual se caso não estiver nulo, o nó atual verifica a esquerda e exibe o conteúdo da raiz e posteriormente verifica a direita.
     */
    private void exibirEmOrdem(NoBinario<T> atual) {
        if (atual != null) {
            exibirEmOrdem(atual.getNoEsquerdo());
            System.out.println(atual.getConteudo() + ", ");
            exibirEmOrdem(atual.getNoDireito());
        }
    }

    /**
     * Exibe pós ordem
     */
    public void exibirPosOrdem() {
        System.out.println("\nExibindo pós ordem...");
        exibirEmOrdem(this.raiz);
    }

    /**
     * @param atual se caso não estiver nulo, o nó atual verifica a esqyerda, posteriormente verifica a direita e exibe o conteúdo da raiz.
     */
    private void exibePosOrdem(NoBinario<T> atual) {
        exibirEmOrdem(atual.getNoEsquerdo());
        exibirEmOrdem(atual.getNoDireito());
        System.out.println(atual.getConteudo() + ", ");
    }

    /**
     * Exibe pré ordem
     */
    public void exibePreOrdem() {
        System.out.println("\nExibindo pré ordem...");
        exibePreOrdem(this.raiz);
    }

    /**
     * @param atual se caso não estiver nulo, exibe o conteúdo da raiz, o nó atual verifica a esqyerda, posteriormente verifica a direita
     */
    private void exibePreOrdem(NoBinario<T> atual) {
        if (atual != null) {
            System.out.println(atual.getConteudo() + ", ");
            exibePreOrdem(atual.getNoEsquerdo());
            exibePreOrdem(atual.getNoDireito());
        }
    }
}
