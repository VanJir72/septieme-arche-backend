package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Editor;

import java.util.List;
import java.util.Optional;

public interface EditorService {
    Editor createEditor(Editor editor);
    List<Editor> getAllEditors();
    Optional<Editor> getEditorById(Long id);
    Editor updateEditor(Long id, Editor editor);
    String deleteEditor(Long id);
}
