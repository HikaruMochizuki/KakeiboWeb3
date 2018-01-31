package kakeibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kakeibo.dto.RegisterDto;
import kakeibo.form.InputWindowForm;
import kakeibo.service.RegisterReceiptService;

@Controller
public class InputWindowController{

	@Autowired
	private RegisterReceiptService registerReceiptService;

	public InputWindowController() {
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String showInputWindow(Model model) {
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		return "inputWindow";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insertReceipt(@ModelAttribute InputWindowForm form, Model model){
		RegisterDto rgstrDto = new RegisterDto();
		rgstrDto.setPurchaceDate(form.getPurchaceDate());
		rgstrDto.setPurchaceSum(form.getPurchaceSum());
		registerReceiptService.insertReceipt(rgstrDto);
		return "inputWindow";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(Model model) {
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		return "showMessage";
	}


}
