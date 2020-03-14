package cursospring.recipeapp.services;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import cursospring.recipeapp.model.UnitOfMeasure;
import cursospring.recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand converter = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMeasureServiceImpl(repository, converter);
    }

    @Test
    public void listAllUoms() throws Exception {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(repository.findAll()).thenReturn(unitOfMeasures);


        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        assertEquals(2, commands.size());
        verify(repository, times(1)).findAll();
    }

}