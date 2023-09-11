package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.InvoiceNotFoundException;
import fr.demos.septemearchebackend.model.Invoice;
import fr.demos.septemearchebackend.repository.InvoiceRepository;
import fr.demos.septemearchebackend.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public Invoice createInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public List<Invoice> getAllInvoices() throws InvoiceNotFoundException {
        List<Invoice> invoices = invoiceRepository.findAll();
        if (invoices.size() > 0) {
            return invoices;
        } else {
            throw new InvoiceNotFoundException("Pas de resultat !");
        }
    }

    @Override
    public Optional<Invoice> getInvoiceById(Long id) {
        return Optional.empty();
    }


//    @Override
//    public Optional<Invoice> getInvoiceById(Long id) throws InvoiceNotFoundException {
//        if (invoiceRepository.findById(id).isPresent()) {
//            return invoiceRepository.findById(id);
//        } else {
//            throw new InvoiceNotFoundException("Aucune facture a été trouvé avec l'id = " + id + ".");
//        }
//    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        return null;
    }

    @Override
    public String deleteInvoice(Long id) {
        return null;
    }


}
