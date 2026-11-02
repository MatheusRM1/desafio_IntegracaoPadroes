import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.integracao.*;


class CafeteriaTest {

    @BeforeEach
    void setUp() {
        ConfiguracaoCafeteria.getInstance().setNomeLoja("UFJF Coffee");
    }

    @Test
    void deveCriarBebidaViaFactoryMethod() {
        Pedido pedido = BebidaFactory.obterBebida("Cappuccino");

        assertNotNull(pedido);
        assertEquals("Cappuccino Classico", pedido.getNome());
        assertTrue(pedido instanceof BebidaCappuccino);
    }

    @Test
    void deveRetornarExcecaoParaBebidaInexistente() {
        try {
            BebidaFactory.obterBebida("SucoLaranja");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Bebida inexistente", e.getMessage());
        }
    }

    @Test
    void deveGerarCupomFiscalComDescontoEstudante() {
        Pedido pedido = BebidaFactory.obterBebida("CafeExpresso");
        Desconto descontoEstudante = new DescontoEstudante();

        String cupom = pedido.gerarCupomFiscal(descontoEstudante);

        String cupomEsperado = "UFJF Coffee\n" +
                "Item: Cafe Expresso\n" +
                "Total a Pagar: R$ 4.8";

        assertEquals(cupomEsperado, cupom);
    }

    @Test
    void deveGerarCupomFiscalSemDesconto() {
        Pedido pedido = BebidaFactory.obterBebida("Cappuccino");
        Desconto semDesconto = new SemDesconto();

        String cupom = pedido.gerarCupomFiscal(semDesconto);

        String cupomEsperado = "UFJF Coffee\n" +
                "Item: Cappuccino Classico\n" +
                "Total a Pagar: R$ 12.0";

        assertEquals(cupomEsperado, cupom);
    }
}