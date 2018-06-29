
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
    private JLabel labelCodigo, labelDescricao, labelPrecoCompra, labelValorVenda;
    private JTextField textCodigo, textDescricao, textPrecoCompra, textValorVenda;
    private JButton botaoAdicionar;
    
    public TelaAdicionarProduto()
    {
        
        JPanel p = new JPanel();
        p.add(new JLabel("Codigo: "));
        p.add(textCodigo);
        p.add(new JLabel("Descricao: "));
        p.add(textCodigo);
        p.add(new JLabel("preçoCompra: "));
        p.add(textCodigo);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
