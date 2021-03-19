package ru.ifmo.soa_lab2_servcie1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ru.ifmo.soa_lab2_servcie1.models.UnitOfMeasure;

@SpringBootTest
class SoaLab2Servcie1ApplicationTests {

    @Test
    void test() {
        String enuum = "MILLIGRAMS";
        /*UnitOfMeasure uof = */UnitOfMeasure.valueOf(enuum);
    }

}
