package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.exceptions.EditorNotFoundException;
import fr.demos.septemearchebackend.model.*;
import fr.demos.septemearchebackend.response.ResponseHandler;
import fr.demos.septemearchebackend.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/editors")
public class EditorController {

    @Autowired
    private final EditorService editorService;



    public EditorController(EditorService editorService) {
        this.editorService = editorService;

    }


    /* ================================================== createEditeur =================================================== */
    @PostMapping()
    public ResponseEntity<Editor> createEditeur(@RequestBody Editor editor) {
        Editor createdEditor = editorService.createEditor(editor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEditor);
    }
    /* ==================================================================================================================== */

    /* ================================================== getAllEditeur =================================================== */
    @GetMapping()
    public List<Editor> getAllEditeur() {
        return editorService.getAllEditors();
    }
    /* ==================================================================================================================== */

    /* ================================================== getEditeurById =================================================== */
    @GetMapping("/{id}")
    public Optional<Editor> getEditeurById(@PathVariable Long id){
        return editorService.getEditorById(id);
    }
    /* ==================================================================================================================== */

    /* ================================================== updateEditeur =================================================== */
    @PutMapping("/{id}")
    public Editor updateEditeur(@PathVariable Long id, @RequestBody Editor editor)  {
        return editorService.updateEditor(id, editor);
    }
    /* ==================================================================================================================== */

    /* ================================================== deleteEditeur =================================================== */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEditeur(@PathVariable Long id) throws EditorNotFoundException {
        if (editorService.getEditorById(id).isPresent()) {
            return ResponseHandler.responseBuilder("L'éditeur avec l'id = " + id + ", a bien été supprimé.",
                    HttpStatus.OK, editorService.deleteEditor(id));
        } else {
            throw new EditorNotFoundException("Aucun éditeur a été trouvé avec l'id = " + id + ".");
        }
    }
    /* ==================================================================================================================== */














}
