package kakeibo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kakeibo.constants.Messages;
import kakeibo.dto.ReceiptDto;
import kakeibo.dto.RegisterDto;
import kakeibo.form.InputWindowForm;
import kakeibo.service.GetReceiptService;
import kakeibo.service.RegisterReceiptService;

@Controller
public class InputWindowController{

	@Autowired
	private GetReceiptService getReceiptService;

	@Autowired
	private RegisterReceiptService registerReceiptService;

	private List<ReceiptDto> receiptList;

	public InputWindowController() {
	}

	//初期表示
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String showInputWindow(Model model) {
		receiptList = getReceiptService.getReceiptList();
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		model.addAttribute("receiptList", receiptList);
		return "inputWindow";
	}

	//レシート登録
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insertReceipt(@Valid @ModelAttribute InputWindowForm form, BindingResult result, Model model){
		RegisterDto rgstrDto = new RegisterDto();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			rgstrDto.setPurchaceDate(sdf.parse(form.getPurchaceDate()));
		} catch (ParseException e) {
			//日付フォーマットエラー
			model.addAttribute("message", Messages.ERR_INPUT_DATE);
			return "inputWindow";
		}
		rgstrDto.setPurchaceSum(form.getPurchaceSum());
		//レシート登録処理
		registerReceiptService.insertReceipt(rgstrDto);
		model.addAttribute("message", Messages.SUCCESS_INSERT_RECEIPT);
		receiptList = getReceiptService.getReceiptList();
		model.addAttribute("receiptList", receiptList);
		return "inputWindow";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(Model model) {
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		return "showMessage";
	}


}
