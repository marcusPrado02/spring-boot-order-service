import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository costumerRepository;

    public List<PaymentMethod> listPaymentMethods() {
        return costumerRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return costumerRepository.findById(id);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod costumer) {
        return costumerRepository.save(costumer);
    }

    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod) {
        Optional<PaymentMethod> existingPaymentMethodOptional = costumerRepository.findById(id);
        if (existingPaymentMethodOptional.isPresent()) {
            PaymentMethod existingPaymentMethod = existingPaymentMethodOptional.get();
            existingPaymentMethod.setName(updatedPaymentMethod.getName());
            existingPaymentMethod.setEmail(updatedPaymentMethod.getEmail());
            // Atualize outros campos conforme necessário
            return costumerRepository.save(existingPaymentMethod);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deletePaymentMethod(Long id) {
        costumerRepository.deleteById(id);
    }
}
