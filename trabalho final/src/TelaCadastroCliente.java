import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public final class TelaCadastroCliente extends SpringUtilities implements ActionListener{
    private ControleCliente controleCliente;

    JFrame frameCadastroCliente = new JFrame("Cadastrar Cliente");
    JPanel panelFormCadastroCliente = new JPanel(new SpringLayout());
    JPanel panelButtonConsultar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
   
    JLabel cpf = new JLabel("CPF: ", JLabel.TRAILING);
    JLabel nome = new JLabel("Nome: ", JLabel.TRAILING);
    JLabel email = new JLabel("Email: ", JLabel.TRAILING);
    JLabel endereco = new JLabel("Endereco: ", JLabel.TRAILING);
    private JTextField nomeText = new JTextField(25);
    private JTextField emailText = new JTextField(25);
    private JTextField enderecoText = new JTextField(25);
    private JTextField cpfText = new JTextField(25);
    
    
    JButton createClient = new JButton("CADASTRAR");

    public TelaCadastroCliente(ControleCliente controleCliente) {
        this.controleCliente = controleCliente;
        createClientWindow();
    }
    
    public void createClientWindow(){
        createClient.addActionListener(this);
        
        panelFormCadastroCliente.add(nome);
        nome.setLabelFor(nomeText);
        panelFormCadastroCliente.add(nomeText);
        
        panelFormCadastroCliente.add(email);
        email.setLabelFor(emailText);
        panelFormCadastroCliente.add(emailText);  
        
        panelFormCadastroCliente.add(endereco);
        endereco.setLabelFor(enderecoText);
        panelFormCadastroCliente.add(enderecoText);
        
        panelFormCadastroCliente.add(cpf);
        cpf.setLabelFor(cpfText);
        panelFormCadastroCliente.add(cpfText);

        panelButtonConsultar.add(createClient);
        
        SpringUtilities.makeCompactGrid(panelFormCadastroCliente,
                                4, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        mainPanel.add(panelFormCadastroCliente, BorderLayout.NORTH);
        mainPanel.add(panelButtonConsultar, BorderLayout.SOUTH);
        
        frameCadastroCliente.add(mainPanel);
        frameCadastroCliente.pack();
        frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroCliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nome = nomeText.getText();
        String email = emailText.getText();
        String endereco = enderecoText.getText();
        String cpf = cpfText.getText();
        controleCliente.cadastraCliente(nome, endereco, email, cpf);
        JOptionPane.showMessageDialog(null, "Cadastro Feito com Sucesso!");
    }

}
