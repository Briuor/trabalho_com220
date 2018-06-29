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
    private JButton botaoAdicionar, botaoEmitirNota, botaoConsultProd
    //criar painel para cada aba
    
    public MenuPrincipal()
    {
        tabbedPane = new JTabbedPane();
        JPanel pConsultas = new JPanel();
        pConsultas.add(botaoConsultProd);
        JPanel pOperacoes = new JPanel();
        pOperacoes.add(botaoAdicionar);
        
        tabbedPane.add("Consultas", pConsultas);        //add painel de consultas
        tabbedPane.add("Outras Operacoes", pOperacoes); //add painel de operacoes
        
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
