package simulation;

import java.util.ArrayList;

class Billard
{
    // Elements
    public Table table;
    private ArrayList<Bille> billes;
    private Bille billeDeTir;
    private boolean toutesLesBillesSontImmobiles;
    private boolean bandeAvant;
    private boolean doubleTouche;
    private boolean chaine;
    private boolean toucheJ;
    private boolean toucheR;

    /** GETTERS **/
    public ArrayList<Bille> getBilles()
    {
        return billes;
    }

    public boolean coupReussi()
    {
        return (toucheJ && toucheR);
    }
    public boolean BandeAvant()
    {
        return bandeAvant;
    }
    public boolean DoubleTouche()
    {
        return doubleTouche;
    }
    public boolean enChaine()
    {
        return chaine;
    }

    /** CONSTRUCTEUR **/

    /**
     * @param type (310, 280, 260, suivant le billard joue)
     */
    public Billard(int type)
    {
        // Table
        switch (type)
        {
            case 310 :
                table = new Table(1.423 * Unites.METRE, 2.845 * Unites.METRE);
                break;
            case 280 :
                table = new Table(1.270 * Unites.METRE, 2.540 * Unites.METRE);
                break;
            case 260 :
                table = new Table(1.150 * Unites.METRE, 2.300 * Unites.METRE);
                break;
            default :
                table = new Table(1.270 * Unites.METRE, 2.540 * Unites.METRE);
                break;
        }

        //Billes
        billes = new ArrayList<Bille>();
        ArrayList<String> couleurs = new ArrayList<String>();
        couleurs.add("Blanche"); couleurs.add("Jaune"); couleurs.add("Rouge");
        for (int i = 0; i < 3; i++)
        {
            Bille bille = new Bille(couleurs.get(i));
            billes.add(bille);
            if (i == 0)
            {
                billeDeTir = bille;
            }
        }
    }

    /** PRIVE **/
    /**
     *@param puissance (en %) 
     *@param angle (en radians)
     */
    private void tirer(double puissance, double angle)
    {
        billeDeTir.getVelocite().setAngle(angle);
        billeDeTir.getVelocite().setModule((puissance/100*10));
    }
    private void deplacerBilles(boolean affiche)
    {
        boolean testBJ = false, testBR = false, testBJ2 = false, testBR2 = false, testE = false, testE2 = false;

        toutesLesBillesSontImmobiles = true;

        // D�tection des mouvements des billes
        if (billes.get(0).getVelocite().getModule() > 0 || billes.get(1).getVelocite().getModule() > 0 || billes.get(2).getVelocite().getModule() > 0)
        {
            toutesLesBillesSontImmobiles = false;
        }

        // Tests des collisions de chaque bille avec les autres billes
        if (billes.get(0).getVelocite().getModule() > 0)
        {
            testBJ = billes.get(0).testerCollision(billes.get(1));
            testBR = billes.get(0).testerCollision(billes.get(2));
        }
        if (billes.get(1).getVelocite().getModule() > 0)
        {
            testBJ2 = billes.get(1).testerCollision(billes.get(0));
            testE = billes.get(1).testerCollision(billes.get(2));
        }
        if (billes.get(2).getVelocite().getModule() > 0)
        {
            testE2 = billes.get(2).testerCollision(billes.get(2));
            testBR2 = billes.get(2).testerCollision(billes.get(0));
        }

        // D�placement des billes
        deplacerBille(billes.get(0), affiche);
        deplacerBille(billes.get(1), affiche);
        deplacerBille(billes.get(2), affiche);

        if ((testE || testE2) && (!toucheJ || !toucheR))
        {
            chaine = true;
        }
        if (testBJ || testBJ2)
        {
            if (toucheJ)
            {
                doubleTouche = true;
            }
            toucheJ = true;
        }
        if (testBR || testBR2)
        {
            if (toucheR)
            {
                doubleTouche = true;
            }
            toucheR = true;
        }
    }
    private void deplacerBille(Bille bille, boolean affiche)
    {
        // Mouvement de la bille (avec multiplicateur pour le ralenti)
        bille.deplacer(affiche);

        // D�tection des collisions de la bille avec les bords de la table
        boolean test = table.testerCollision(bille);
        if (test && !toucheJ && !toucheR)
        {
            bandeAvant = true;
        }
    }

    /** METHODES **/
	
    public void placerBilles(double blancheX, double blancheY, double jauneX, double jauneY, double rougeX, double rougeY)
    {
        // Initialisation des billes
        billes.get(0).setX(blancheX);
        billes.get(0).setY(blancheY);
        billes.get(0).setVelocite(new Vecteur2D(0,0));
        billes.get(1).setX(jauneX);
        billes.get(1).setY(jauneY);
        billes.get(1).setVelocite(new Vecteur2D(0, 0));
        billes.get(2).setX(rougeX);
        billes.get(2).setY(rougeY);
        billes.get(2).setVelocite(new Vecteur2D(0, 0));
    }
	
    /**
     * @param puissance (%)
     * @param angle (radians)
     */
    public void nouveauCoup(double puissance, double angle, boolean AvecBandeAvantEtBosses, boolean affiche)
    {
        toucheJ = false;
        toucheR = false;
        toutesLesBillesSontImmobiles = false;
        chaine = false;
        bandeAvant = false;
        doubleTouche = false;
        tirer(puissance, angle);
        while (!toutesLesBillesSontImmobiles)
        {
            deplacerBilles(affiche);
            if (!AvecBandeAvantEtBosses && (bandeAvant || doubleTouche || chaine))
            {
                return;
            }
        }
    }

    public void dessiner(String add)
    {
    	
    }
}