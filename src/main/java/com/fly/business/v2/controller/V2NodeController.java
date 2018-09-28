package com.fly.business.v2.controller;

import com.fly.business.v2.service.V2NodeService;
import com.fly.common.controller.BaseController;
import com.fly.pojo.V2Node;
import com.fly.pojo.vo.InputParam;
import com.fly.pojo.vo.Page;
import com.fly.pojo.vo.Result;
import com.fly.util.Arr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author david
 * @date 03/08/18 19:17
 */

@RestController
@RequestMapping("/node")
public class V2NodeController extends BaseController {

    @Autowired
    private V2NodeService ns;

    /**
     * @param result return
     * @param page page object
     * @param p current page number
     * @param count want to getString number of nodes
     * @return
     */
    @GetMapping("/list")
    public Result listNodes(Result<Page> result, Page page,
                            @RequestParam(name = "p", defaultValue = "1") Integer p,
                            @RequestParam(name = "count", defaultValue = "20") Integer count) {
        p = this.validateIntNNWithDefaultValue(p, 1);
        count = this.validateIntNNWithDefaultValue(count, 20);
        page = ns.findByPage(p, count, page);
        result.ok(page);
        return result;
    }

    @GetMapping("/subject/{id}")
    public Result getDetail(Result result, @PathVariable String id,
                             @RequestParam(name = "p", defaultValue = "1") Integer p,
                             @RequestParam(name = "count", defaultValue = "20") Integer count) {
        p = this.validateIntNNWithDefaultValue(p, 1);
        count = this.validateIntNNWithDefaultValue(count, 20);
        V2Node node = ns.findDetail(id, p, count);
        result.ok(node);
        return result;
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST)
    public Result getSearch(@RequestBody InputParam inputParam) {
        Result<Object> result = new Result<>();
        String keywords = Arr.getString(inputParam, "keywords");
        List<V2Node> nodes = ns.searchNode(keywords);
        result.ok(nodes);
        return result;
    }

    @GetMapping("/listAll")
    public Result listAllNode(Result result) {
        List<V2Node> nodes = ns.findAll();
        result.ok(nodes);
        return result;
    }

}
