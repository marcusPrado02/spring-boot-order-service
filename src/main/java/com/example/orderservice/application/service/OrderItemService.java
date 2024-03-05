import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository costumerRepository;

    public List<OrderItem> listOrderItems() {
        return costumerRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return costumerRepository.findById(id);
    }

    public OrderItem createOrderItem(OrderItem costumer) {
        return costumerRepository.save(costumer);
    }

    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItemOptional = costumerRepository.findById(id);
        if (existingOrderItemOptional.isPresent()) {
            OrderItem existingOrderItem = existingOrderItemOptional.get();
            existingOrderItem.setName(updatedOrderItem.getName());
            existingOrderItem.setEmail(updatedOrderItem.getEmail());
            // Atualize outros campos conforme necessário
            return costumerRepository.save(existingOrderItem);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deleteOrderItem(Long id) {
        costumerRepository.deleteById(id);
    }
}
