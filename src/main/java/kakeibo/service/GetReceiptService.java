package kakeibo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakeibo.dto.ReceiptDto;
import kakeibo.entity.ReceiptEntity;
import kakeibo.mapper.GetReceiptMapper;

@Service
public class GetReceiptService {

	@Autowired
	GetReceiptMapper getReceiptMapper;

	public GetReceiptService() {
	}

	public List<ReceiptDto> getReceiptList() {
		List<ReceiptEntity> receiptEntityList = getReceiptMapper.getReceiptList();
		List<ReceiptDto> receiptDtoList = convertToDto(receiptEntityList);
		return receiptDtoList;
	}

	private List<ReceiptDto> convertToDto(List<ReceiptEntity> receiptEntityList) {
		List<ReceiptDto> receiptDtoList = new LinkedList<>();
		for (ReceiptEntity receiptEntity : receiptEntityList) {
			ReceiptDto receiptDto = new ReceiptDto();
			BeanUtils.copyProperties(receiptEntity, receiptDto);
			receiptDtoList.add(receiptDto);
		}
		return receiptDtoList;
	}

}
