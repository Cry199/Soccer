package CopaDoMundo.Paises;

public class Jogadores 
{
    private String nomeDoJogador; 
    private String country;

    public Jogadores(String nomeDoJogador, String country)
    {
        this.nomeDoJogador = nomeDoJogador;
        this.country = country;
    }

    public String getNomeDoJogador()
    {
        return nomeDoJogador;
    }

    public String getCountry()
    {
        return country;
    }

    @Override
    public String toString()
    {
        return "Nome Do Jogador: " + nomeDoJogador + " Time: " + country;
    }
}
