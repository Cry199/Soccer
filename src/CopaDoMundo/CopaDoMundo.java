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

        List<List<String>> faseDeGruposLista = faseDeGruposLista();

        List<List<String>> faseDeGrupos = faseDeGruposJogo(faseDeGruposLista);

        List<String> quartasDeFinal = quartasDeFinalList(quartasDeFinal(faseDeGrupos));

        List<String> semiFinal = semiFinal(quartasDeFinal);

        List<String> finalList = finalETerceiroColocado(semiFinal);

        finalDaCopa(finalList);
    }

    private void criarTime() 
    {
        // Criar 32 países e add a timesArrayList
        CriarTimes criarTimes = new CriarTimes();
        timesArrayList = criarTimes.timesInit();
    }

    private List<List<String>> faseDeGruposLista() 
    {
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
        System.out.println("Fase De Grupo: ");
        for (int i = 0; i < faseDeGruposLista.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeGruposLista.get(i));
        }

        return faseDeGruposLista;
    }

    private List<List<String>> faseDeGruposJogo(List<List<String>> faseDeGruposLista)
    {
        // Jogar entre os países de cada grupo e obter os vencedores
        List<List<String>> faseDeGrupos = new ArrayList<>();
        for (List<String> grupoAtual : faseDeGruposLista) 
        {
            List<String> vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(grupoAtual);
            faseDeGrupos.add(vencedoresGrupoAtual);
        }

        // Exibir os jogos da fase grupo
        System.out.println("Fase Grupo Jogos: ");
        for (int i = 0; i < faseDeGrupos.size(); i++) 
        {
            System.out.println("Grupo " + (i + 1) + ": " + faseDeGrupos.get(i));
        }

        return faseDeGrupos;
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

        // Exibir os jogos da Quartas De Final
        System.out.println("Quartas De Final: ");
        for (int i = 0; i < quartasDeFinal.size(); i++) 
        {
            System.out.println("Time " + (i + 1) + ": "+ quartasDeFinal.get(i));
        }

        return quartasDeFinal;
    }

    private List<String> semiFinal(List<String> quartasDeFinal)
    {
        // Jogar entre os países de cada grupo e obter os vencedores
        List<String> semiFinal = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 4; i++) 
        {
            String vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(quartasDeFinal.get(j),quartasDeFinal.get(j + 1));
            semiFinal.add(vencedoresGrupoAtual);

            j += 2;
        }

        // Exibir os jogos da SEMIFINAL
        System.out.println("SEMIFINAL: ");
        for (int i = 0; i < semiFinal.size(); i++) 
        {
            System.out.println("Time " + (i + 1) + ": "+ semiFinal.get(i));
        }

        return semiFinal;
    }

    private List<String> finalETerceiroColocado(List<String> semiFinal)
    {
        List<String> finalList = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 2; i++) 
        {
            String vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(semiFinal.get(j),semiFinal.get(j + 1));
            finalList.add(vencedoresGrupoAtual);

            if(vencedoresGrupoAtual == semiFinal.get(j))
            {
                temp.add(semiFinal.get(j + 1));
            }
            else
            {
                temp.add(semiFinal.get(j));
            }

            j += 2;
        }

        // Jogar entre os países de para ver o Terceiro Colocado
        String terceiroColocado = realizarAsPartidasEntreOsPaiesDoGrupo(temp.get(0),temp.get(1));
        finalList.add(terceiroColocado);

        // Exibir os jogos da FINAL
        System.out.println("FINAL: ");
        System.out.println(finalList.get(0)+ " vs "+ finalList.get(1));
        System.out.println("Terceiro Colocado: " + finalList.get(2));

        return finalList;
    }

    public void finalDaCopa(List<String> finalList)
    {
        String vencedoresGrupoAtual = realizarAsPartidasEntreOsPaiesDoGrupo(finalList.get(0),finalList.get(1));

        System.out.println("Vencedor: " + vencedoresGrupoAtual);
    }

    private String realizarAsPartidasEntreOsPaiesDoGrupo(String pais1, String pais2) 
    {
        // Realizar as partidas entre os países do grupo
        String vencedor = simularPartida(pais1, pais2);

        return vencedor;
    }

    private List<String> realizarAsPartidasEntreOsPaiesDoGrupo(List<String> grupo) 
    {
        // Realizar as partidas entre os países do grupo
        List<String> vencedores = new ArrayList<>();
        for (int i = 0; i < grupo.size(); i += 2) 
        {
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

    private List<String> quartasDeFinalList(List<List<String>> quartasDeFinal)
    {
        List<String> quartasDeFinalList = new ArrayList<>();

        for (List<String> sublist : quartasDeFinal) 
        {
            for (String element : sublist) 
            {
                quartasDeFinalList.add(element);
            }
        }

        return quartasDeFinalList;
    }
}
