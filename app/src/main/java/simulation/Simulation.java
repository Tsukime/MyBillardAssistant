package simulation;

import java.util.ArrayList;

import com.incoherentglitch.mybillardassistant.ShowSol;

import android.os.AsyncTask;



public class Simulation extends AsyncTask<Void, Void, Void>
{
	int type;
	double blancheX, blancheY, jauneX, jauneY, rougeX, rougeY;
	ShowSol drawView;
	public double[] resultat;
	
	protected Void doInBackground(Void... params) {
		resultat = MeilleurCoup(type, blancheX, blancheY, jauneX, jauneY, rougeX, rougeY);
		return null;
	}
	
	//private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
	protected void onPostExecute(Void result) {
		drawView.setAngle(resultat[1]);
		drawView.update();
		
		
		// fait disparaitre le message "calcul trouve"
		/*Runnable task = new Runnable() {
		    public void run() {
		    	drawView.hideMsg();
		    	drawView.update();
		    }
		};
		worker.schedule(task, 3, TimeUnit.SECONDS);//*/
	}
	
	public void updateParam(ShowSol drawView, int type, double blancheX, double blancheY, double jauneX, double jauneY, double rougeX, double rougeY){
		this.drawView = drawView;
		this.type = type;
		this.blancheX = blancheX;
		this.blancheY = blancheY;
		this.jauneX = jauneX;
		this.jauneY = jauneY;
		this.rougeX = rougeX;
		this.rougeY = rougeY;
	}
	/**
     * Teste pour chaque angle (par pas de 1 degres) toutes les puissances possible (1-100%) et renvoi le couple angle puissance pour laquelle l'aire formee par les trois billes et minimale
     * @param type
     * @param blancheX
     * @param blancheY
     * @param jauneX
     * @param jauneY
     * @param rougeX
     * @param rougeY
     * @return puissance, angle
     */
    static public double[] MeilleurCoup(int type, double blancheX, double blancheY, double jauneX, double jauneY, double rougeX, double rougeY)
    {
        double aire, perimetre = 0, maxAngleJ, minAngleJ, iter, maxAngleR, minAngleR, maxAngle, minAngle, avantSaut, apresSaut;
        boolean saut = false;
        double[] rep = {101,0};
        double tempAire, meilleurPuissance = 0, MoyRef = 0;
        ArrayList<double[]> ans = new ArrayList<double[]>();
        Billard temp = new Billard(type);

        Vecteur2D directionJ = new Vecteur2D(jauneX - blancheX, jauneY - blancheY);
        Vecteur2D ecartJ1 = new Vecteur2D(0, 0);
        Vecteur2D ecartJ2 = new Vecteur2D(0, 0);
        ecartJ1.setModule(temp.getBilles().get(0).getTaille() * 1.5);
        ecartJ1.setAngle(directionJ.getAngle() + (Math.PI / 2));
        ecartJ2.setModule(temp.getBilles().get(0).getTaille() * 1.5);
        ecartJ2.setAngle(directionJ.getAngle() - (Math.PI / 2));
        Vecteur2D variationJ1 = new Vecteur2D(directionJ.getX() + ecartJ1.getX(), directionJ.getY() + ecartJ1.getX());
        Vecteur2D variationJ2 = new Vecteur2D(directionJ.getX() + ecartJ2.getX(), directionJ.getY() + ecartJ2.getX());
        if (variationJ1.getAngle() > variationJ2.getAngle())
        {
            maxAngleJ = variationJ1.getAngle();
            minAngleJ = variationJ2.getAngle();
        }
        else
        {
            maxAngleJ = variationJ2.getAngle();
            minAngleJ = variationJ1.getAngle();
        }
        Vecteur2D directionR = new Vecteur2D(rougeX - blancheX, rougeY - blancheY);
        Vecteur2D ecartR1 = new Vecteur2D(0, 0);
        Vecteur2D ecartR2 = new Vecteur2D(0, 0);
        ecartR1.setModule(temp.getBilles().get(0).getTaille());
        ecartR1.setAngle(directionR.getAngle() + (Math.PI / 2));
        ecartR2.setModule(temp.getBilles().get(0).getTaille());
        ecartR2.setAngle(directionR.getAngle() - (Math.PI / 2));
        Vecteur2D variationR1 = new Vecteur2D(directionR.getX() + ecartR1.getX(), directionR.getY() + ecartR1.getX());
        Vecteur2D variationR2 = new Vecteur2D(directionR.getX() + ecartR2.getX(), directionR.getY() + ecartR2.getX());
        if (variationR1.getAngle() > variationR2.getAngle())
        {
            maxAngleR = variationR1.getAngle();
            minAngleR = variationR2.getAngle();
        }
        else
        {
            maxAngleR = variationJ2.getAngle();
            minAngleR = variationJ1.getAngle();
        }
        if (maxAngleJ > maxAngleR)
        {
            maxAngle = maxAngleJ;
            apresSaut = minAngleJ;
        }
        else
        {
            maxAngle = maxAngleR;
            apresSaut = minAngleR;
        }
        if (minAngleJ < minAngleR)
        {
            minAngle = minAngleJ;
            avantSaut = maxAngleJ;
        }
        else
        {
            avantSaut = maxAngleR;
            minAngle = minAngleR;
        }
        iter = minAngle;
        while (true)
        {
            meilleurPuissance = 0; 
            MoyRef = 0;
            aire = 5000;
            for (double j = 0; j <= 100; j += 1)
            {
            	temp.placerBilles((((temp.table.getWidth() + 10) * blancheX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * blancheY) - 5) * Unites.CM, (((temp.table.getWidth() + 10) * jauneX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * jauneY) - 5) * Unites.CM, (((temp.table.getWidth() + 10) * rougeX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * rougeY) - 5) * Unites.CM);
                temp.nouveauCoup(j, iter, false, false);
                if (temp.BandeAvant() || temp.DoubleTouche() || temp.enChaine())
                {
                    continue;
                }
                tempAire = Outils.aireNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                double a = Outils.distanceNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY());
                double b = Outils.distanceNombres(temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                double c = Outils.distanceNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                perimetre = a + b + c;
                //Choix!!
                double NoteAire = (((temp.table.getHeight() * temp.table.getWidth()) / 2) - tempAire) * 100 / ((temp.table.getHeight() * temp.table.getWidth()) / 2);
                double NotePeri = ((temp.table.getWidth() + temp.table.getHeight() + Math.sqrt(temp.table.getWidth() * temp.table.getHeight() * temp.table.getWidth() * temp.table.getHeight())) - perimetre) * 100 / (temp.table.getWidth() + temp.table.getHeight() + Math.sqrt(temp.table.getWidth() * temp.table.getHeight() * temp.table.getWidth() * temp.table.getHeight()));
                double NotePow = 100 - meilleurPuissance;
                double Moyenne = ((NoteAire / 10) + (NotePeri * 10) + (NotePow * 5));
                if ((Moyenne > MoyRef) && temp.coupReussi())
                {
                    MoyRef = Moyenne;
                    aire = tempAire;
                    meilleurPuissance = j;
                }
            }
            if (meilleurPuissance > 0)
            {
                double[] ajout = {meilleurPuissance, iter, aire, perimetre, MoyRef};
                if(ans.size() == 0)
                {
                    ans.add(ajout);
                }
                else
                {
                    for (int j = 0; j < ans.size(); j++)
                    {
                        if (ans.get(j)[4] < MoyRef)
                        {
                            ans.add(j, ajout);
                            if (ans.size() > 10)
                            {
                                ans.remove(10);
                            }
                            break;
                        }
                        if (j == ans.size() - 1 && ans.size() < 10)
                        {
                            ans.add(ajout);
                            break;
                        }
                    }
                }
            }
            if (iter < avantSaut && !saut)
            {
                iter += (avantSaut - minAngle) / 100;
            }
            if (iter >= avantSaut && !saut)
            {
                iter = apresSaut;
                saut = true;
            }
            if (iter < maxAngle && saut)
            {
                iter += (maxAngle - apresSaut) / 100;
            }
            if (iter >= maxAngle && saut)
            {
                break;
            }
        }
        if (ans.size() == 0)
        {
            System.out.println("Pas de coup facile.");
            double[] joker = Simulation.MeilleurCoupAvance(type, blancheX, blancheY, jauneX, jauneY, rougeX, rougeY, false);
            return joker;
        }
        System.out.println(ans.size() + " coups trouves : ");
        aire = 5000;
        MoyRef = 0;
        for (int i = 0; i < ans.size(); i++)
        {
        	System.out.println("\tPow : " + ans.get(i)[0] + "%, Angle : " + ans.get(i)[1] + ", A: " + ans.get(i)[2] + ", P: " + ans.get(i)[3] + ", N: " + ans.get(i)[4] / 1000);
        }
        rep[0] = ans.get(0)[0];
        rep[1] = ans.get(0)[1];
        return rep;
    }

    static private double[] MeilleurCoupAvance(int type, double blancheX, double blancheY, double jauneX, double jauneY, double rougeX, double rougeY, boolean AvecBanceAvantEtBossesFortes)
        {
            double aire, perimetre = 0;
            double[] rep = {101,0};
            double tempAire, meilleurPuissance = 0, MoyRef = 0;
            ArrayList<double[]> ans = new ArrayList<double[]>();
            Billard temp = new Billard(type);
            for (double i = 0; i < 360; i += 1)
            {
                meilleurPuissance = 0; 
                MoyRef = 0;
                aire = 5000;
                for (double j = 0; j <= 100; j += 1)
                {
                	temp.placerBilles((((temp.table.getWidth() + 10) * blancheX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * blancheY) - 5) * Unites.CM, (((temp.table.getWidth() + 10) * jauneX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * jauneY) - 5) * Unites.CM, (((temp.table.getWidth() + 10) * rougeX) - 5) * Unites.CM, (((temp.table.getHeight() + 10) * rougeY) - 5) * Unites.CM);
                    temp.nouveauCoup(j, i * Unites.DEGRES, true, false);
                    if ((temp.BandeAvant() || temp.DoubleTouche() ||temp.enChaine()) && !AvecBanceAvantEtBossesFortes && (j > 30))
                    {
                        continue;
                    }
                    tempAire = Outils.aireNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                    double a = Outils.distanceNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY());
                    double b = Outils.distanceNombres(temp.getBilles().get(1).getX(), temp.getBilles().get(1).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                    double c = Outils.distanceNombres(temp.getBilles().get(0).getX(), temp.getBilles().get(0).getY(), temp.getBilles().get(2).getX(), temp.getBilles().get(2).getY());
                    perimetre = a + b + c;
                    //Choix!!
                    double NoteAire = (((temp.table.getHeight() * temp.table.getWidth()) / 2) - tempAire) * 100 / ((temp.table.getHeight() * temp.table.getWidth()) / 2);
                    double NotePeri = ((temp.table.getWidth() + temp.table.getHeight() + Math.sqrt(temp.table.getWidth() * temp.table.getHeight() * temp.table.getWidth() * temp.table.getHeight())) - perimetre) * 100 / (temp.table.getWidth() + temp.table.getHeight() + Math.sqrt(temp.table.getWidth() * temp.table.getHeight() * temp.table.getWidth() * temp.table.getHeight()));
                    double NotePow = 100 - meilleurPuissance;
                    double Moyenne = ((NoteAire) + (NotePeri * 10) + (NotePow * 5));
                    if ((Moyenne > MoyRef) && temp.coupReussi())
                    {
                        MoyRef = Moyenne;
                        aire = tempAire;
                        meilleurPuissance = j;
                    }
                }
                if (meilleurPuissance > 0)
                {
                    double[] ajout = {meilleurPuissance, i * Unites.DEGRES, aire, perimetre, MoyRef};
                    if(ans.size() == 0)
                    {
                        ans.add(ajout);
                    }
                    else
                    {
                        for (int j = 0; j < ans.size(); j++)
                        {
                            if (ans.get(j)[4] < MoyRef)
                            {
                                ans.add(j, ajout);
                                if (ans.size() > 10)
                                {
                                    ans.remove(10);
                                }
                                break;
                            }
                            if (j == ans.size() - 1 && ans.size() < 10)
                            {
                                ans.add(ajout);
                                break;
                            }
                        }
                    }
                }
            }
            if (ans.size() == 0 && !AvecBanceAvantEtBossesFortes)
            {
               	System.out.println("Pas de coup moyen.");
                double[] joker = Simulation.MeilleurCoupAvance(type, blancheX, blancheY, jauneX, jauneY, rougeX, rougeY, true);
                if(joker[0] == 101){
                    System.out.println("Pas de coups");
                }
                else{
                    return joker;
                }
            }
            System.out.println(ans.size() + " coups trouves : ");
            aire = 5000;
            MoyRef = 0;
            for (int i = 0; i < ans.size(); i++)
            {
            	System.out.println("\tPow: " + ans.get(i)[0] + "%, Angle: " + ans.get(i)[1] + ", A: " + ans.get(i)[2] + ", P: " + ans.get(i)[3] + ", N: " + ans.get(i)[4]);
            }
            rep[0] = ans.get(0)[0];
            rep[1] = ans.get(0)[1];
            return rep;
        }	
}