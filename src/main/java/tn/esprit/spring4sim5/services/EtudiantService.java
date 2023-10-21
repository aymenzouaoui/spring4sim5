package tn.esprit.spring4sim5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.repositories.EtudiantRepository;


@Service
public class EtudiantService implements IEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    
}
