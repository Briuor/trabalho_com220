import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class ControleNota {
   private ArrayList <Nota> notas;

	public ControleNota(){
		this.notas = new ArrayList<>();
        try{
            this.lerNotas(); // le arquivo e preenche array de notas
            System.console().writer().println("arquivo notas.ser lido");
        }
        catch(Exception exc){
            System.console().writer().println("erro ao ler arquivo");
        }
	}   

	public ArrayList <Nota> getNotas(){
		return notas;
	}

	public void adicionarNota(Nota novaNota){
		notas.add(novaNota);
		try{
			this.gravarNotas();
            System.console().writer().println("Nota adicionada em notas");
		} catch(Exception exc){
            System.console().writer().println("erro ao ler notas");			
		}
	}

	public void gravarNotas() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream("notas.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(notas);
            out.flush();
            out.close();
            arquivo.close();
        } catch (Exception exc) {
            throw new Exception("Arquivo notas não encontrado!");
        }
    }

    public void lerNotas() throws Exception {
        try {
            FileInputStream arquivo = new FileInputStream("notas.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            notas = (ArrayList<Nota>) in.readObject();
            in.close();
        } catch (Exception ex) {
            notas = new ArrayList<>();
        }
    }
}
