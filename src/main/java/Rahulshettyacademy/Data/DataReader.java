package Rahulshettyacademy.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.pageobjectmodel.Landing_page;



public class DataReader {
	
	public List<HashMap<String, String>> getjsonDatatoMap() throws IOException {
		String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user+dir")+"\\src\\main\\java\\Rahulshettyacademy\\Data\\purchaseorder.json"),
				StandardCharsets.UTF_8);
	    ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
	   return data;
	
	}
	

}
