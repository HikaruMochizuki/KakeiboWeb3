package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.RegisterDto;
import mapper.RegisterMapper;

@Service
public class ResisterReceiptService {

	@Autowired
	private RegisterMapper rgstrMapper;

	public ResisterReceiptService() {
	}

	public void insertReceipt(RegisterDto rgstrDto){
		rgstrMapper.insertReceipt(rgstrDto);
	}

}
