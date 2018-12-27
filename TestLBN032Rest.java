package com.qb.modules.interfaces.client.befloan;

import java.util.ArrayList;
import java.util.List;
//测试从本地提交代码到远程库
import org.junit.Test;

import com.alibaba.fastjson.TypeReference;
import com.qb.modules.interfaces.befloan.common.LBN032Response;
import com.qb.modules.interfaces.core.client.RestClient;
import com.qb.modules.interfaces.core.message.RequestHeader;
import com.qb.modules.interfaces.core.message.RequestMessage;
import com.qb.modules.interfaces.core.message.ResponseMessage;

public class TestLBN032Rest {
	@Test
	public static void testExcute(){
		String url = "http://172.28.71.78:8080/loanapi/biz/lb/cooperation/queryLoanResultInfo/v1";
		//String url="https://dev-apis.qianbao.com/xdcore/v1/loan/queryLoanResultInfo";
		RequestMessage<List<String>> requestMessage = new RequestMessage<List<String>>();
		RequestHeader requestHeader = new RequestHeader();
		requestHeader.setAppKey("000007");
		requestHeader.setApiCode("LB0032");
		requestHeader.setBizCode("LBN032");
		requestHeader.setAppSecret("93397ABA-6DC1-4000-922F-57515FEDD19F");
		requestMessage.setRequestHeader(requestHeader);
		/**============封装数据=======================================*/
		List<String> list=new ArrayList<String>();
		list.add("XD-1-20161123000001-01");
		list.add("CL1-1-20161125000001-01");
		requestMessage.setRequestBody(list);
		/**============发送请求返回结果=======================================*/
		ResponseMessage<LBN032Response> responseMessage = RestClient.doPost(url, requestMessage, new TypeReference<ResponseMessage<LBN032Response>>(){});
		System.out.println("===="+responseMessage.toString());
	}
	public static void main(String[] args) {
		TestLBN032Rest.testExcute();
	}
}
