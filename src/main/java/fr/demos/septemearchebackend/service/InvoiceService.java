package fr.demos.septemearchebackend.service;


import fr.demos.septemearchebackend.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Invoice createInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    Optional<Invoice> getInvoiceById(Long id);

    Invoice updateInvoice(Long id, Invoice invoice);

    String deleteInvoice(Long id);
}
