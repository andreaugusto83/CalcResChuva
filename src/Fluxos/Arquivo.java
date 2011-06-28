package Fluxos;
import java.io.*;

public class Arquivo
{
    File arquivo = new File("Cidades\\");
    File[] file = arquivo.listFiles();
    int length = file.length;

    public void criaCidade(double[] indice, String nome)
    {
        OutputStreamWriter escritor = null;
        String newLine = System.getProperty("line.separator");
        try
		{
                        File cidade = new File("Cidades\\" + nome);
			escritor = new OutputStreamWriter(new FileOutputStream(cidade));
                       
                        for(int i = 0; i < 13; i++)
                        {
                            if(i==12)
                            {
                                escritor.write("" + (indice[i]+1) + newLine);
                            }
                            else
                        
                            {
                                escritor.write("" + indice[i] + newLine);
                            }
                        }

                        escritor.close();
                }

        catch (IOException e)
		{
		}
    }

    public double[] getPluv(String nome) throws IOException
    {
        String line;
        double[] indices = new double[13];

        for(int i = 0; i < 13; i++)
        {
            indices[i] = -1;
        }

            BufferedReader inReader = new BufferedReader(new FileReader("Cidades\\" + nome));

            while((line = inReader.readLine())!= null)
            {
                int i = 0;
                while(indices[i] != -1)
                {
                    i++;
                }

                indices[i] = Double.parseDouble(line);
            }

            return indices;

    }

    public String getCidades(int nivel)
    {
        String[] listaCidades = new String[length];
        if(file != null){          

            for(int i = 0; i < length; ++i){
                if(file[i].isFile()){
                    listaCidades[i] = file[i].getName();

                }
            }
        }

        return listaCidades[nivel];

    }

    public int getNumeroCidades()
    {
        return length;
    }

}