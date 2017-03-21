package simulation;

abstract class Visuel
    {
        private double taille = 0;
        private double height = 0;
        private double width = 0;

        public Visuel()
        {

        }
        /** PRIVE **/
        public abstract void dessiner();
        /** GETTERS **/
        public double getWidth()
        {
            return this.width;
        }
        public void setWidth(double value)
        {
            this.width = value;
        }
        public double getHeight()
        {
            return this.height;
        }
        public void setHeight(double value)
        {
            this.height = value;
        }
        /**
         * Taille de l'objet visuel au cas ou il n'a besoin que d'un nombre (exemple : diametre).
         */
        public double getTaille()
        {
            return this.taille;
        }
        
        public void setTaille(double value)
        {
            this.taille = value;
        }
    }
