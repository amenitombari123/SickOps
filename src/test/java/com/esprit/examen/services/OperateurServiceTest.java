

package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.OneToMany;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceTest {
    @Mock
    private OperateurRepository or;

    private Operateur oo1 = new Operateur(11L, "fatma", "daâs", "546125");
    private Operateur oo2 = new Operateur(22L, "Fatma", "daâs", "546125");
    List<Operateur> listop = new ArrayList<Operateur>() {
        {

            add(new Operateur(10L, "c5", "lait", null));
            add(new Operateur(60L, "4503", "produit3", null));
        }
    };
    @InjectMocks
    OperateurServiceImpl cps;


    @Test
    public void addOP() {
        when(or.save(oo1)).thenReturn(oo1);
        assertNotNull(oo1, "");
        assertEquals(oo1, cps.addOperateur(oo1), "");
        System.out.println("add works !");
    }

    @Test
    public void testretrieveAllOP() {
       when(or.findAll()).thenReturn(listop);
        List<Operateur> listop3 = cps.retrieveAllOperateurs();
        assertEquals(2, listop3.size());
        //assertEquals(produit1.getIdProduit(),55L);
    }



}