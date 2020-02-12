package cursospring.recipeapp.converters;

import cursospring.recipeapp.commands.NotesCommand;
import cursospring.recipeapp.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    @Synchronized
    @Nullable
    public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
