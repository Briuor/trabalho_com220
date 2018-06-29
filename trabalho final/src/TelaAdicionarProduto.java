
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
public class TelaAdicionarProduto extends JFrame implements ActionListener{
    private ControleProduto controleProduto;
    private JTextField textCodigo, textDescricao, textPrecoCompra, textValorVenda, textQuantidade;
    private JButton botaoAdicionar;
    
    public TelaAdicionarProduto()
    {
        JTextField textCodigo = new JTextField("", 20);
        JTextField textDescricao = new JTextField("", 20);
        JTextField textPrecoCompra = new JTextField("", 20);
        JTextField textValorVenda = new JTextField("", 20);
        JTextField textQuantidade = new JTextField("", 20);
        
        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Codigo: "));
        p.add(textCodigo);
        p.add(new JLabel("Descricao: "));
        p.add(textDescricao);
        p.add(new JLabel("preço De Compra: "));
        p.add(textPrecoCompra);
        p.add(new JLabel("Valor de Venda: "));
        p.add(textValorVenda);
        p.add(new JLabel("Quantidade: "));
        p.add(textQuantidade);
        p.add(botaoAdicionar);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

            int codigo = textCodigo.getText();
            String descricao = textCodigo.getText();
            double precoCompra = Double.parseDouble(textPrecoCompra.getText());
            double valorVenda = Double.parseDouble(textValorVenda.getText());
            int quantidade = Integer.parseInt(textQuantidade.getText());

            controleProduto.adicionarProduto(codigo, descricao, precoCompra, valorVenda, quantidade);
    }
}
