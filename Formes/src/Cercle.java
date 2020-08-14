public class Cercle extends Figure{
  private int rayon;

public Cercle (int x, int y, int rayon, boolean b){ // constructeur
  super(x,y,b);
  this.rayon= rayon;
}

public int getRayon(){ // getter
  return this.rayon;
}
public String toString(){
  String k = new String (super.toString() + "Rayon du cercle= "+this.rayon);
  return k;
}
}
