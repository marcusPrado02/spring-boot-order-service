import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentStatusService {

    @Autowired
    private PaymentStatusRepository costumerRepository;

    public List<PaymentStatus> listPaymentStatuss() {
        return costumerRepository.findAll();
    }

    public Optional<PaymentStatus> getPaymentStatusById(Long id) {
        return costumerRepository.findById(id);
    }

    public PaymentStatus createPaymentStatus(PaymentStatus costumer) {
        return costumerRepository.save(costumer);
    }

    public PaymentStatus updatePaymentStatus(Long id, PaymentStatus updatedPaymentStatus) {
        Optional<PaymentStatus> existingPaymentStatusOptional = costumerRepository.findById(id);
        if (existingPaymentStatusOptional.isPresent()) {
            PaymentStatus existingPaymentStatus = existingPaymentStatusOptional.get();
            existingPaymentStatus.setName(updatedPaymentStatus.getName());
            existingPaymentStatus.setEmail(updatedPaymentStatus.getEmail());
            // Atualize outros campos conforme necessário
            return costumerRepository.save(existingPaymentStatus);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deletePaymentStatus(Long id) {
        costumerRepository.deleteById(id);
    }
}
