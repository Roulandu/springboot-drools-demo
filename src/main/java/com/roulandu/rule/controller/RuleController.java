package com.roulandu.rule.controller;

import com.roulandu.rule.pojo.Rule;
import com.roulandu.rule.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Created By QQ497 on 2019/9/24 */
@RestController
@RequestMapping(value = "/rule")
@Api(value = "Rule API", tags = "rule", description = "规则相关接口")
public class RuleController {
  @Autowired private RuleService ruleService;

  @ApiOperation(value = "根据规则验证")
  @ApiResponses({
    @ApiResponse(code = 200, message = "success"),
    @ApiResponse(code = 500, message = "failed, maybe server interval error"),
  })
  @PostMapping(value = "/verify/{ruleType}")
  public boolean verifyData(@RequestBody Object verifyData, @PathVariable String ruleType) {
    return ruleService.verify(verifyData, ruleType);
  }

  @ApiOperation(value = "获取规则内容")
  @ApiResponses({
    @ApiResponse(code = 200, message = "success"),
    @ApiResponse(code = 500, message = "failed, maybe server interval error"),
  })
  @GetMapping(value = "/get")
  public Rule getRule(@RequestParam(value = "id") int id) {
    return ruleService.getRule(id);
  }

  @ApiOperation(value = "新增规则内容")
  @ApiResponses({
    @ApiResponse(code = 200, message = "success"),
    @ApiResponse(code = 500, message = "failed, maybe server interval error"),
  })
  @PostMapping(value = "/add")
  public boolean addRule(
      @RequestParam(value = "name") String name, @RequestParam(value = "content") String content) {
    return ruleService.addRule(name, content);
  }

  @ApiOperation(value = "修改规则内容")
  @ApiResponses({
    @ApiResponse(code = 200, message = "success"),
    @ApiResponse(code = 500, message = "failed, maybe server interval error"),
  })
  @PutMapping(value = "/update")
  public boolean updateRule(@RequestBody Rule rule) {
    return ruleService.update(rule);
  }

  @ApiOperation(value = "删除规则内容")
  @ApiResponses({
    @ApiResponse(code = 200, message = "success"),
    @ApiResponse(code = 500, message = "failed, maybe server interval error"),
  })
  @DeleteMapping(value = "/delete")
  public boolean deleteRule(@RequestParam(value = "id") int id) {
    return ruleService.delete(id);
  }
}
