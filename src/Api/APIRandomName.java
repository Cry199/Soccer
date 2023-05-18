package Api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class APIRandomName
{
    public String criarNome()
    {
        try
        {
            // Criar uma URL para a API
            String url = "https://api.invertexto.com/v1/faker?token=3599|cL3WerDltFGDdNifs01MJr8Cp8yC2gI0&fields=name&locale=pt_BR%2C+en_US%2Cja_JP";
            URL obj = new URL(url);

            // Abrir uma conexão HTTP
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Definir o método de solicitação (GET)
            con.setRequestMethod("GET");

            // Obter a resposta da API
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null)
                {
                    response.append(inputLine);
                }
                in.close();

                // Converter a resposta em objeto JSON
                JSONObject json = new JSONObject(response.toString());

                // Extrair o valor do campo "name"
                String name = json.getString("name");

                // Exibir o nome obtido ou retorna o nome.
                return name;
                   
            }
            else
            {
                System.out.println("A solicitação GET não funcionou. Código de resposta: " + responseCode);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;  
    }
    
    
}
