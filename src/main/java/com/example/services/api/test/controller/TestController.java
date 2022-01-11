package com.example.services.api.test.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;

import com.example.common.util.consts.ResponseResult;
import com.example.common.util.consts.ErrorCode;

import com.example.services.api.test.condition.UserFindByPhoneCond;
import com.example.common.jpa.model.common.CommonUser;
import com.example.common.jpa.service.common.CommonUserService;

@Slf4j
@RestController("TestController")
@RequestMapping(path = "/test")
public class TestController {

	@Autowired
    private CommonUserService commonUserService;

	@RequestMapping(value = "/echo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<JSONObject> echo(@RequestBody JSONObject doc) {
		try {
			JSONObject rsp = new JSONObject();
			rsp.put("msg", doc.get("msg"));
			return ResponseResult.buildSuccess(rsp);
		} catch (Exception e) {
			return ResponseResult.buildFailure(ErrorCode.ERROR.getCode(), "查询货品列表信息失败!");
		}
	}

	@RequestMapping(value = "/findUserByPhone", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<CommonUser> findUserByPgone(@RequestBody UserFindByPhoneCond UserFindByPhoneCond){
        try{
			CommonUser user = commonUserService.findByUserPhone(UserFindByPhoneCond.getPhone());
            return ResponseResult.buildSuccess(user);
        }catch (Exception e){
            return ResponseResult.buildFailure(ErrorCode.ERROR.getCode(), "查询用户搜索信息排名前十失败!");
        }
    }
}