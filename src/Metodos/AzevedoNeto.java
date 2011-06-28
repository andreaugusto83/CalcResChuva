package Metodos;

public class AzevedoNeto implements Metodos
{

    double gD;
    double mPC; // meses pouca chuva.
    double volume;
    double pAnual; // Precipitação anual

    public String calcula(double vU, double aC, double[] iPM, double cAP)
    {

        for(int i = 0; i <=11; i++)
        {
            pAnual = pAnual + iPM[i]/1000;
        }

        mPC = iPM[12];

        volume = 0.042 * pAnual * aC * mPC;
        
        return (int)volume + "m³";

    }

    public void resetar()
    {
        volume = 0;
        pAnual = 0;
    }

}
