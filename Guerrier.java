/*PROJET ALGORITHMIQUE
 * @author Mamadou CISSE & Anthonin
 */
public class Guerrier {
	
	private String nom;
	private int pointsDeVie;
	private boolean [] privilege = new boolean[5];
	
	
	public Guerrier(String nom, int pointsDeVie) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
	}


	public String getNom() {
		return nom;
	}


	public int getPointDeVie() {
		return pointsDeVie;
	}


	public void setPointDeVie(int pointsDeVie) {
		
		if( pointsDeVie<0) throw new IllegalArgumentException("Les points de vie que vous avez introduis sont negatifs");
		this.pointsDeVie = pointsDeVie;
	}
	
	public int donnerForceDeFrappe(){
		double pourcentageDeFrappe = 0.05;
		return (int)(pourcentageDeFrappe*pointsDeVie) ;
	}
	
	public boolean possede(int privilege){
		if(privilege>=this.privilege.length || privilege<0) return false;
		
		for(int i=0; i<this.privilege.length; i++){
			if(this.privilege[i]==true) return true;
		}
		
		return false;
	}
	
	public boolean possedeTous(int[] privilege){
		
		for(int i=0; i<privilege.length; i++){
			if(this.privilege[privilege[i]]==false)return false;
		}
		
		return true;
	}
	
	public boolean possedeAucun(int[] privilege){
		
		for(int i=0; i<privilege.length; i++){
			if(this.privilege[privilege[i]]==true)return false;
		}
		
		return true;
	}
	
	public boolean donnerPrivilege(int privilege){
		
		if(privilege>=this.privilege.length || privilege<0) return false;
		
		for(int i=0; i<this.privilege.length; i++){
			if(this.privilege[i]==true) return true;
			else{
				if(this.privilege[i]==false){
					this.privilege[i]=true;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean retirePrivilege(int privilege){
		
		if(privilege>=this.privilege.length || privilege<0) return false;
		
		for(int i=0; i<this.privilege.length; i++){
			if(this.privilege[i]==false) return true;
			
			else{
				
				if(this.privilege[i]==true){
					this.privilege[i]=false;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString(){
		String texte = nom + " , Points De Vie : " + pointsDeVie + " .Il possede ";
		String privilege="";
		
		for(int i=0; i<this.privilege.length; i++){
			if(possede(i)){
				privilege=i + " ,";
				texte += privilege;
			}
			
		}
		if(privilege.equals(null)) texte += "aucun privilege.";
		if(!privilege.equals(null))texte += " privileges.";
		return texte;
	}

}
