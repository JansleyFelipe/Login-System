package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Usuarios
{
    public boolean cadastrado (String eMail) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIOS " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString(1, eMail);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuário");
        }

        return retorno;
    }

    public void incluir (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuário nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO USUARIOS " +
                  "(EMAIL,NOME,SENHA) " +
                  "VALUES " +
                  "(?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, usuario.getEmail ());
            BD.COMANDO.setString (2, usuario.getNome ());
            BD.COMANDO.setString (3, usuario.getSenha ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception (erro.getMessage());
        }
    }

    public void excluir (String eMail) throws Exception
    {
        if (!cadastrado (eMail))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM USUARIOS " +
                  "WHERE EMAIL=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, eMail);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir usuário");
        }
    }

    public void alterar (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuário inexistente");

        if (!cadastrado (usuario.getEmail()))
            throw new Exception ("Usuário inexistente");

        try
        {
            String sql;

            sql = "UPDATE USUARIOS " +
                  "SET NOME=? " +
                  "SET SENHA=? " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, usuario.getNome ());
            BD.COMANDO.setString  (2, usuario.getSenha ());
            BD.COMANDO.setString    (3, usuario.getEmail ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de usuário");
        }
    }

    public Usuario getUsuario (String eMail) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM  USUARIOS " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, eMail);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Usuário inexistente");

            usuario = new Usuario (resultado.getString   ("EMAIL"),
                               resultado.getString("NOME"),
                               resultado.getString ("SENHA"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuário");
        }

        return usuario;
    }

    public MeuResultSet getUsuarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIOS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar usuário");
        }

        return resultado;
    }
}