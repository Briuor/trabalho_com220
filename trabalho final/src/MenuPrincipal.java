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

    private ControleProduto controleProduto;
    private ControleCliente controleCliente;
    private ControleNota controleNota;

    public void inicializaControles()
    {
        this.controleProduto = new ControleProduto();
        this.controleCliente = new ControleCliente();
        this.controleNota = new ControleNota();
    }

    public MenuPrincipal()
    {
        super("Trabalho Final");
        this.inicializaControles();
        tabbedPane = new JTabbedPane();
        
        botaoConsultClient = new JButton("Consultar Cliente");
        botaoEmitirNota = new JButton("Consultar Produto");
        botaoFaturProd = new JButton("Consultar Faturamento Produto");
        botaoFaturClient = new JButton("Consultar Cliente");
        botaoFaturPeriod = new JButton("Consultar Cliente");
        JPanel pConsultas = new JPanel();
        pConsultas.add(botaoEmitirNota);
        pConsultas.add(botaoConsultClient);
        pConsultas.add(botaoFaturProd);
        pConsultas.add(botaoFaturClient);
        pConsultas.add(botaoFaturPeriod);

        botaoAdicionar = new JButton("Adicionar produto");
        botaoConsultProd = new JButton("Consultar produto");
        JPanel pOperacoes = new JPanel();
        pOperacoes.add(botaoAdicionar);
        pOperacoes.add(botaoConsultProd);

        tabbedPane.add("Inicio", pOperacoes); //add painel de operacoes
        tabbedPane.add("Financeiro", pConsultas);        //add painel de consultas
        
        botaoAdicionar.addActionListener(this);
        botaoConsultProd.addActionListener(this);
        
        this.add(tabbedPane);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //Se clickou em adicionar Produtos
            if(e.getSource() == botaoAdicionar) {
             new TelaAdicionarProduto(controleProduto);
             //controleProduto.gravarProdutos(); // Ta com problema, nao grava ultimo inserido
            }

            else if(e.getSource() == botaoConsultProd)
             new TelaConsultarProduto(controleProduto);
        }
        catch(Exception exc){

        }

    }
    
    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
