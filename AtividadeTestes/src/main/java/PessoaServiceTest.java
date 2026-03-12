import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    @Test
    void deveRetornarSomenteMulheres() {

        String entrada = "Maria-F,Joao-M,Ana-F,Carlos-M,Julia-F";

        List<String> resultado = PessoaService.filtrarMulheres(entrada);

        assertTrue(resultado.contains("Maria"));
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("Julia"));

        assertFalse(resultado.contains("Joao"));
        assertFalse(resultado.contains("Carlos"));
    }
}
