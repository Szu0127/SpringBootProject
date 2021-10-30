package tw.leonchen.order.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderService {
	@Autowired
	private PurchaseOrderRepository pRepo;

	public PurchaseOrder processInsertOrder(PurchaseOrder po) {
		return pRepo.save(po);
	}

	public PurchaseOrder processFindOrderById(int id) {
		Optional<PurchaseOrder> op1 = pRepo.findById(id);

		if (op1.isPresent()) {
			return op1.get();
		}

		return null;
	}

	public List<PurchaseOrder> findAll() {
		return pRepo.findAll();
	}
}
