
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
public class TelaConsultarProduto extends JFrame implements ActionListener{
    private ControleProduto controleProduto;
    private JTextField textCodigo;
    private JButton botaoConsultar, botaoVoltar;
    
    public TelaConsultarProduto(ControleProduto controleProduto)
    {
        this.controleProduto = controleProduto;
        textCodigo = new JTextField("", 20);
        
        botaoConsultar = new JButton("Consultar");
        botaoVoltar = new JButton("Voltar");
        botaoConsultar.addActionListener(this);
        botaoVoltar.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Codigo do produto: "));
        p.add(textCodigo);
        p.add(botaoVoltar);
        p.add(botaoConsultar);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == botaoConsultar)
        {
            int codigo = Integer.parseInt(textCodigo.getText());

            controleProduto.consultarProduto(codigo);
        }
        else if(e.getSource() == botaoVoltar)
            this.dispose();
    }
}
