package cursospring.recipeapp.converters;

import cursospring.recipeapp.commands.NotesCommand;
import cursospring.recipeapp.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Override
    @Synchronized
    @Nullable
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
