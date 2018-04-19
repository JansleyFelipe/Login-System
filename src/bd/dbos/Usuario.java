package bd.dbos;

public class Usuario
{
    private String eMail;
    private String nome;
    private String senha;
 
    public void setEmail (String eMail) throws Exception
    {
        if (eMail == "")
            throw new Exception ("eMail invalido");

        this.eMail = eMail;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public void setSenha (String senha) throws Exception
    {
        if (senha == "")
            throw new Exception ("senha invalido");

        this.senha = senha;
    }

    public String getEmail ()
    {
        return this.eMail;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public String getSenha ()
    {
        return this.senha;
    }

    public Usuario (String eMail, String nome, String senha) throws Exception
    {
        this.setEmail (eMail);
        this.setNome   (nome);
        this.setSenha  (senha);
    }
}