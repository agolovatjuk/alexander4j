package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 *
 */
public class ProfessionTest {
    /**.
     * test Doctor Ivan heals Sergej
     */
    @Test
    public void whenDoctorHealsPacientThen() {
        Pacient p = new Pacient("Sergej", "Artist", "high");
        Doctor d = new Doctor("Ivan", "Terapevt",
                "middle", "MGU", "001", true);
        String expected = "Doctor Ivan heals Sergej";
        assertThat(d.heal(p), is(expected));
    }
}
