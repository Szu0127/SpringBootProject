package tw.leonchen.order.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.order.model.PurchaseOrder;
import tw.leonchen.order.model.PurchaseOrderService;

@Controller
@RequestMapping("/order")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService poService;

	@GetMapping("/purchaseordermain.controller")
	public String processPurchaseOrderMainAction() {
		return "order/purchaseOrderProductList";
	}

	@GetMapping("/purchaseorderproduct.controller")
	public String processProductQueryById(@RequestParam("pid") int pid, Model m) {
		m.addAttribute("pid", pid);
		return "order/purchaseOrderProduct";
	}

	@PostMapping("/purchaseOrderInsert.controller")
	@ResponseBody
	public PurchaseOrder processPurchaseOrderInsertAction(@RequestBody PurchaseOrder po) {
		po.setOdate(new Date());
		return poService.processInsertOrder(po);
	}

	@PostMapping("/purchaseOrderQuery.controller/{oid}")
	@ResponseBody
	public PurchaseOrder processPurchaseOrderFindByIdAction(@PathVariable("oid") int oid) {
		return poService.processFindOrderById(oid);
	}

	@PostMapping(path = "/purchaseOrderQueryAll.controller")
	@ResponseBody
	public List<PurchaseOrder> processPurchaseOrderfindAll() {
	return poService.findAll();
	}
	
}
