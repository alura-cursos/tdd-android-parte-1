package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    private Leilao console = new Leilao("Console");
    private Usuario alex = new Usuario("Alex");
    private Usuario fran = new Usuario("Fran");

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {
        // executar ação esperada
        String descricaoDevolvida = console.getDescricao();

        // testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance(){
        console.propoe(new Lance(alex, 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(fran, 9000.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        console.propoe(new Lance(alex, 200.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(fran, 9000.0));

        double menorLanceDevolvido = console.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, 0.0001);
    }

}