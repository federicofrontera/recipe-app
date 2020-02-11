package cursospring.recipeapp.converters;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UnitOfMeasureToUnitOfMeasureCommandTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1);
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNotNullParameter() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        UnitOfMeasure command = new UnitOfMeasure();
        command.setDescription(DESCRIPTION);
        command.setId(LONG_VALUE);

        UnitOfMeasureCommand uomCommand = converter.convert(command);

        assertNotNull(uomCommand);
        assertEquals(DESCRIPTION, uomCommand.getDescription());
        assertEquals(LONG_VALUE, uomCommand.getId());

    }
}