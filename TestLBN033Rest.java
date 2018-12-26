package com.qb.modules.interfaces.client.befloan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.TypeReference;
import com.qb.modules.interfaces.befloan.common.LBN033Request;
import com.qb.modules.interfaces.core.client.RestClient;
import com.qb.modules.interfaces.core.message.RequestHeader;
import com.qb.modules.interfaces.core.message.RequestMessage;
import com.qb.modules.interfaces.core.message.ResponseMessage;

public class TestLBN033Rest {
	@Test
	public static void testExcute(){
		//String url = "http://127.0.0.1:8080/loanapi/biz/lb/cooperation/queryLoanStatus/v1";
		String url="https://sit4-apis.qianbao.com/xdcore/v1/loan/queryLoanStatus";
		RequestMessage<List<LBN033Request>> requestMessage = new RequestMessage<List<LBN033Request>>();
		RequestHeader requestHeader = new RequestHeader();
		requestHeader.setAppKey("000007");
		requestHeader.setApiCode("LB0033");
		requestHeader.setBizCode("LBN033");
		requestHeader.setAppSecret("93397ABA-6DC1-4000-922F-57515FEDD19F");
		requestMessage.setRequestHeader(requestHeader);
		/**============封装数据=======================================*/
		List<LBN033Request> list=new ArrayList<LBN033Request>();
		LBN033Request rq=new LBN033Request();
		rq.setIouCode("20181225000001-01");
		rq.setLoanAmount(new BigDecimal(0));
		rq.setLoanDate(new Date());
		rq.setLoanStatus("06");
		rq.setIouTitle("上标-AR2018122315191959619");
		list.add(rq);
		requestMessage.setRequestBody(list);
		/**============发送请求返回结果=======================================*/
		ResponseMessage<Map<String, Object>> responseMessage = RestClient.doPost(url, requestMessage, new TypeReference<ResponseMessage<Map<String, Object>>>(){});
		System.out.println("===="+responseMessage.getResponseHeader().getCode());
	}
	public static void main(String[] args) {
		TestLBN033Rest.testExcute();
	}
}
