package simulation;

class Bille extends Visuel
{
	private String couleur;
	private double x;
	private double y;
    private double rotation;
	private double masse;
	private Vecteur2D velocite;

    /** CONSTRUCTEURS **/
    public Bille(String couleur)
    {
        // Vecteur geometrique a deux dimensions representant le deplacement de la bille pour chaque frame
        this.velocite = new Vecteur2D();

        // Autres attributs
        this.couleur = couleur;
        this.setTaille(61.5 * Unites.MM);
        this.masse = 215 * Unites.GRAMME;
    }
    public Bille(String couleur, double taille, double masse)
    {
        // Vecteur geometrique a deux dimensions representant le deplacement de la bille pour chaque frame
        this.velocite = new Vecteur2D();

        // Autres attributs
        this.couleur = couleur;
        this.setTaille(taille);
        this.masse = masse;
    }

	/** GETTERS **/
	/**
	 * Couleur de la bille (exemple: 0xFF0055).
	 */
    public String getCouleur()
	{
		return this.couleur;
	}
	/**
	 * Masse de la bille.
	 */
	public double getMasse()
	{
		return masse;
	}

	/**
	 * Vecteur geometrique representant le deplacement de la bille par frame.
	 */
	public Vecteur2D getVelocite()
	{
		return this.velocite;
	}
	public void setVelocite(Vecteur2D value)
	{
		this.velocite = value;
	}
	/**
	 * Coordonnees.
	 */
	public double getX()
	{
		return this.x;
	}
	public void setX(double value)
	{
		this.x = value;
    }
    public double getY()
    {
        return this.y;
    }
    public void setY(double value)
    {
        this.y = value;
    }
    public double getRotation()
    {
        return this.rotation;
    }
    public void setRotation(double value)
    {
        this.rotation = value;
    }
	
	/** METHODES HERITEES **/
	public void dessiner()
	{
		
	}

	/** PRIVE **/
	private boolean dectecterCollision(Bille bille)
	{
		if(Math.round(bille.velocite.getModule() * 100) == 0)
        {
            double a = Outils.aireNombres(this.x, this.y, bille.x, bille.y, this.x + this.velocite.getX(), this.y + this.velocite.getY());
            double h = 2 * a / this.velocite.getModule();
            double di = Outils.distanceNombres(this.x, this.y, bille.x, bille.y);
            double df = Outils.distanceNombres(this.x + this.velocite.getX(), this.y + this.velocite.getY(), bille.x, bille.y);
            double alpha = Math.acos((di * di + this.velocite.getModule() * this.velocite.getModule() - df * df) / (2 * di * this.velocite.getModule()));
            double beta = Math.acos((df * df + this.velocite.getModule() * this.velocite.getModule() - di * di) / (2 * df * this.velocite.getModule()));


            return (((Math.round(h * 100) <= Math.round(this.getTaille() * 100)) && (alpha < (Math.PI / 2)) && (beta < (Math.PI / 2))) || (di <= this.getTaille()) || (df <= this.getTaille()));
        }
        else if (bille.velocite.getModule() > bille.getTaille() || this.velocite.getModule() > this.getTaille())
        {
            double h1 = 2 * Outils.aireNombres(this.x, this.y, bille.x, bille.y, this.x + this.velocite.getX(), this.y + this.velocite.getY()) / this.velocite.getModule();
            double h2 = 2 * Outils.aireNombres(this.x, this.y, bille.x, bille.y, bille.x + bille.velocite.getX(), bille.y + bille.velocite.getY()) / bille.velocite.getModule();
            Vecteur2D di = new Vecteur2D(this.x - bille.x, this.y - bille.y);
            Vecteur2D df = new Vecteur2D(this.x + this.velocite.getX() - bille.x - bille.velocite.getX(), this.y + this.velocite.getY() - bille.y - bille.velocite.getY());

            return ((df.getModule() < this.getTaille()) || ((h1 == h2) && ((di.getAngle() < 0 && df.getAngle() > 0) || (di.getAngle() > 0 && df.getAngle() < 0)))); 
        }
        else
        {
            double dX = this.getX() - bille.getX();
		    double dY = this.getY() - bille.getY();

		    double racineRayons = (this.getTaille() + bille.getTaille()) * 0.5;
		    racineRayons = racineRayons * racineRayons;

		    double racineDistance = (dX * dX) + (dY * dY);

            return Math.round(racineDistance * 100) <= Math.round(racineRayons * 10);
        }
	}
	private void calculerChocElastique(Bille bille)
	{
		double taille = (this.getTaille() + bille.getTaille()) / 2;

        // Repositionnement au point de contact
        // Vecteur distance entre les boules
		Vecteur2D delta = new Vecteur2D(this.x - bille.x, this.y - bille.y);
		double d = delta.getModule();
		// Distance de translation minimum pour pousser les boules
		if (d == 0)
		{
			d = (this.getTaille() + bille.getTaille()) * 0.5 - 1;
			delta = new Vecteur2D((this.getTaille() + bille.getTaille()) * 0.5, 0);
		}
		Vecteur2D mtd = delta.multiplier(((this.getTaille() + bille.getTaille()) * 0.5 - d) / d, false);

		// Masse inverse
		double im1 = 1 / this.getMasse();
		double im2 = 1 / bille.getMasse();

		// Repousser les balles pour �viter qu'elles se chevauchent
		Vecteur2D correction = mtd.multiplier(im1 / (im1 + im2), false);
		this.x += correction.getX();
		this.y += correction.getY();
		bille.x -= correction.getX();
		bille.y -= correction.getY();

		// Calcul de la base orthonorm�e (n,g)
		// n est perpendiculaire au plan de collision, g est tangent
		double nx = (bille.getX() - this.getX()) / taille;
		double ny = (bille.getY() - this.getY()) / taille;
		double gx = -ny;
		double gy = nx;

		// Calcul des vitesses dans cette base
		double v1n = nx * this.velocite.getX() + ny * this.velocite.getY();
		double v1g = gx * this.velocite.getX() + gy * this.velocite.getY();
		double v2n = nx * bille.velocite.getX() + ny * bille.velocite.getY();
		double v2g = gx * bille.velocite.getX() + gy * bille.velocite.getY();

		// Permute les coordonn�es n et conserve la vitesse tangentielle
		// Ex�cute la transformation inverse (base orthonorm�e => matrice transpos�e)
		this.velocite.setX(nx * v2n + gx * v1g);
		this.velocite.setY(ny * v2n + gy * v1g);
		bille.velocite.setX(nx * v1n + gx * v2g);
		bille.velocite.setY(ny * v1n + gy * v2g);
        ;
	}

	/** PUBLIQUE **/
   
	/**
	 * Teste la collision avec une autre bille, et applique le choc �lastique le cas �ch�ant.
	 * @param bille
	 */
	public boolean testerCollision(Bille bille)
	{
        boolean ans = dectecterCollision(bille);
		if (ans)
		{
			calculerChocElastique(bille);
		}
        return ans;
	}
	/**
	 * D�place la bille d'une frame avec application de la d�c�l�ration.
	 * @param multiplieur
	 */
	public void deplacer(boolean affiche)
	{
        this.x += this.velocite.getX();
        this.y += this.velocite.getY();

        this.rotation += this.velocite.getModule() * 3;

        if (this.velocite.getModule() > 0.03)
		{
            this.velocite.setModule(this.velocite.getModule() - (this.velocite.getModule() * Constantes.F + 0.03));
		}
		else
		{
            this.velocite.setModule(0);
		}
        if (affiche)
        {
            dessiner();
        }
	}
}