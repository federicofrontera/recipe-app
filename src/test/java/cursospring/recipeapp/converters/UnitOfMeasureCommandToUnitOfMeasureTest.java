package cursospring.recipeapp.converters;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1);
    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception{
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }
    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }
    @Test
    public void testNotNullParameter() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }
    @Test
    public void convert() throws Exception{
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setDescription(DESCRIPTION);
        command.setId(LONG_VALUE);

        UnitOfMeasure uom = converter.convert(command);

        assertNotNull(uom);
        assertEquals(DESCRIPTION, uom.getDescription());
        assertEquals(LONG_VALUE, uom.getId());
    }


}
