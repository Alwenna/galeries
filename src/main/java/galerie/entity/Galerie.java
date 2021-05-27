package galerie.entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
   
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    List<Exposition> evenements = new LinkedList<>();
    
    public float CAannuel(int annee) {
        float result = 0.0f;
        for (Exposition evenement : evenements)
            if (evenement.getDebut().getYear() == annee)
                result += evenement.CA();
        return result;
        // Peut s'écrire en utilisant l'API Stream 
        // cf. https://www.baeldung.com/java-stream-filter-lambda
        /*
        return evenements.stream()
                .filter( expo -> expo.getDebut().getYear() == annee) // On filtre sur l'annee
                .map(expo -> expo.CA()) // On garde le CA
                .reduce(0f, Float::sum); // On additionne
        */
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Exposition> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Exposition> evenements) {
        this.evenements = evenements;
    }
    
    

}
