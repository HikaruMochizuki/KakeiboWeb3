package kakeibo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakeibo.dto.RegisterDto;
import kakeibo.mapper.RegisterMapper;

@Service
public class RegisterReceiptService {

	@Autowired
	private RegisterMapper rgstrMapper;

	public RegisterReceiptService() {
	}

	public void insertReceipt(RegisterDto rgstrDto){
		rgstrMapper.insertReceipt(rgstrDto);
	}

}
