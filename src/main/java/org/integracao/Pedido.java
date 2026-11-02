package org.integracao;

public abstract class Pedido {

    public final String gerarCupomFiscal(Desconto desconto) {
        float precoFinal = desconto.calcularValorFinal(this.getPrecoBase());
        String loja = ConfiguracaoCafeteria.getInstance().getNomeLoja();

        return loja + "\n" +
                "Item: " + this.getNome() + "\n" +
                "Total a Pagar: R$ " + precoFinal;
    }

    public abstract String getNome();
    public abstract float getPrecoBase();
}
