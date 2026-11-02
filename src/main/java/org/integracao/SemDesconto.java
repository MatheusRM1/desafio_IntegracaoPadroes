package org.integracao;

public class SemDesconto implements Desconto {

    public float calcularValorFinal(float precoBase) {
        return precoBase;
    }
}
