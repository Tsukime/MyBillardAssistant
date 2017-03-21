package simulation;

class Vecteur2D
    {
        private double x;
        private double y;
        
        private double module = 0;
        private double angle = 0;
        
        public Vecteur2D()
        {
        	this.x = 0;
            this.y = 0;
            this.calculAngleModule();
        }
        
        public Vecteur2D(double x, double y) 
        {
        	this.x = x;
            this.y = y;
            this.calculAngleModule();
        }
        
        public String toString()
        {
            return "[Vecteur2D x=" + this.x + " y=" + this.y + " module=" + this.module + " angle=" + this.angle + "]";
        }
        
        /**
         * Revoie une copie du vecteur.
         * @return
         */
        public Vecteur2D clone()
        {
            Vecteur2D c = new Vecteur2D();
            c.x = this.x;
            c.y = this.y;
            return c;
        }
        
        /**
         * Ajoute le vecteur passe en parametre au vecteur courant.
         * @param vecteur   Vecteur a ajouter.
         * @param apply     Si vrai, modifie directement le vecteur courant. Sinon, renvoie un nouveau vecteur.
         * @return          Le vecteur representant la somme des deux premiers vecteurs.
         */
        public Vecteur2D ajouter(Vecteur2D vecteur, Boolean apply)
        {
            Vecteur2D cible;
            if (apply)
            {
                cible = this;
            }
            else
            {
                cible = clone();
            }
            cible.x += vecteur.x;
            cible.y += vecteur.y;
            return cible;
        }
        
        /**
         * Soustrait le vecteur passe en parametre au vecteur courant.
         * @param vecteur   Vecteur a soustraire.
         * @param apply     Si vrai, modifie directement le vecteur courant. Sinon, renvoie un nouveau vecteur.
         * @return          Le vecteur representant la soustraction des deux premiers vecteurs.
         */
        public Vecteur2D soustraire(Vecteur2D vecteur, Boolean apply)
        {
            Vecteur2D cible;
            if (apply)
            {
                cible = this;
            }
            else
            {
                cible = clone();
            }
            cible.x -= vecteur.x;
            cible.y -= vecteur.y;
            return cible;
        }
        
        /**
         * Multiplie le vecteur par un coefficient numerique.
         * @param coef      Coefficient numerique.
         * @param apply     Si vrai, modifie directement le vecteur courant. Sinon, renvoie un nouveau vecteur.
         * @return          Le vecteur ayant recu la multiplication.
         */
        public Vecteur2D multiplier(double coef, Boolean apply)
        {
            Vecteur2D cible;
            if (apply)
            {
                cible = this;
            }
            else
            {
                cible = clone();
            }
            cible.x *= coef;
            cible.y *= coef;
            return cible;
        }
        
        /**
         * Normalise le vecteur (c'est-a-dire modifie ses coordonnees x et y telles que son module vaille 1).
         * @param apply     Si vrai, modifie directement le vecteur courant. Sinon, renvoie un nouveau vecteur.
         * @return          Le vecteur normalise.
         */
        public Vecteur2D normaliser(Boolean apply)
        {
            Vecteur2D cible;
            if (apply)
            {
                cible = this;
            }
            else
            {
                cible = clone();
            }
            double m = cible.module;
            if (m != 0)
            {
                cible.x /= m;
                cible.y /= m;
            }
            else
            {
                cible.x = 0;
                cible.y = 0;
            }
            return cible;
        }
        
        /**
         * Calcule le produit du vecteur courant avec le vecteur passe en parametre.
         * @param vecteur       Le vecteur a multiplier avec le vecteur courant.
         * @return              Nombre resultant de la multiplication des deux vecteurs.
         */
        public double produit(Vecteur2D vecteur)
        {
            return this.x * vecteur.x + this.y + vecteur.y;
        }
        
        /* PRIVE */
        
        private void calculCoord()
        {
            if (this.module == 0)
            {
                this.x = 0;
                this.y = 0;
            }
            else
            {
                this.x = Math.cos(angle) * this.module;
                this.y = Math.sin(angle) * this.module;
            }
        }
        
        private void calculAngleModule()
        {
            if (this.x == 0 && this.y == 0)
            {
                this.angle = 0;
                this.module = 0;
            }
            else
            {
                this.module = Outils.distanceNombres(0, 0, this.x, this.y);
                this.angle = Outils.angleNombres(0, 0, this.x, this.y);
            }
        }
        
        /* GETTERS */
        
        /**
         * Coordonnee horizontale.
         */
        public double getX()
        {
            return this.x;
        }
        
        public void setX(double value)
        {
            this.x = value;
            this.calculAngleModule();
        }
        
        /**
         * Coordonnee verticale.
         */
        public double getY()
        {
            return this.y;
        }
        
        public void setY(double value)
        {
            this.y = value;
            this.calculAngleModule();
        }
        
        /**
         * Module (longeur du vecteur).
         */
        public double getModule()
        {
            return this.module;
        }
        
        public void setModule(double value)
        {
            this.module = value;
            this.calculCoord();
        }
        
        /**
         * Angle du vecteur par rapport a l'horizontale.
         */
        public double getAngle()
        {
            return this.angle;
        }
        
        public void setAngle(double value)
        {
            this.angle = value;
            this.calculCoord();
        }
    }
