import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class MenuPrincipal extends JFrame implements ActionListener{
    private JTabbedPane tabbedPane;
    private JButton botaoAdicionar, botaoEmitirNota, botaoConsultProd, botaoConsultClient,
                    botaoFaturProd, botaoFaturClient, botaoFaturPeriod, // Botoes de cohnsultar faturamento
                    botaoConsultarLucro, botaoVendas, botaoMaisVendidos;
    //criar painel para cada aba
    
    public MenuPrincipal()
    {
        super("Trabalho Final");
        tabbedPane = new JTabbedPane();
        
        botaoConsultProd = new JButton("Consultar produto");
        botaoConsultClient = new JButton("Consultar Cliente");
        botaoFaturProd = new JButton("Consultar ");
        botaoFaturClient = new JButton("Consultar Cliente");
        botaoFaturPeriod = new JButton("Consultar Cliente");
        JPanel pConsultas = new JPanel();
        pConsultas.add(botaoConsultProd);
        pConsultas.add(botaoConsultClient);
        pConsultas.add(botaoFaturProd);
        pConsultas.add(botaoFaturClient);
        pConsultas.add(botaoFaturPeriod);

        botaoAdicionar = new JButton("Adicionar produto");
        botaoEmitirNota = new JButton("Adicionar produto");
        JPanel pOperacoes = new JPanel();
        pOperacoes.add(botaoAdicionar);
        pOperacoes.add(botaoEmitirNota);

        tabbedPane.add("Inicio", pOperacoes); //add painel de operacoes
        tabbedPane.add("Consultas", pConsultas);        //add painel de consultas

        this.add(tabbedPane);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
