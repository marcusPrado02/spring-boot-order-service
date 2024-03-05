import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository costumerRepository;

    public List<Order> listOrders() {
        return costumerRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return costumerRepository.findById(id);
    }

    public Order createOrder(Order costumer) {
        return costumerRepository.save(costumer);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOptional = costumerRepository.findById(id);
        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setName(updatedOrder.getName());
            existingOrder.setEmail(updatedOrder.getEmail());
            // Atualize outros campos conforme necessário
            return costumerRepository.save(existingOrder);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deleteOrder(Long id) {
        costumerRepository.deleteById(id);
    }
}
