public class Ellipse extends Figure{
  private int hauteur;
  private int longueur;

public Ellipse (int x, int y, int hauteur, int longueur, boolean b){ // constructeur
  super(x,y,b);
  this.hauteur= hauteur;
  this.longueur=longueur;

}

public int getHauteur(){ // getter
  return this.hauteur;
}

public int getLongueur(){
  return this.longueur;
}
public String toString(){
  String k= new String(super.toString() + "Longueur = " + this.longueur + ", Hauteur = " + this.hauteur);
  return k;
}
}
