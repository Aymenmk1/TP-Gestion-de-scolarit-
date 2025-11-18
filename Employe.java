package srcc;

//Employe.java
import java.io.Serializable;
import java.util.Date;

public class Employe extends Utilisateur implements Serializable {
 private Date dateRecrutement;
 private int ppr;

 // 8) Constructor with 5 params
 public Employe(Date dateRecrutement, int ppr, String nomComplet, String email, Date dateNaissance) {
     super(nomComplet, email, dateNaissance);
     this.dateRecrutement = dateRecrutement;
     this.ppr = ppr;
 }

 // 9) equals comparing idUser
 public boolean equals(Employe e) {
     if (e == null) return false;
     return this.getIdUser() == e.getIdUser();
 }

 // 10) getIdUser (override) - simply return parent's id
 @Override
 public int getIdUser() {
     return super.getIdUser();
 }

 // 11) toString returns all attributes (use super.toString())
 @Override
 public String toString() {
     String parent = super.toString();
     String dr = (dateRecrutement != null) ? dateRecrutement.toString() : "N/A";
     return parent + " | PPR: " + ppr + " | DateRecrutement: " + dr;
 }

 public Date getDateRecrutement() {
     return dateRecrutement;
 }

 public int getPpr() {
     return ppr;
 }
}
