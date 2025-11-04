public class Livre {
    private int code;
    private String titre;
    private String auteur;
    private int totalLivres;
    private int dispoLivres;

    public Livre (int code, String titre, String auteur, int totalLivres, int dispoLivres){
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;
        this.totalLivres = totalLivres;
        this.dispoLivres = dispoLivres;
    }

    public int getCode(){return code;}
    public String getTitre(){return titre;}
    public String getAuteur(){return auteur;}
    public int getTotalLivres(){return totalLivres;}
    public int getDispoLivres(){return dispoLivres;}

    public void setCode(int code){this.code = code;}
    public void setTitre(String titre){this.titre = titre;}
    public void setAuteur(String auteur){this.auteur = auteur;}
    public void setTotalLivres(int totalLivres){this.totalLivres = totalLivres;}
    public void setDispoLivres(int dispoLivres){this.dispoLivres = dispoLivres;}
    // creer une liste des livres ?
    public boolean emprunter() {
        if(this.dispoLivres > 0) {
            this.dispoLivres--;
            return true;
        } else {
            return false;
        }
    }
    public boolean rendre() {
        if(dispoLivres < totalLivres) {
            dispoLivres++;
            return true;
        } else {
            return false;
        }
    }
}
