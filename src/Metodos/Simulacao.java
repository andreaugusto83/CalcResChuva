
package Metodos;

public class Simulacao implements Metodos
{
        int mesFalta = 0; // Numero de meses negativos
        double []overFlow = new double[12];
        double overTotal, volMin, volMax, volAprAnual = 0;
        double []volApr = new double[12];
        double []volMes = new double[12];

    public String calcula(double vU, double aC, double[] iPM, double cAP)
    {
        for(int i = 0; i < 12; i++)
        {
            volApr[i] = iPM[i]/1000 * aC * cAP;
            volAprAnual +=volApr[i];
        }
        volMin = vU;

        while(true)
        {
            mesFalta = 0;
            volMin++;

            volMes[0] = volApr[0] - vU;

            if(volMes[0] < 0)
            {
                mesFalta++;
            }

            else if(volMes[0] > volMin)
            {
                volMes[0] = volMin;
            }

            for(int k = 1; k < 12; k++)
            {
                volMes[k] = volMes[k-1] + volApr[k] - vU;

                if(volMes[k] < 0) {mesFalta++;}
                else if(volMes[k] > volMin) { volMes[k] = volMin; }
            }

            if(mesFalta < 2) { break; }
            else if(volMin > 100) { volMin = -1; break; }
        }

        volMax = vU;

        while(true)
        {
            volMax++;
            volMes[0] = volApr[0] - vU;
            overTotal = 0;
            
            for(int k = 1; k < 12; k++)
            {
                overFlow[k] = volMes[k-1] + volApr[k] - vU - volMax;
                if(overFlow[k] < 0)
                {
                    overFlow[k] = 0;
                }

                overTotal += overFlow[k];
            }

            if(volMax > 100)
            {
                volMax = -1; break;
            }

            if(overTotal < volAprAnual * 0.1)
            {
                break;
            }

        }

        if(volMin == -1 || volMax == -1)
        {
            return "Não há um volume viavel cuja eficiencia e confiança sejam superiores à 90%";
        }

        else
        {
            return "Os volumes entre " + volMin + "m³ e " + volMax + "m³. Possuem eficiencia e confiança superiores à 90%";
        }

    }

    public void resetar() {
        volMin = 0;
        mesFalta = 0;
    }

}
