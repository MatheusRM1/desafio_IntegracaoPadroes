package org.integracao;

public class DescontoEstudante implements Desconto {

    public float calcularValorFinal(float precoBase) {
        return precoBase * 0.8f;
    }
}