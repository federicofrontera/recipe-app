package cursospring.recipeapp.converters;

import cursospring.recipeapp.commands.UnitOfMeasureCommand;
import cursospring.recipeapp.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }
        final UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(source.getId());
        uomCommand.setDescription(source.getDescription());
        return uomCommand;
    }
}