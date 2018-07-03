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
                    botaoFaturProd, botaoFaturClientPeriodo, botaoFaturPeriod, // Botoes de cohnsultar faturamento
                    botaoConsultarLucro, botaoVendas, botaoMaisVendidos, botaoFaturClient;

    private ControleProduto controleProduto;
    private ControleCliente controleCliente;
    private ControleNota controleNota;

    public void inicializaControles()
    {
        this.controleProduto = new ControleProduto();
        this.controleCliente = new ControleCliente();
        this.controleNota    = new ControleNota();
    }

    public MenuPrincipal()
    {
        super("Trabalho Final");
        this.inicializaControles();
        tabbedPane = new JTabbedPane();
        
        botaoFaturProd = new JButton("Consultar Faturamento Produto");
        botaoFaturClientPeriodo = new JButton("Consultar Faturamento Cliente Por Periodo");
        botaoFaturPeriod = new JButton("Consultar Faturamento Periodo");
        botaoMaisVendidos = new JButton("Consultar Produtos Mais Vendidos");
        botaoFaturClient = new JButton("Consultar Faturamento Cliente");
        JPanel pConsultas = new JPanel();
        
        pConsultas.add(botaoFaturProd);
        pConsultas.add(botaoFaturClientPeriodo);
        pConsultas.add(botaoFaturPeriod);
        pConsultas.add(botaoMaisVendidos);
        pConsultas.add(botaoFaturClient);
        
        
        botaoAdicionar = new JButton("Adicionar produto");
        botaoConsultProd = new JButton("Consultar produto");
        botaoConsultClient = new JButton("Consultar Cliente");
        botaoEmitirNota = new JButton("Emitir Nota");
        
        JPanel pOperacoes = new JPanel();
        
        pOperacoes.add(botaoAdicionar);
        pOperacoes.add(botaoConsultProd);
        pOperacoes.add(botaoConsultClient);
        pOperacoes.add(botaoEmitirNota);

        tabbedPane.add("Inicio", pOperacoes);       //add painel de operacoes
        tabbedPane.add("Financeiro", pConsultas);   //add painel de consultas
        
        botaoAdicionar.addActionListener(this);
        botaoConsultProd.addActionListener(this);
        botaoEmitirNota.addActionListener(this);
        botaoConsultClient.addActionListener(this);
        botaoMaisVendidos.addActionListener(this);
        botaoFaturProd.addActionListener(this);
        botaoFaturPeriod.addActionListener(this);
        botaoFaturClientPeriodo.addActionListener(this);
        botaoFaturClient.addActionListener(this);
        
        
        
        this.add(tabbedPane);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //Se clicar em adicionar Produtos
            if(e.getSource() == botaoAdicionar)
             new TelaAdicionarProduto(controleProduto);
            
            //Se clicar em Consutlar Produto
            else if(e.getSource() == botaoConsultProd)
             new TelaConsultarProduto(controleProduto);

            //Se clicar em Emitir Nota
            else if(e.getSource() == botaoEmitirNota)
             new TelaInsercaoCPF(controleCliente, controleProduto, controleNota);
            //Consulta clientes
            else if(e.getSource() == botaoConsultClient)
             new TelaConsultarCliente(controleCliente);
            //Consulta mais vendidos
            else if(e.getSource() == botaoMaisVendidos)
                controleNota.consultarMaisVendidos();
            //Consulta faturamento por produto
            else if(e.getSource() == botaoFaturProd)
             new TelaFaturamentoProduto(controleNota);
            //Consulta faturmaento por periodo
            else if(e.getSource() == botaoFaturPeriod)
             new TelaFaturamentoPeriodo(controleNota);
            //Consultar faturamento por periodo cliente
            else if(e.getSource() == botaoFaturClientPeriodo)
             new TelaFaturamentoClientePeriodo(controleCliente); 
            //Consultar faturamento por periodo cliente
            else if(e.getSource() == botaoFaturClient)
             new TelaFaturamentoCliente(controleCliente);   

        }
        catch(Exception exc){

        }
    }
    
    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
