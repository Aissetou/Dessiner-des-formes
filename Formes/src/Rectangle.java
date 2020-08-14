public class Rectangle extends Figure{
  private int longueur;
  private int largeur;


public Rectangle(int x, int y, int longueur, int largeur,boolean b){ // constructeur membre à membre
  super(x,y,b); // appel dans la classe parent
  this.longueur=longueur;
  this.largeur=largeur;
}

public int getLargeur(){ // getter
  return this.largeur;
}

public int getLongueur(){
  return this.longueur;
}

public String toString(){
  String k= new String(super.toString() + "Longueur = " + this.longueur + ", Largeur = " + this.largeur);
  return k;
}
}
