package com.lvtu.controller.match;

import com.lvtu.domain.VO.MatchListVO;
import com.lvtu.entity.Mat;
import com.lvtu.response.CommonReturnType;
import com.lvtu.response.error.BusinessException;
import com.lvtu.service.match.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XuMeiFeng
 * @create 2020/11/22 19:54
 * @description
 */
@RestController
@Api(
    value = "MatchController",
    tags = {"结伴游模块"})
public class MatchController {
  @Autowired private MatchService matchService;
  /*
   * @Author XuMeiFeng
   * @Description 发布结伴游
   * @Date 19:55 2020/11/22
   */
  @ApiOperation("发布结伴游")
  @PostMapping("/releaseMatch")
  public CommonReturnType releaseMatch(@RequestBody Mat mat) throws BusinessException {
    matchService.releaseMatch(mat);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 修改结伴游
   * @Date 19:59 2020/11/22
   */
  @ApiOperation("修改结伴游")
  @PostMapping("/updateMatch")
  public CommonReturnType updateMatch(@RequestBody Mat mat) throws BusinessException {
    matchService.updateMatch(mat);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 删除结伴游
   * @Date 20:01 2020/11/22
   */
  @ApiOperation("删除结伴游")
  @ApiImplicitParam(name = "matId", value = "结伴游ID", required = true)
  @PostMapping("/deleteMatch")
  public CommonReturnType deleteMatch(@RequestParam("matId") Integer matId)
      throws BusinessException {
    matchService.deleteMatch(matId);
    return CommonReturnType.create(null);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取结伴游(我发布的)
   * @Date 20:03 2020/11/22
   */
  @ApiOperation("获取结伴游(我发布的)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true)
  })
  @GetMapping("/getMatchOfOwner")
  public CommonReturnType getMatchOfOwner(
      @RequestParam("userId") Integer userId,
      @RequestParam("currentPage") Integer currentPage,
      @RequestParam("pageSize") Integer pageSize)
      throws BusinessException {
    List<MatchListVO> data = matchService.getMatchListOfUser(userId, currentPage, pageSize, 0);
    return CommonReturnType.create(data);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取结伴游(我参加的)
   * @Date 20:39 2020/11/22
   */
  @ApiOperation("获取结伴游(我参加的)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true)
  })
  @GetMapping("/getMatchOfJoin")
  public CommonReturnType getMatchOfJoin(
      @RequestParam("userId") Integer userId,
      @RequestParam("currentPage") Integer currentPage,
      @RequestParam("pageSize") Integer pageSize)
      throws BusinessException {
    List<MatchListVO> data = matchService.getMatchListOfUser(userId, currentPage, pageSize, 1);
    return CommonReturnType.create(data);
  }
  /*
   * @Author XuMeiFeng
   * @Description 获取结伴游(当前城市)
   * @Date 20:39 2020/11/22
   */
  @ApiOperation("获取结伴游(当前城市)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "city", value = "城市名称", required = true),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true)
  })
  @GetMapping("/getMatchOfCity")
  public CommonReturnType getMatchOfCity(
      @RequestParam("city") String city,
      @RequestParam("currentPage") Integer currentPage,
      @RequestParam("pageSize") Integer pageSize)
      throws BusinessException {
    List<MatchListVO> data = matchService.getMatchOfCity(city, currentPage, pageSize);
    return CommonReturnType.create(data);
  }

  /*
   * @Author XuMeiFeng
   * @Description 获取结伴游(关键字搜索)
   * @Date 20:52 2020/11/22
   */
  @ApiOperation("获取结伴游(关键字搜索)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "keyword", value = "关键字", required = true),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true),
    @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true)
  })
  @GetMapping("/getMatchByKeyword")
  public CommonReturnType getMatchByKeyword(
      @RequestParam("keyword") String keyword,
      @RequestParam("currentPage") Integer currentPage,
      @RequestParam("pageSize") Integer pageSize)
      throws BusinessException {
    keyword = (keyword == null) ? null : "%" + keyword + "%";
    List<MatchListVO> data = matchService.getMatchByKeyword(keyword, currentPage, pageSize);
    return CommonReturnType.create(data);
  }
  /*
   * @Author XuMeiFeng
   * @Description 获取结伴游详情
   * @Date 21:02 2020/11/22
   */
  @ApiOperation("获取结伴游详情")
  @ApiImplicitParam(name = "matId", value = "结伴游ID", required = true)
  @GetMapping("/getMatchInfo")
  public CommonReturnType getMatchInfo(@RequestParam("matId") Integer matId)
      throws BusinessException {
    Mat data = matchService.getMatchInfo(matId);
    return CommonReturnType.create(data);
  }
}
