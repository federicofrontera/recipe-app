package cursospring.recipeapp.services;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import cursospring.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    @Autowired
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.converter = converter;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toSet());
    }
}
