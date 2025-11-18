package srcc;


import java.util.*;
import java.sql.Connection;

public class Main {
 public static void main(String[] args) {

     /* ---------------------------------------
              PARTIE 1 : CLASSES JAVA
        --------------------------------------- */

     GestionUtilisateurs gestion = new GestionUtilisateurs();

     // Create sample dates
     Date d1 = new Date();
     Date d2 = new Date();
     Date d3 = new Date();

     // Create Objects
     Utilisateur u1 = new Utilisateur("Ali Reda", "reda@bts-kendi.ma", d1);
     Utilisateur u2 = new Utilisateur("Samir Nouiri", "samir@gmail.com", d2); // email invalid
     Employe e1 = new Employe(d3, 1022, "Mohamed Idrissi", "idrissi@bts-kendi.ma", d1);
     Enseignant ens1 = new Enseignant("Maths", 12, d3, 5002, "Hiba Salma",
                                       "hiba@bts-kendi.ma", d2);

     // Ajouter utilisateurs
     gestion.ajouterUtilisateur(u1);
     gestion.ajouterUtilisateur(u2);
     gestion.ajouterUtilisateur(e1);
     gestion.ajouterUtilisateur(ens1);

     System.out.println("\n--- Liste des utilisateurs avant tri ---");
     gestion.afficherUtilisateurs();

     // Tri
     gestion.trierUtilisateurs();

     System.out.println("\n--- Liste des utilisateurs après tri ---");
     gestion.afficherUtilisateurs();

     // Serialization
     String fichier = "utilisateurs.dat";
     gestion.sauvegarderDansFichier(fichier);

     // Load from file
     GestionUtilisateurs gestion2 = new GestionUtilisateurs();
     gestion2.chargerDepuisFichier(fichier);

     System.out.println("\n--- Liste des utilisateurs chargés depuis fichier ---");
     gestion2.afficherUtilisateurs();


     /* ---------------------------------------
               PARTIE 2 : JDBC MySQL
        --------------------------------------- */

     System.out.println("\n===== TEST JDBC =====");

     Connection con = DatabaseUtils.connect();
     if (con == null) {
         System.out.println("Impossible de se connecter à la base de données.");
         return;
     }

     // Example CNE for tests
     String testCne = "CNE100";

     // 1) getEmail
     String email = DatabaseUtils.getEmailByCne(testCne, con);
     System.out.println("Email du CNE " + testCne + " = " + email);

     // 2) getTel
     String tel = DatabaseUtils.getTelByCne(testCne, con);
     System.out.println("Tel du CNE " + testCne + " = " + tel);

     // 3) getResult (moyenne)
     String result = DatabaseUtils.getResult(testCne, con);
     System.out.println("Moyenne du CNE " + testCne + " = " + result);

     // 4) updateEmail
     boolean updated = DatabaseUtils.updateEmail(testCne, "new.email@kendi.ma", con);
     System.out.println("Email mis à jour ? " + updated);

     // 5) insert student
     boolean inserted = DatabaseUtils.insertStudent(
             "CNE200", "0612003344", "test@kendi.ma", 14.5f, con);
     System.out.println("Insertion effectuée ? " + inserted);

     // 6) delete student
     boolean deleted = DatabaseUtils.deleteStudent("CNE200", con);
     System.out.println("Suppression effectuée ? " + deleted);

     // 7) Exists ?
     boolean exists = DatabaseUtils.studentExists(testCne, con);
     System.out.println("Étudiant existe ? " + exists);

     // 8) Show all students
     System.out.println("\n--- Liste des étudiants (Table) ---");
     DatabaseUtils.getAllStudents(con);

     try {
         con.close();
     } catch (Exception ignored) {}

     System.out.println("\n===== FIN DU PROGRAMME =====");
 }
}
