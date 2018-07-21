package kakeibo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 *
 * @author Amami
 *
 */
@Controller
public class InputWindowController{

	private static Logger logger = LogManager.getLogger();

	/**
	 * レシート取得サービス
	 */
	@Autowired
	private GetReceiptService getReceiptService;

	/**
	 * レシート登録サービス
	 */
	@Autowired
	private RegisterReceiptService registerReceiptService;

	/**
	 * レシートリストDTO
	 */
	private List<ReceiptDto> receiptList;

	public InputWindowController() {
	}

	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	//
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String showInputWindow(Model model) {
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		setReceiptList(model);
		return "inputWindow";
	}

	/**
	 * レシート登録
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insertReceipt(@Valid @ModelAttribute InputWindowForm form, BindingResult result, Model model){
		if (result.hasErrors()) {
			//入力チェックエラー処理
			model.addAttribute("message", Messages.ERR_INPUT_VALUES);
		} else {
			//正常処理
			try {
				logger.info("レシート登録処理開始");
				RegisterDto rgstrDto = new RegisterDto();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				rgstrDto.setPurchaceDate(sdf.parse(form.getPurchaceDate()));
				rgstrDto.setPurchaceSum(form.getPurchaceSum());
				//レシート登録処理
				registerReceiptService.insertReceipt(rgstrDto);
				model.addAttribute("message", Messages.SUCCESS_INSERT_RECEIPT);
				logger.info("レシート登録処理終了");
			} catch (ParseException e) {
				//日付フォーマットエラー
				logger.warn("日付フォーマットエラー");
				e.printStackTrace();
				model.addAttribute("message", Messages.ERR_INPUT_DATE);
			}
		}
		setReceiptList(model);
		return "inputWindow";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(Model model) {
		InputWindowForm form = new InputWindowForm();
		model.addAttribute("inputWindowForm", form);
		return "showMessage";
	}

	/**
	 * レシートリスト取得処理
	 * @param model
	 */
	private void setReceiptList(Model model) {
		receiptList = getReceiptService.getReceiptList();
		model.addAttribute("receiptList", receiptList);
	}


}
