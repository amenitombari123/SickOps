package com.esprit.examen.services;


import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceImplTest {
    @Mock
    private OperateurRepository or;

    private Operateur oo1 = new Operateur(11L,"fatma","daâs","546125",null);
    private Operateur oo2 = new Operateur(22L,"Fatma","daâs","546125",null);

    List<Operateur> listop = new ArrayList<Operateur>() {
        {

            add(new Operateur(10L, "c5", "lait", "null",null));
            add(new Operateur(60L, "4503","produit3","null",null));
        }
    };

    @InjectMocks
    OperateurServiceImpl cps;

    @Test
    public void addOperateur() {
        when(or.save(oo1)).thenReturn(oo1);
        assertNotNull(oo1);
        assertEquals(oo1, cps.addOperateur(oo1));
        System.out.println("add works !");
    }

    @Test
    public void deleteOperateur() {
        or.save(oo1);
        cps.deleteOperateur(oo1.getIdOperateur());


        verify(or, times(1)).deleteById(oo1.getIdOperateur());
        System.out.println("Delete works !");
    }
}