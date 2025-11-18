package srcc;

//Utilisateur.java
import java.io.Serializable;
import java.util.Date;

public class Utilisateur implements Serializable, Comparable<Utilisateur> {
 private int idUser;
 private String nomComplet;
 private String email;
 private Date dateNaissance;
 private static int nbUsers = 0;

 // 1) incrIdUser (auto-increment helper)
 public static int incrIdUser() {
     nbUsers++;
     return nbUsers;
 }

 // 4) countUsers
 public static int countUsers() {
     return nbUsers;
 }

 // 2) verifEmail
 public String verifEmail(String email) {
     if (email != null && email.contains("@bts-kendi.ma")) {
         return email;
     } else {
         System.out.println("Attention email incorrect : email non ajouté");
         return null;
     }
 }

 // 3) Constructor with 3 params
 public Utilisateur(String nomComplet, String email, Date dateNaissance) {
     this.idUser = incrIdUser();
     this.nomComplet = nomComplet;
     String validated = verifEmail(email);
     if (validated != null) {
         this.email = validated;
         this.dateNaissance = dateNaissance;
     } else {
         // email invalid -> do not set email, but set other attributes
         this.email = null;
         this.dateNaissance = dateNaissance;
     }
 }

 // 5) toString returns name and email
 @Override
 public String toString() {
     String e = (email != null) ? email : "email non renseigné";
     return "Nom: " + nomComplet + " | Email: " + e;
 }

 // 6) getters and setters for idUser and nomComplet
 public int getIdUser() {
     return idUser;
 }

 public void setIdUser(int idUser) {
     this.idUser = idUser;
 }

 public String getNomComplet() {
     return nomComplet;
 }

 public void setNomComplet(String nomComplet) {
     this.nomComplet = nomComplet;
 }

 public String getEmail() {
     return email;
 }

 public Date getDateNaissance() {
     return dateNaissance;
 }

 public void setDateNaissance(Date dateNaissance) {
     this.dateNaissance = dateNaissance;
 }

 // 7) compareTo for sorting by nomComplet
 @Override
 public int compareTo(Utilisateur autre) {
     if (autre == null) return 1;
     if (this.nomComplet == null && autre.nomComplet == null) return 0;
     if (this.nomComplet == null) return -1;
     if (autre.nomComplet == null) return 1;
     return this.nomComplet.compareToIgnoreCase(autre.nomComplet);
 }
}
