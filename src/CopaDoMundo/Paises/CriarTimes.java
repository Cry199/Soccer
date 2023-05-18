package CopaDoMundo.Paises;

import java.util.ArrayList;
import java.util.Collections;

public class CriarTimes 
{
    public ArrayList<Jogadores> timesUnidos()
    {
        ArrayList<Jogadores> timesUnidos = new ArrayList<>();

        for (int index = 0; index < 32; index++) 
        {
            timesUnidos.addAll(criarTimes());
        }

        return timesUnidos;
    }

    private ArrayList<Jogadores> criarTimes()
    {
        ArrayList<Jogadores> timesArrayList = new ArrayList<>();


        ArrayList<String> pais = criarTimeArrayList();
        ArrayList<String> jogadadores = criarJogadorArrayList();
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                Jogadores jogadores = new Jogadores(jogadadores.get(j), pais.get(i));
                timesArrayList.add(jogadores);
            }
        }

        for (Jogadores jogadores : timesArrayList) {
            System.out.println(jogadores);
        }

        return timesArrayList;
    }

    private ArrayList<String> criarTimeArrayList()
    {
        ListaDePaises listaDePaises = new ListaDePaises();
        ArrayList<String> listaDepPaiseArrayList = new ArrayList<>();

        listaDepPaiseArrayList = listaDePaises.listaDePaises();

        Collections.shuffle(listaDepPaiseArrayList);

        return listaDepPaiseArrayList; 
    }

    private ArrayList<String> criarJogadorArrayList()
    {
        ListaDeJogadores listaDeJogadores = new ListaDeJogadores();
        ArrayList<String> listaDeJogadoresArrayList = new ArrayList<>();

        listaDeJogadoresArrayList = listaDeJogadores.listaDeJogadoresArrayList();

        Collections.shuffle(listaDeJogadoresArrayList);

        return listaDeJogadoresArrayList; 
    }
}
