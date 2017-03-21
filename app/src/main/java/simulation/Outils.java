package simulation;

class Outils
    {
        
        /**
         * Calcule et renvoie la distance entre les deux points formes par les coordonnees parssees en parametre.
         * @param    x1
         * @param    y1
         * @param    x2
         * @param    y2
         * @return    Distance en pixels
         */
        static public double distanceNombres(double x1, double y1, double x2, double y2)
        {
            double X = x2 - x1;
            double Y = y2 - y1;
            return Math.sqrt(X * X + Y * Y);
        }
        
        /**
         * Calcule et renvoie l'angle (en radians) entre les deux objets.
         * @param    obj1
         * @param    obj2
         * @return    Angle en radians
         */
        static public double angle(Vecteur2D obj1, Vecteur2D obj2)
        {
            return angleNombres(obj1.getX(), obj1.getY(), obj2.getX(), obj2.getY());
        }
        
        /**
         * Calcule et renvoie l'angle (en radians) entre les deux points formes par les coordonnees passees en parametre.
         * @param    x1
         * @param    y1
         * @param    x2
         * @param    y2
         * @return    Angle en radians
         */
        static public double angleNombres(double x1, double y1, double x2, double y2)
        {
            return Math.atan2(y2 - y1, x2 - x1);
        }

        /**
         * Calcule et renvoie l'aire d'un triangle d'apres trois couple de coordonnees
         * @param   x1
         * @param   y1
         * @param   x2
         * @param   y2
         * @param   x3
         * @param   y3
         * @return Aire en cm2
         */
        static public double aireNombres(double x1, double y1, double x2, double y2, double x3, double y3)
        {
            double a = distanceNombres(x1, y1, x2, y2), b = distanceNombres(x2, y2, x3, y3), c = distanceNombres(x3, y3, x1, y1);
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }