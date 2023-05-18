package CopaDoMundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import CopaDoMundo.Paises.CriarTimes;
import CopaDoMundo.Paises.Jogadores;

public class CopaDoMundo 
{
    private ArrayList<Jogadores> timesArrayList = new ArrayList<>();

    public void CopaDoMundoInit()
    {   
        criarTime();

        faseDeGrupos();
    }

    private void criarTime()
    {
        // Criar 32 países e add a timesArrayList
        CriarTimes criarTimes = new CriarTimes();
        timesArrayList = criarTimes.timesUnidos();
    }   

    private void faseDeGrupos()
    {
        // Adicione os outros 32 países à lista
        ArrayList<String> listaCountriesArrayList = new ArrayList<>(listarTimes()); // 
         
        // Embaralhar aleatoriamente a lista de países
        Collections.shuffle(listaCountriesArrayList);

        // Dividir em 8 grupos de 4 países cada
        List<List<String>> faseDeGrupos = new ArrayList<>();
        int tamanhoGrupo = 4;
        for (int i = 0; i < listaCountriesArrayList.size(); i += tamanhoGrupo) 
        {
            List<String> grupo = listaCountriesArrayList.subList(i, i + tamanhoGrupo);
            faseDeGrupos.add(grupo);
        }

        /* Realizar as partidas entre os países do grupo
        List<String> vencedores = new ArrayList<>();
        for (int i = 0; i < grupo.size(); i += 2) {
            String pais1 = grupo.get(i);
            String pais2 = grupo.get(i + 1);

            // Simulação do jogo entre pais1 e pais2
            String vencedor = simularPartida(pais1, pais2);

            vencedores.add(vencedor);
        }
        */
        

        /* Exibir os grupos
        for (int i = 0; i < faseDeGrupos.size(); i++) 
        {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeGrupos.get(i));
        }
        */ 
    }

    private String simularPartida(String pais1, String pais2)
    {
        double random = Math.random();
        if (random < 0.5) 
        {
            return pais1;
        } else 
        {
            return pais2;
        }
    }

    private HashSet<String> listarTimes()
    {
        HashSet<String> countries = new HashSet<>();

        for (Jogadores jogadores : timesArrayList) 
        {
            countries.add(jogadores.getCountry());
        }

        return countries;
    }
}
