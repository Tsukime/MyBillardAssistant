package simulation;

class Table extends Visuel
{
    /** CONSTRUCTEUR **/
    public Table(double height, double width)
    {
        this.setHeight(height);
        this.setWidth(width);
    }

	/**
	 * Teste la collision de la bille avec les bords de la zone de jeu et applique la collision le cas echeant.
	 * @param bille
	 */
	public boolean testerCollision(Bille bille)
	{
        boolean answer = false;
		double taille = bille.getTaille() * 0.5;
		// Bord gauche
		if (bille.getX() - taille <= 0)
		{
            bille.setX(taille);
            bille.getVelocite().setX(bille.getVelocite().getX() * -1);
            answer = true;
		}
		// Bord droit
        else if (bille.getX() + taille >= this.getWidth())
		{
			bille.setX(this.getWidth() - taille);
            bille.getVelocite().setX(bille.getVelocite().getX() * -1);
            answer = true;
		}

		// Bord haut
		if (bille.getY() - taille <= 0)
		{
            bille.setY(taille);
            bille.getVelocite().setY(bille.getVelocite().getY() * -1);
            answer = true;
		}
		// Bord bas
        else if (bille.getY() + taille >= this.getHeight())
		{
            bille.setY(this.getHeight() - taille);
            bille.getVelocite().setY(bille.getVelocite().getY() * -1);
            answer = true;
		}
        return answer;
	}

    /** METHODES HERITEES **/
    public void dessiner()
    {

    }
}