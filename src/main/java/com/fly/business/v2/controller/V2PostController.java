package com.fly.business.v2.controller;

import com.fly.business.v2.service.V2PostService;
import com.fly.common.controller.BaseController;
import com.fly.pojo.V2Member;
import com.fly.pojo.V2Post;
import com.fly.pojo.vo.InputParam;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import com.fly.util.Arr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v2")
@Controller
public class V2PostController extends BaseController {

    @Autowired
    private V2PostService ps;

    @GetMapping("/subjects/node")
    @ResponseBody
    public Result index(Result result,
                        @RequestParam("node_name") String nodeName,
                        @RequestParam(value = "p", defaultValue = "1") Integer p,
                        @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<V2Post> page = ps.findByPage(nodeName, p, count);
        return result.ok(page);
    }

    @GetMapping("/subjects/{node_id}")
    @ResponseBody
    public Result findByNode(Result result,
                        @PathVariable("node_id") String nodeId,
                        @RequestParam(value = "p", defaultValue = "1", required = false) Integer p,
                        @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        return result;
    }

    @GetMapping("/subjects")
    @ResponseBody
    public Result list2(Result result,
                        @RequestParam("type") String type,
                        @RequestParam(value = "p", defaultValue = "1", required = false) Integer p,
                        @RequestParam(value = "count", defaultValue = "20", required = false) Integer count) {
        Page<V2Post> page = ps.findByTypeAndPage(type, p, count);
        return result.ok(page);
    }

    @PostMapping("/subjects")
    @ResponseBody
    public Result list(Result result, @RequestBody InputParam inputParam) {
        Integer p = Arr.get(inputParam, "p", 1, Integer.class);
        Integer count = Arr.get(inputParam, "count", 20, Integer.class);
        String nodeName = Arr.get(inputParam, "node_name", String.class);
        Page<V2Post> page = ps.findByPage(nodeName, p, count);
        return result.ok(page);
    }

    @GetMapping("/subject/{id}")
    @ResponseBody
    public Result detail(Result result, @PathVariable String id) {
        V2Post post = ps.findPost(id);
        return result.ok(post);
    }

    @PostMapping("/search")
    @ResponseBody
    public Result search(Result result, @RequestBody InputParam param) {
        String keywords = Arr.get(param, "keywords", "", String.class);
        String nodeId = Arr.get(param, "node_id", "", String.class);
        Integer p = Arr.get(param, "page", 1, Integer.class);
        Integer count = Arr.get(param, "count", 20, Integer.class);
        Page<V2Post> page = ps.search(nodeId, keywords, p, count);
        return result.ok(page);
    }

    @GetMapping("/member")
    @ResponseBody
    public Result findMember(Result result, @RequestParam("member_id") String memberId) {
        V2Member member = ps.findMemberById(memberId);
        return result.ok(member);
    }

}
