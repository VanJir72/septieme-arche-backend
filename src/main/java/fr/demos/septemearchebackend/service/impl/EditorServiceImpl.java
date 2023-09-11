package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.EditorNotFoundException;
import fr.demos.septemearchebackend.model.Editor;
import fr.demos.septemearchebackend.repository.EditorRepository;
import fr.demos.septemearchebackend.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EditorServiceImpl implements EditorService {

    @Autowired
    private final EditorRepository editorRepository;

    public EditorServiceImpl(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }


    @Override
    public Editor createEditor(Editor editor) {
        return editorRepository.save(editor);
    }



    @Override
    public List<Editor> getAllEditors() throws EditorNotFoundException {
        List<Editor> editors = editorRepository.findAll();
        if (editors.size() > 0) {
            return editors;
        } else {
            throw new EditorNotFoundException("Pas de resultat !");
        }
    }


    @Override
    public Optional<Editor> getEditorById(Long id) throws EditorNotFoundException {
        if (editorRepository.findById(id).isPresent()) {
            return editorRepository.findById(id);
        } else {
            throw new EditorNotFoundException("Aucun éditeur a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public Editor updateEditor(Long id, Editor editor) throws EditorNotFoundException {
        if (editorRepository.findById(id).isPresent()) {
            editor.setId(id);
            return editorRepository.save(editor);
        } else {
            throw new EditorNotFoundException("Aucun éditeur a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public String deleteEditor(Long id) {
        editorRepository.deleteById(id);
        return "OK";
    }
}
