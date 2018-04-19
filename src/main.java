import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import bd.*;
import bd.dbos.*;

public class main {
	public static void main(String[] args)
    {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String nome, email, senha;
        try
        {
        	email = JOptionPane.showInputDialog("Digite o E-mail:");
        	nome = JOptionPane.showInputDialog("Digite o nome:");
        	senha = JOptionPane.showInputDialog("Digite a senha");
            Usuario usuario = new Usuario (email, nome, senha);
            BD.USUARIOS.incluir (usuario);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
        catch (Exception erro)
        {
            System.err.println (erro);
        }
    }

}
