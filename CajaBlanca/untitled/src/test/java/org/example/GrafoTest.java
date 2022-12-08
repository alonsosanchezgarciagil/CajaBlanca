package org.example;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GrafoTest {

    private final Grafo grafo = new Grafo("src/main/java/org/example/grafoExample.txt");

    @BeforeEach
    public void setUp() {

    }

    /////////////////////// printListaAdyacentes ///////////////////////
        //La funcion solo imprime por pantalla  y es privada

    /////////////////////// todosVisitados ///////////////////////


    /////////////////////// componentsRelated ///////////////////////

    @Test
    public void throw_EmptyCollectionException_if_editor_is_empty_getLinea() {

        grafo.printGraph();
        grafo.kruskal();
        grafo.printGraph();

    }

    /////////////////////// BFS ///////////////////////

    /////////////////////// kruskal ///////////////////////
}
