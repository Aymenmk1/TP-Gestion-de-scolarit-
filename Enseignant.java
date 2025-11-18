package srcc;

//Enseignant.java
import java.io.Serializable;
import java.util.Date;

public class Enseignant extends Employe implements Serializable {
 private String discipline;
 private int nbHeure;

 // 1) Constructor with 7 params
 public Enseignant(String discipline, int nbHeure, Date dateRecrutement, int ppr,
                   String nomComplet, String email, Date dateNaissance) {
     super(dateRecrutement, ppr, nomComplet, email, dateNaissance);
     this.discipline = discipline;
     this.nbHeure = nbHeure;
 }

 // 2) isOfTheSameClassAs: returns true if same runtime class
 public boolean isOfTheSameClassAs(Object o) {
     if (o == null) return false;
     return this.getClass().equals(o.getClass());
 }

 // 3) toString uses super.toString and adds fields
 @Override
 public String toString() {
     return super.toString() + " | Discipline: " + discipline + " | NbHeures: " + nbHeure;
 }

 // 4) afficher prints all coordinates (console)
 public void afficher() {
     System.out.println(this.toString());
 }

 public String getDiscipline() {
     return discipline;
 }

 public int getNbHeure() {
     return nbHeure;
 }
}
