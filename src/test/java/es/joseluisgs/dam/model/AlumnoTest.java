package es.joseluisgs.dam.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Case Alumno Class")
public class AlumnoTest {
    private Alumno alumno = new Alumno("Pepe", 20, 8.25f);

    @BeforeEach
    void restAlumno() {
        alumno = new Alumno("Pepe", 20, 8.25f);
    }

    @Test
    @Order(1)
    @DisplayName("Test Case Alumno Constructor")
    void testConstructor() {
        Alumno alumno = new Alumno("Ana", 25, 9.75f);
        Assertions.assertAll(
                () -> assertEquals("Ana", alumno.getNombre()),
                () -> assertEquals(25, alumno.getEdad()),
                () -> assertEquals(9.75f, alumno.getNota())
        );
    }


    @Test
    void testGetNombre() {
        assertEquals("Pepe", alumno.getNombre());
    }

    @Test
    void testSetNombre() {
        alumno.setNombre("Ana");
        assertEquals("Ana", alumno.getNombre());
    }

    @Test
    void testSetNombreExceptions() {
        // Excepcion Con blancos
        IllegalArgumentException thrown;

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setNombre(" ");
        }, "IllegalArgumentException expected");

        assertEquals("El nombre no puede estar vacío ni tener más de 100 caracteres", thrown.getMessage());

        // Excepcion nada
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setNombre("");
        }, "IllegalArgumentException expected");

        assertEquals("El nombre no puede estar vacío ni tener más de 100 caracteres", thrown.getMessage());

        // Excepcion null
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setNombre(null);
        }, "IllegalArgumentException expected");

        assertEquals("El nombre no puede estar vacío ni tener más de 100 caracteres", thrown.getMessage());

        // Excepcion mayor de 100 caracteres
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            // String 100 chars
            alumno.setNombre("Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos provident omnis culpa, voluptatibus natus cum saepe mollitia architecto ipsum repellendus in nam dolore quidem? Enim corporis repellendus odio inventore praesentium ut aperiam dicta, molestias dolor. Officia dicta ipsa amet rem atque modi labore velit numquam id earum veritatis unde nihil nostrum reiciendis possimus iusto, eveniet repellat, placeat deleniti? Ad odio, impedit corrupti consequuntur assumenda vero! Iste, hic temporibus. Sit delectus quas quaerat natus ipsum, excepturi laboriosam quod doloribus perferendis aperiam asperiores voluptatum neque rerum cumque qui. Consequuntur, ratione ex. Maiores dolor, quidem quas quibusdam fugiat sit debitis quasi alias officia.");
        }, "IllegalArgumentException expected");

        Assertions.assertEquals("El nombre no puede estar vacío ni tener más de 100 caracteres", thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            // String 100 chars
            alumno.setNombre("Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos provident omnis culpa, voluptatibus natus cum saepe mollitia architecto ipsum repellendus in nam dolore quidem? Enim corporis repellendus odio inventore praesentium ut aperiam dicta, molestias dolor. Officia dicta ipsa amet rem atque modi labore velit numquam id earum veritatis unde nihil nostrum reiciendis possimus iusto, eveniet repellat, placeat deleniti? Ad odio, impedit corrupti consequuntur assumenda vero! Iste, hic temporibus. Sit delectus quas quaerat natus ipsum, excepturi laboriosam quod doloribus perferendis aperiam asperiores voluptatum neque rerum cumque qui. Consequuntur, ratione ex. Maiores dolor, quidem quas quibusdam fugiat sit debitis quasi alias officia.");
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("100"));
    }

    @Test
    void testGetEdad() {
        assertEquals(20, alumno.getEdad());
    }

    @Test
    void testSetEdad() {
        alumno.setEdad(25);
        assertEquals(25, alumno.getEdad());
    }

    @Test
    void testSetEdadExceptions() {
        // Excepcion 0
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setEdad(0);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("0"));

        // Excepcion mayor de 100
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setEdad(101);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("100"));
    }

    @Test
    void getNota() {
        assertEquals(8.25f, alumno.getNota());
    }

    @Test
    void setNota() {
        Assertions.assertAll(
                () -> {
                    alumno.setNota(5.2f);
                    assertEquals(5.20f, alumno.getNota());
                },
                () -> {
                    // Todos los redondeos son a dos decimales
                    alumno.setNota(5.256f);
                    assertEquals(5.26f, alumno.getNota());
                },
                () -> {
                    alumno.setNota(5.255f);
                    assertEquals(5.26f, alumno.getNota());
                },
                () -> {
                    alumno.setNota(5.254f);
                    assertEquals(5.25f, alumno.getNota());
                }
        );


    }

    @Test
    void setNotaExceptions() {
        // Excepcion 0
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setNota(-1);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("0"));

        // Excepcion mayor de 10
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            alumno.setNota(11);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("10"));
    }

    @Test
    void getCalificacion() {
        Assertions.assertAll(
                () -> {
                    alumno.setNota(4.99f);
                    assertEquals("Suspenso", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(5.0f);
                    assertEquals("Aprobado", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(5.99f);
                    assertEquals("Aprobado", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(6.0f);
                    assertEquals("Bien", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(6.99f);
                    assertEquals("Bien", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(7.0f);
                    assertEquals("Notable", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(8.99f);
                    assertEquals("Notable", alumno.getCalificacion());
                },
                () -> {
                    alumno.setNota(9.0f);
                    assertEquals("Sobresaliente", alumno.getCalificacion());
                }
        );
    }


    @Test
    void testToString() {
        Assertions.assertAll(
                () -> assertTrue(alumno.toString().contains(alumno.getNombre())),
                () -> assertTrue(alumno.toString().contains(String.valueOf(alumno.getEdad()))),
                () -> assertTrue(alumno.toString().contains(String.valueOf(alumno.getNota()))),
                () -> assertTrue(alumno.toString().contains(alumno.getCalificacion()))
        );
    }
}
