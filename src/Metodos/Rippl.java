package Metodos;

public class Rippl implements Metodos
{
    double gM;
    double[] aA = new double[12];
    double absAnual;
    double[] sT = new double[12];
    double volume;

    public String calcula(double vU, double aC, double[] iPM, double cAP)
    {
        // vU = Demanda vaso; vC = demanda carro; vAJ = Demanda Area Jardim; vAP = Demanda piso;
        // aC = Area de captação; iPM = Indice Pluviometrico mensal; cAP = coeficiente Aproveitamento;

       gM = vU; // volume unitario mensal

//        gD = (double) 288/365;

       for(int i = 0; i <= 11; i++)
       {
       aA[i] = (iPM[i]/1000) * aC * (cAP); // Agua aproveitavel = indice pluviometrico do mês * area de captação
       // * aproveitamento.
       }

       for(int k = 0; k <= 11; k++)
       {
           absAnual = absAnual + aA[k];
       }

       if((gM) > absAnual)
       {
           return "Não se Aplica";
       }

        else
       {
           for(int j = 0; j <=11; j++)
           {
               sT[j] = gM - aA[j];
               
               if(sT[j] > 0)
               {
                   volume = volume + sT[j];
               }
           }

           return (int)volume + "m³"; // Arredondando sempre para cima o valor...

       }


    }

    public void resetar()
    {
        volume = 0;
    }

}
