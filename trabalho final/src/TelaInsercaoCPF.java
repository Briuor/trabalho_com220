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
 * @author Gabriel
 */
public class TelaInsercaoCPF extends JFrame implements ActionListener{
    private ControleCliente controleCliente;
    private ControleProduto controleProduto;
    private ControleNota controleNota;

    private JTextField textCPF;
    private JButton botaoSubmeter;

    public TelaInsercaoCPF(ControleCliente controleCliente, ControleProduto controleProduto, ControleNota controleNota)
    {
        this.controleCliente = controleCliente;
        this.controleProduto = controleProduto;
        this.controleNota = controleNota;
        textCPF = new JTextField("", 20);
        
        botaoSubmeter = new JButton("Submeter");
        botaoSubmeter.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Digite seu CPF: "));
        p.add(textCPF);
        p.add(botaoSubmeter);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    	//Se cpf digitado valido chama tela Selecao produtos
		if(controleCliente.validaCPF(textCPF.getText()) == true){
			// passa controladores de cliente e produto e cpf do usuario para saber qual usuario esta comprando
			new TelaSelecaoProdutos(controleCliente, controleProduto, controleNota, textCPF.getText()); 
                        this.dispose();
		}

		//se invalido chama tela Cadastro Cliente
		else
    		new TelaCadastroCliente(controleCliente);
    }
    
}
