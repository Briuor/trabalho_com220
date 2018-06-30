import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaSelecaoProdutos extends JFrame implements ActionListener{
    private ControleCliente controleCliente;

    private JTextField textCodigo, textQuantidade, textDataEmissao;
    private JButton botaoEmitir, botaoAdicionar;

    public TelaSelecaoProdutos(ControleCliente controleCliente)
    {
        this.controleCliente = controleCliente;
        textCodigo = new JTextField("", 20);
        textQuantidade = new JTextField("", 20);
        textDataEmissao = new JTextField("", 20);
        
        botaoEmitir = new JButton("Emitir Nota");
        botaoAdicionar = new JButton("Adicionar produto");
        botaoEmitir.addActionListener(this);
        botaoAdicionar.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(new JLabel("Código do produto: "));
        p.add(textCodigo);
        p.add(new JLabel("Quantidade: "));
        p.add(textQuantidade);
        p.add(botaoAdicionar);
        p.add(new JLabel("Data de emissao: "));
        p.add(textDataEmissao);
        p.add(botaoEmitir);
        
        this.add(p);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se clicou em Adicionar produto
    //     if(e.getSource() == botaoAdicionar)
    //         controleCliente.selecionarProduto();
        
    //     //Se clicou em emitir nota, mostra jOptionPane com informacoes da nota
    //     else if (e.getSource() == botaoEmitir) 
    //         controleCliente.emitirNota();    
     }
    
}
