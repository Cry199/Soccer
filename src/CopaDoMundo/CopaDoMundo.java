package CopaDoMundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CopaDoMundo.Paises.CriarTimes;
import CopaDoMundo.Paises.Jogadores;
import CopaDoMundo.Paises.ListaDePaises;

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
        List<String> grupo = null;
        List<List<String>> faseDeGrupos = new ArrayList<>();
        int tamanhoGrupo = 4;
        for (int i = 0; i < listaCountriesArrayList.size(); i += tamanhoGrupo) 
        {
            grupo = listaCountriesArrayList.subList(i, i + tamanhoGrupo);
            faseDeGrupos.add(grupo);
        }
        
        
        
        // Exibir os grupos 
        System.out.println("Fase De Grupo 1");
        for (int i = 0; i < faseDeGrupos.size(); i++) 
        {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeGrupos.get(i));
        }
        
    }

    private void realizarAsPartidasEntreOsPaiesDoGrupo()
    {
        /*
        // Realizar as partidas entre os países do grupo
        List<String> vencedores = new ArrayList<>();
        for (int i = 0; i < grupo.size(); i += 2) {
            String pais1 = grupo.get(i);
            String pais2 = grupo.get(i + 1);

            // Simulação do jogo entre pais1 e pais2
            String vencedor = simularPartida(pais1, pais2);

            System.out.println(vencedor);

            vencedores.add(vencedor);
        }

        */
    }

    private String simularPartida(String pais1, String pais2)
    {
        double random = Math.random();
        if (random < 0.5) 
        {
            return pais1;
        } 
        else 
        {
            return pais2;
        }
    }

    private ArrayList<String> listarTimes()
    {
        ListaDePaises paises = new ListaDePaises();
        ArrayList<String> countries = paises.listaDePaises();

        Collections.shuffle(countries);

        ArrayList<String> temp = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) 
        {
           temp.add(countries.get(i));
        }

        return temp;
    }
}
