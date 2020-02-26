package cursospring.recipeapp.services;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.model.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
