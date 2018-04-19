package bd;

import bd.core.*;
import bd.daos.*;

public class BD
{
    public static final MeuPreparedStatement COMANDO;
    public static final Usuarios USUARIOS; //um como esse para cada classe DAO

    static
    {
    	MeuPreparedStatement comando = null;
     	Usuarios usuarios  = null; //um como esse para cada classe DAO

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://fs5:1433;databasename=poo20188",
            "poo20188", "Pwnna5");

            usuarios = new Usuarios (); //um como esse para cada classe DAO
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
        USUARIOS = usuarios; //um como esse para cada classe DAO
    }
}