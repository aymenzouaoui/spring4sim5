package tn.esprit.spring4sim5.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring4sim5.entiies.Etudiant;
import tn.esprit.spring4sim5.entiies.Typechambre;

import java.util.List;

public interface iEtudiantService {

    Etudiant ajouterEtudiant(Etudiant etudiant);


    Etudiant mettreAJourEtudiant(Etudiant etudiant);


    void supprimerEtudiant(Long id);


    Etudiant getEtudiantParId(Long id);


    List<Etudiant> getTousLesEtudiants();
  //  public  List<Etudiant> rechercheReservationChambreTypec(Typechambre T);

    @Query("SELECT e FROM Etudiant e " +
            "JOIN e.reservations r " +
            "JOIN r.chambres c " +
            "JOIN c.bloc b " +
            "WHERE b.idbloc = :idBloc")
    List<Etudiant> findListReservationByBlocID(@Param("idBloc") Long idBloc);

}
