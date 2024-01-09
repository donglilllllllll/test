package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.bookMapper;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 *
 * @author kaixiang
 * date:2024/1/4 10:48
 */
@SpringBootTest(classes = Springboot0102QuickstartApplication.class)
class Springboot0102QuickstartApplicationTests {
	//注入你要测试的对象
	@Autowired
	private bookMapper bookmapper;
	public void compareJson(String json1, String json2) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode tree1 = objectMapper.readTree(json1);
		JsonNode tree2 = objectMapper.readTree(json2);

		compareNodes(tree1, tree2);
	}

	private void compareNodes(JsonNode node1, JsonNode node2) {
		if (node1.equals(node2)) {
			return;
		}

		if (node1.isObject() && node2.isObject()) {
			node1.fieldNames().forEachRemaining(fieldName -> {
				if (!node2.has(fieldName)) {
					System.out.println("字符串 '" + fieldName + "' 在第二个JSON中丢失.");
				} else {
					JsonNode childNode1 = node1.get(fieldName);
					JsonNode childNode2 = node2.get(fieldName);
					compareNodes(childNode1, childNode2);
				}
			});

			node2.fieldNames().forEachRemaining(fieldName -> {
				if (!node1.has(fieldName)) {
					System.out.println("字符串 '" + fieldName + "' 在第二个JSON中丢失.");
				}
			});
		} else if (node1.isArray() && node2.isArray()) {
			int size1 = node1.size();
			int size2 = node2.size();

			if (size1 != size2) {
				System.out.println("数组大小不匹配: " + size1 + " 在第一个JSON中 and " + size2 + " 在第二个JSON中.");
			}

			int minSize = Math.min(size1, size2);
			for (int i = 0; i < minSize; i++) {
				compareNodes(node1.get(i), node2.get(i));
			}
		} else {
			System.out.println("值不匹配: " + node1 + " 在第一个JSON中 and " + node2 + " 在第二个JSON中.");
		}
	}
	@Test
	void text() {
		String json1 = "{\"sign\": \"test\", \"appId\": \"400050\", \"userIp\": \"uxcPbAwPIJARCDsPHrQObGkJTMxyWEwpa\", \"merchId\": \"TESTMER01\", \"userMac\": \"ac:de:48:00:11:22\", \"version\": \"1.0.0\", \"language\": \"zh_cn\", \"signType\": \"SHA256withRSA\", \"channelMid\": \"202304048338280700961\", \"requestData\": {\"risk\": {\"custom\": \"N\", \"paymentRecipient\": {\"lastName\": \"Q\", \"dateOfBirth\": \"Fjm\", \"postcodeZip\": \"f\", \"accountIdentifier\": \"U\"}}, \"order\": {\"id\": \"e\", \"tax\": [{\"rate\": \"H\", \"type\": \"v\", \"amount\": \"7\"}], \"item\": [{\"sku\": \"Q\", \"name\": \"i\", \"brand\": \"Q\", \"detail\": {\"tax\": [{\"rate\": \"x\", \"type\": \"j\", \"amount\": \"9\"}], \"upc\": \"FqT\", \"unspsc\": \"QXm\", \"unitTaxRate\": \"L\", \"unitTaxType\": \"a\", \"commodityCode\": \"jIt\", \"acquirerCustom\": \"l\", \"unitDiscountRate\": \"R\"}, \"category\": \"Y\", \"quantity\": \"dGl\", \"unitPrice\": \"r\", \"description\": \"c\", \"unitOfMeasure\": \"w\", \"unitTaxAmount\": \"a\", \"industryCategory\": \"HEALTHCARE_DENTAL\", \"unitDiscountAmount\": \"H\"}], \"amount\": \"6\", \"custom\": \"e\", \"currency\": \"UKu\", \"discount\": {\"code\": \"C\", \"amount\": \"7\", \"description\": \"B\"}, \"reference\": \"K\", \"taxAmount\": \"q\", \"itemAmount\": \"p\", \"description\": \"t\", \"customerNote\": \"I\", \"owningEntity\": \"t\", \"notificationUrl\": \"wmd\", \"shippingAndHandlingAmount\": \"q\"}, \"device\": {\"browser\": \"e\", \"hostname\": \"b\", \"ipAddress\": \"DevwCUE\", \"fingerprint\": \"U\", \"mobilePhoneModel\": \"j\"}, \"billing\": {\"address\": {\"city\": \"A\", \"street\": \"o\", \"company\": \"p\", \"country\": \"PXt\", \"street2\": \"w\", \"postcodeZip\": \"V\", \"stateProvince\": \"r\"}}, \"session\": {\"id\": \"lZvLPMSvvWALnFYGEGKWNRpVaAGTAKA\", \"version\": \"QcSxVsvAxE\"}, \"customer\": {\"email\": \"UBh\", \"phone\": \"twV\", \"account\": {\"id\": \"N\"}, \"lastName\": \"u\", \"firstName\": \"c\", \"nationalId\": \"F\", \"dateOfBirth\": \"jDj\", \"mobilePhone\": \"ZOp\"}, \"shipping\": {\"method\": \"ELECTRONIC\", \"origin\": {\"postcodeZip\": \"o\"}, \"address\": {\"city\": \"K\", \"street\": \"N\", \"company\": \"M\", \"country\": \"pwx\", \"street2\": \"e\", \"postcodeZip\": \"o\", \"stateProvince\": \"U\"}, \"contact\": {\"email\": \"wTl\", \"phone\": \"wHt\", \"lastName\": \"r\", \"firstName\": \"f\", \"mobilePhone\": \"bzH\"}}, \"agreement\": {\"id\": \"O\", \"type\": \"OTHER\", \"recurring\": {\"numberOfPayments\": \"118\", \"amountVariability\": \"VARIABLE\", \"daysBetweenPayments\": \"372\"}, \"expiryDate\": \"zTQ\"}, \"transaction\": {\"id\": \"J\", \"reference\": \"v\", \"merchantNote\": \"P\"}, \"sourceOfFunds\": {\"type\": \"OPEN_BANKING_BANK_TRANSFER\", \"provided\": {\"oxxo\": {\"dueDate\": \"Tpq\", \"bankAccountHolder\": \"e\"}, \"poli\": {\"bankAccountHolder\": \"e\"}, \"sepa\": {\"iban\": \"p\", \"bankAccountHolder\": \"ddq\"}, \"enets\": {\"bankAccountHolder\": \"f\"}, \"ideal\": {\"bic\": \"xLLHTvfW\"}, \"sofort\": {\"bic\": \"r\"}, \"giropay\": {\"bic\": \"PuMbiRas\", \"bankIdentifier\": \"iKSUcHuL\"}, \"weChatPay\": {\"accountHolder\": \"p\"}, \"boletoBancario\": {\"bankAccountHolder\": \"L\"}, \"openBankingBankTransfer\": {\"aspspId\": \"P\"}}}, \"browserPayment\": {\"paypal\": {\"paymentConfirmation\": \"CONFIRM_AT_PROVIDER\", \"displayShippingAddress\": \"false\", \"overrideShippingAddress\": \"true\"}, \"operation\": \"AUTHORIZE\", \"returnUrl\": \"fft\", \"preferredLanguage\": \"Ck\"}, \"responseControls\": {\"sensitiveData\": \"I\"}, \"partnerSolutionId\": \"M\"}, \"correlationId\": \"20230410923964060771\", \"operationType\": \"INITIATE_BROWSER_PAYMENT\"}\n";
		String json2 = "{\"sign\": \"test\", \"appId\": \"ftvTcjWkfZlwmAKlIBLIcoJjtpHTlUlVl\", \"userIp\": \"192.168.8.136\", \"merchId\": \"TESTMER01\", \"userMac\": \"ac:de:48:00:11:22\", \"version\": \"1.0.0\", \"language\": \"zh_cn\", \"signType\": \"SHA256withRSA\", \"channelMid\": \"202304048338280700961\", \"requestData\": {\"risk\": {\"custom\": \"N\", \"paymentRecipient\": {\"lastName\": \"Q\", \"dateOfBirth\": \"Fjm\", \"postcodeZip\": \"f\", \"accountIdentifier\": \"U\"}}, \"order\": {\"id\": \"e\", \"tax\": [{\"rate\": \"H\", \"type\": \"v\", \"amount\": \"7\"}], \"item\": [{\"sku\": \"Q\", \"name\": \"i\", \"brand\": \"Q\", \"detail\": {\"tax\": [{\"rate\": \"x\", \"type\": \"j\", \"amount\": \"9\"}], \"upc\": \"FqT\", \"unspsc\": \"QXm\", \"unitTaxRate\": \"L\", \"unitTaxType\": \"a\", \"commodityCode\": \"jIt\", \"acquirerCustom\": \"l\", \"unitDiscountRate\": \"R\"}, \"category\": \"Y\", \"quantity\": \"dGl\", \"unitPrice\": \"r\", \"description\": \"c\", \"unitOfMeasure\": \"w\", \"unitTaxAmount\": \"a\", \"industryCategory\": \"HEALTHCARE_DENTAL\", \"unitDiscountAmount\": \"H\"}], \"amount\": \"6\", \"custom\": \"e\", \"currency\": \"UKu\", \"discount\": {\"code\": \"C\", \"amount\": \"7\", \"description\": \"B\"}, \"reference\": \"K\", \"taxAmount\": \"q\", \"itemAmount\": \"p\", \"description\": \"t\", \"customerNote\": \"I\", \"owningEntity\": \"t\", \"notificationUrl\": \"wmd\", \"shippingAndHandlingAmount\": \"q\"}, \"device\": {\"browser\": \"e\", \"hostname\": \"b\", \"ipAddress\": \"DevwCUE\", \"fingerprint\": \"U\", \"mobilePhoneModel\": \"j\"}, \"billing\": {\"address\": {\"city\": \"A\", \"street\": \"o\", \"company\": \"p\", \"country\": \"PXt\", \"street2\": \"w\", \"postcodeZip\": \"V\", \"stateProvince\": \"r\"}}, \"session\": {\"id\": \"lZvLPMSvvWALnFYGEGKWNRpVaAGTAKA\", \"version\": \"QcSxVsvAxE\"}, \"customer\": {\"email\": \"UBh\", \"phone\": \"twV\", \"account\": {\"id\": \"N\"}, \"lastName\": \"u\", \"firstName\": \"c\", \"nationalId\": \"F\", \"dateOfBirth\": \"jDj\", \"mobilePhone\": \"ZOp\"}, \"shipping\": {\"method\": \"ELECTRONIC\", \"origin\": {\"postcodeZip\": \"o\"}, \"address\": {\"city\": \"K\", \"street\": \"N\", \"company\": \"M\", \"country\": \"pwx\", \"street2\": \"e\", \"postcodeZip\": \"o\", \"stateProvince\": \"U\"}, \"contact\": {\"email\": \"wTl\", \"phone\": \"wHt\", \"lastName\": \"r\", \"firstName\": \"f\", \"mobilePhone\": \"bzH\"}}, \"agreement\": {\"id\": \"O\", \"type\": \"OTHER\", \"recurring\": {\"numberOfPayments\": \"118\", \"amountVariability\": \"VARIABLE\", \"daysBetweenPayments\": \"372\"}, \"expiryDate\": \"zTQ\"}, \"transaction\": {\"id\": \"J\", \"reference\": \"v\", \"merchantNote\": \"P\"}, \"sourceOfFunds\": {\"type\": \"OPEN_BANKING_BANK_TRANSFER\", \"provided\": {\"oxxo\": {\"dueDate\": \"Tpq\", \"bankAccountHolder\": \"e\"}, \"poli\": {\"bankAccountHolder\": \"e\"}, \"sepa\": {\"iban\": \"p\", \"bankAccountHolder\": \"ddq\"}, \"enets\": {\"bankAccountHolder\": \"f\"}, \"ideal\": {\"bic\": \"xLLHTvfW\"}, \"sofort\": {\"bic\": \"r\"}, \"giropay\": {\"bic\": \"PuMbiRas\", \"bankIdentifier\": \"iKSUcHuL\"}, \"weChatPay\": {\"accountHolder\": \"p\"}, \"boletoBancario\": {\"bankAccountHolder\": \"L\"}, \"openBankingBankTransfer\": {\"aspspId\": \"P\"}}}, \"browserPayment\": {\"paypal\": {\"paymentConfirmation\": \"CONFIRM_AT_PROVIDER\", \"displayShippingAddress\": \"false\", \"overrideShippingAddress\": \"true\"}, \"operation\": \"AUTHORIZE\", \"returnUrl\": \"fft\", \"preferredLanguage\": \"Ck\"}, \"responseControls\": {\"sensitiveData\": \"I\"}, \"partnerSolutionId\": \"M\"}, \"correlationId\": \"20230410923964060771\", \"operationType\": \"INITIATE_BROWSER_PAYMENT\"}\n";

		try {
			compareJson(json1, json2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSvae(){
		Book book= new Book();
		book.setDescription("yrwehihhhhhhkhkh");
		book.setName("test");
		book.setType("还是客家话");
		bookmapper.insert(book);

	}
	@Test
	void testDelete(){

		bookmapper.deleteById(2001);


	}
	@Test
	void testUpdate(){
		Book book= new Book();
		book.setId(2000);
		book.setDescription("测试");
		book.setName("test3");
		book.setType("还是客家话");
		bookmapper.updateById(book);

	}
	@Test
	void testGetById() {

		bookmapper.selectById(1);

	}


	@Test
	void testGetAll(){
		bookmapper.selectList(null);

	}

	@Test
	void testGetPage(){

		IPage page = new Page(1,10);
		bookmapper.selectPage(page,null);
		System.out.println(page.getPages());
		System.out.println(page.getCurrent());
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.getRecords());



	}
	@Test
	void testGetby(){
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name","张");
		bookmapper.selectList(queryWrapper);
	}
	@Test
	void testGetb2(){

		String name ="张";
		LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
		//普通的
		//if(name != null)queryWrapper.like(Book::getName,name);

		queryWrapper.like(name != null,Book::getName,name);
		bookmapper.selectList(queryWrapper);
	}
	@Test
	void testGetb3(){



	}


}
