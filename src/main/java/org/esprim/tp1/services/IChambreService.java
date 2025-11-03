package org.esprim.tp1.services;
import org.esprim.tp1.entity.Chambre;
import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
}
