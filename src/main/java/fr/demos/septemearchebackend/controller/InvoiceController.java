package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.model.Invoice;
import fr.demos.septemearchebackend.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    /* ========================================== createFacture =========================================== */
//    @PostMapping()
//    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
//        Invoice createdInvoice = invoiceService.createInvoice(invoice);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
//    }
    /* ===================================================================================================== */

    /* ========================================= getAllFacture ============================================= */
    @GetMapping()
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    /* ====================================================================================================== */

    /* =========================================== getFactureById ============================================ */
//    @GetMapping("/{id}")
//    public Optional<Invoice> getInvoiceById(@PathVariable Long id){
//        return invoiceService.getInvoiceById(id);
//    }
    /* ======================================================================================================== */








}
