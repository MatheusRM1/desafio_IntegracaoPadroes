package org.integracao;

public class BebidaFactory {
    public static Pedido obterBebida(String tipoBebida) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("org.integracao.Bebida" + tipoBebida);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Bebida inexistente");
        }
        if (!(objeto instanceof Pedido)) {
            throw new IllegalArgumentException("Bebida inválida");
        }
        return (Pedido) objeto;
    }
}
