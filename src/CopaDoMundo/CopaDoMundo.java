package CopaDoMundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import CopaDoMundo.Paises.CriarTimes;
import CopaDoMundo.Paises.Jogadores;

public class CopaDoMundo {
    private ArrayList<Jogadores> timesArrayList = new ArrayList<>();

    public void CopaDoMundoInit() 
    {
        criarTime();

        List<List<String>> faseDeGruposLista = faseDeGruposLista();

        List<List<String>> faseDeGrupos = faseDeGruposJogo(faseDeGruposLista);

        List<List<String>> quartasDeFinal = quartasDeFinal(faseDeGrupos);

    }

    private void criarTime() {
        // Criar 32 países e add a timesArrayList
        CriarTimes criarTimes = new CriarTimes();
        timesArrayList = criarTimes.timesInit();
    }

    private List<List<String>> faseDeGruposLista() {
        // Adicione os outros 32 países à lista
        ArrayList<String> listaCountriesArrayList = new ArrayList<>(listarTimes()); //

        // Embaralhar aleatoriamente a lista de países
        Collections.shuffle(listaCountriesArrayList);

        // Dividir em 8 grupos de 4 países cada
        List<String> grupo = null;
        List<List<String>> faseDeGruposLista = new ArrayList<>();
        int tamanhoGrupo = 4;
        for (int i = 0; i < listaCountriesArrayList.size(); i += tamanhoGrupo) {
            grupo = listaCountriesArrayList.subList(i, i + tamanhoGrupo);
            faseDeGruposLista.add(grupo);
        }

        // Exibir os grupos
        System.out.println("Fase De Grupo 1");
        for (int i = 0; i < faseDeGruposLista.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeGruposLista.get(i));
        }

        return faseDeGruposLista;
    }

    private List<List<String>> faseDeGruposJogo(List<List<String>> faseDeGruposLista)
    {
        // Jogar entre os países de cada grupo e obter os vencedores
        List<List<String>> faseDeOitavas = new ArrayList<>();
        for (List<String> grupoAtual : faseDeGruposLista) 
        {
            List<String> vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(grupoAtual);
            faseDeOitavas.add(vencedoresGrupoAtual);
        }

        // Exibir os jogos da fase grupo
        System.out.println("Fase Grupo Jogos: ");
        for (int i = 0; i < faseDeOitavas.size(); i++) 
        {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeOitavas.get(i));
        }

        return faseDeOitavas;
    }

    private List<List<String>> quartasDeFinal(List<List<String>> faseDeGrupos)
    {
        // Jogar entre os países de cada grupo e obter os vencedores
        List<List<String>> quartasDeFinal = new ArrayList<>();
        for (List<String> grupoAtual : faseDeGrupos) 
        {
            List<String> vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(grupoAtual);
            quartasDeFinal.add(vencedoresGrupoAtual);
        }

        // Exibir os jogos da fase grupo
        System.out.println("Fase Grupo Jogos: ");
        for (int i = 0; i < quartasDeFinal.size(); i++) 
        {
            System.out.println("Grupo " + (i + 1) + ": " + quartasDeFinal.get(i));
        }

        return quartasDeFinal;
    }

    private List<String> realizarAsPartidasEntreOsPaiesDoGrupo(List<String> grupo) 
    {
        // Realizar as partidas entre os países do grupo
        List<String> vencedores = new ArrayList<>();
        for (int i = 0; i < grupo.size(); i += 2) {
            String pais1 = grupo.get(i);
            String pais2 = grupo.get(i + 1);

            // Simulação do jogo entre pais1 e pais2
            String vencedor = simularPartida(pais1, pais2);

            vencedores.add(vencedor);
        }
        return vencedores;
    }

    private String simularPartida(String pais1, String pais2) 
    {
        double random = Math.random();
        if (random < 0.5) {
            return pais1;
        } else {
            return pais2;
        }
    }

    private HashSet<String> listarTimes() 
    {
        HashSet<String> countriesHashMap = new HashSet<>();

        for (Jogadores jogadores : timesArrayList) {
            String country = jogadores.getCountry();
            countriesHashMap.add(country);
        }

        return countriesHashMap;
    }
}
