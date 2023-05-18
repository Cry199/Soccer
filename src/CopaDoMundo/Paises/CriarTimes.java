package CopaDoMundo.Paises;

import java.util.ArrayList;
import java.util.Collections;


import Api.APIRandomName;

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
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                String nomeDoJogador = criarJogador();

                Jogadores jogadores = new Jogadores(nomeDoJogador, pais.get(i));
                timesArrayList.add(jogadores);
            }
        }

        return timesArrayList;
    }

    private APIRandomName api = new APIRandomName();

    private ArrayList<String> criarTimeArrayList()
    {
        ListaDePaises listaDePaises = new ListaDePaises();
        ArrayList<String> listaDepPaiseArrayList = new ArrayList<>();

        listaDepPaiseArrayList = listaDePaises.listaDePaises();

        Collections.shuffle(listaDepPaiseArrayList);

        return listaDepPaiseArrayList; 
    }

    private String criarJogador()
    {
        return api.criarNome(); 
    }
}
