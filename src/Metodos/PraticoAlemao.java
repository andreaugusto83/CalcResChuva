package Metodos;

public class PraticoAlemao implements Metodos
{

    double vAp, demAnual, volume;
    public String calcula(double vU, double aC, double[] iPM, double cAP)
    {

    for(int i = 0; i <=11; i++)
        {
            vAp = vAp + iPM[i]/1000;
        }

        vAp = vAp * aC * cAP*0.85;
        demAnual = vU * 12;

        if(demAnual > vAp)
        {
            volume = vAp * 0.06;
        }

        else
        {
            volume = demAnual * 0.06;
        }

        return (int)volume + "m³";

    }

    public void resetar() {
        vAp = 0;
    }

}
