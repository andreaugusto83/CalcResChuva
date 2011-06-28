package Metodos;

public class PraticoIngles implements Metodos
{
    double vAp, volume;
    public String calcula(double vU, double aC, double[] iPM, double cAP) {

        for(int i = 0; i <=11; i++)
        {
            vAp = vAp + iPM[i] / 1000;
        }
        volume = vAp * aC * 0.05;
        return (int)volume + "m³";
    }

    public void resetar() {
        vAp = 0;
    }

}
