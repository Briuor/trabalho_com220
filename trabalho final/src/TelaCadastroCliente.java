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
    JFrame frameCadastroCliente = new JFrame("Cadastrar Cliente");
    JPanel panelFormCadastroCliente = new JPanel(new SpringLayout());
    JPanel panelButtonCadastrar = new JPanel();
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    JLabel name = new JLabel("Nome: ", JLabel.TRAILING);
    JTextField nameText = new JTextField(25);
    JLabel adress = new JLabel("Endereço: ", JLabel.TRAILING);
    JTextField adressText = new JTextField(25);
    JLabel email = new JLabel("Email: ", JLabel.TRAILING);
    JTextField emailText = new JTextField(25);
    JLabel cpf = new JLabel("CPF: ", JLabel.TRAILING);
    JTextField cpfText = new JTextField(25);
    
    
    JButton createClient = new JButton("CADASTRAR");

    public TelaCadastroCliente() {
        createClientWindow();
    }
    
    public void createClientWindow(){
        createClient.addActionListener(this);
        
            panelFormCadastroCliente.add(name);
            name.setLabelFor(nameText);
            panelFormCadastroCliente.add(nameText);
            
            panelFormCadastroCliente.add(adress);
            name.setLabelFor(adressText);
            panelFormCadastroCliente.add(adressText);
            
            panelFormCadastroCliente.add(email);
            name.setLabelFor(emailText);
            panelFormCadastroCliente.add(emailText);
            
            panelFormCadastroCliente.add(cpf);
            name.setLabelFor(cpfText);
            panelFormCadastroCliente.add(cpfText);

        panelButtonCadastrar.add(createClient);
        
        SpringUtilities.makeCompactGrid(panelFormCadastroCliente,
                                4, 2, //rows, cols
                                3, 3,        //initX, initY
                                3, 3);       //xPad, yPad
        
        mainPanel.add(panelFormCadastroCliente, BorderLayout.NORTH);
        mainPanel.add(panelButtonCadastrar, BorderLayout.SOUTH);
        
        frameCadastroCliente.add(mainPanel);
        frameCadastroCliente.pack();
        frameCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCadastroCliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = nameText.getText();
        String adress = adressText.getText();
        String email = emailText.getText();
        String cpf = cpfText.getText();
        
        ControleCliente Cliente = new ControleCliente();
        Cliente.cadastraCliente(name, adress, email, cpf);
    }
}
