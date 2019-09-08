package jp.co.sunarch.fraudjudge.controller;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sunarch.fraudjudge.dto.JsonRequest;
import jp.co.sunarch.fraudjudge.dto.JsonResponse;

@Controller
@ResponseBody
@RequestMapping("/fj/api/v1")
@CrossOrigin
public class FraudJudgeController {

	private Log logger = LogFactory.getLog(FraudJudgeController.class);

	@RequestMapping(value = "sample", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> sample(@RequestBody JsonRequest req) {
		logger.info("★★ uid=" + req.getUserId() + ", rid=" + req.getRequestId());
		logger.info("★ card_no=" + req.getCardInfo().getCardNo());
		logger.info("★ exp_date=" + req.getCardInfo().getExpDate());
		logger.info("★ sec_code=" + req.getCardInfo().getSecCode());

		JsonResponse res = new JsonResponse();

		res.setResultCode(0);
		res.setMessage("Hello");
		res.setProccess(new Date());
		res.setToken(RandomStringUtils.randomAlphanumeric(32));

		return ResponseEntity.ok(res);
	}

}
