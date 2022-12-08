package org.example;


import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import static org.junit.Assert.*;

public class EditorTest {

    private final Editor editor = new Editor();

    /////////////////////// getLinea ///////////////////////
    @Test
    public void throw_EmptyCollectionException_if_editor_is_empty_getLinea() {

        EmptyCollectionException thrown = Assertions.assertThrows(EmptyCollectionException.class, () -> {
            editor.getLinea(1);
        });
        assertNotNull(thrown);
        assertEquals(" editor vacío ", thrown.getMessage());

    }

    @Test
    @Tag("C2")
    public void throw_IllegalArgumentException_if_line_is_higher_than_size_getLinea() {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            editor.getLinea(5);
        });
        assertNotNull(thrown);
        assertEquals("No existe la linea 5", thrown.getMessage());

    }

    @Test
    @Tag("C3")
    public void return_line_getLinea() throws EmptyCollectionException {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        AbstractSingleLinkedListImpl<String> res = editor.getLinea(1);

        assertEquals("[a]", res.toString());

    }

    @Test
    @Tag("C4")
    public void throw_IllegalArgumentException_if_line_is_lower_than_0_getLinea() {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            editor.getLinea(-2);
        });
        assertNotNull(thrown);
        assertEquals("No existe la linea -2", thrown.getMessage());

    }

    /////////////////////// numApariciones ///////////////////////

    @Test
    public void throw_IllegalArgumentException_if_inicio_is_incorrect_numApariciones() {

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            editor.numApariciones(-1,1,"a");
        });
        assertNotNull(thrown);
        assertEquals("La línea de inicio no puede ser menor o igual a cero", thrown.getMessage());

    }

    @Test
    public void throw_IllegalArgumentException_if_fin_is_higher_than_size_numApariciones() {

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            editor.numApariciones(1,5,"a");
        });
        assertNotNull(thrown);
        assertEquals("La línea fin no puede ser mayor que el máximo de líneas", thrown.getMessage());

    }

    @Test
    public void return_0_if_editor_is_empty_numApariciones() {

        int res = editor.numApariciones(1,0,"a");
        assertEquals(0, res);

    }

    @Test
    public void return_0_if_fin_is_lower_than_inicio_numApariciones() {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        int res = editor.numApariciones(1,0,"a");
        assertEquals(0, res);

    }

    @Test
    public void return2_0_if_fin_is_lower_than_inicio_numApariciones() {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        int res = editor.numApariciones(1,1,"a");
        assertEquals(1, res);

    }

    /////////////////////// numPalabras ///////////////////////

    @Test
    public void thrown_EmptyCollectionException_numPalabras() {

        EmptyCollectionException thrown = Assertions.assertThrows(EmptyCollectionException.class, () -> {
            editor.numPalabras();
        });
        assertNotNull(thrown);
        assertEquals("El editor está vacío", thrown.getMessage());

    }

    @Test
    public void return_palabras_numPalabras() throws EmptyCollectionException {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        int res = editor.numPalabras();

        assertEquals(1, res);

    }

    /////////////////////// palabraMasLarga ///////////////////////

    @Test
    public void return_null_palabraMasLarga() throws EmptyCollectionException {

        String res = editor.palabraMasLarga();

        assertNull(res);

    }

    @Test
    public void return2_palabra_palabraMasLarga() throws EmptyCollectionException {

        editor.cargarEditor("src/main/java/org/example/palabraMasLarga.txt");
        String res = editor.palabraMasLarga();

        assertEquals("Pleaseunsubscribe", res);

    }

    /////////////////////// existePalabra ///////////////////////

    @Test
    public void return_false_if_editor_is_empty_existePalabra() {

        Boolean res = editor.existePalabra("b");
        assertEquals(false, res);

    }

    @Test
    public void return_false_if_palabra_does_not_exist_existePalabra() {

        editor.cargarEditor("src/main/java/org/example/tt.txt");
        Boolean res = editor.existePalabra("b");
        assertEquals(false, res);

    }

    @Test
    public void return_true_if_palabra_exists_existePalabra() {

        editor.cargarEditor("src/main/java/org/example/palabraMasLarga.txt");
        Boolean res = editor.existePalabra("evolution");
        assertEquals(true, res);

    }

    /////////////////////// sustituirPalabra ///////////////////////

    @Test
    public void return_true_if_palabra_exists_sustituirPalabra() {

        editor.cargarEditor("src/main/java/org/example/palabraMasLarga.txt");
        assertEquals(true, editor.existePalabra("when"));
        assertEquals(false, editor.existePalabra("palabraRamdon"));

        editor.sustituirPalabra("when","palabraRamdon");
        assertEquals(false, editor.existePalabra("when"));
        assertEquals(true, editor.existePalabra("palabraRamdon"));


    }

}
