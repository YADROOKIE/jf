package com.yad.web.controller;


import com.yad.web.entity.Computer;
import com.yad.web.service.ComputerService;
import com.yad.web.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/web/computer")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @PostMapping("add")
    public R addComputer(@RequestBody Computer computer){
        boolean ok = computerService.save(computer);
        return  ok ? R.ok():R.error();
    }

    @PostMapping("edit")
    public  R editComputer(@RequestBody Computer computer){
        boolean ok = computerService.updateById(computer);
        return  ok ? R.ok():R.error();
    }

    @PostMapping("delete")
    public  R deleteComputer(@RequestBody Computer computer){
        boolean ok = computerService.removeById(computer.getId());
        return  ok ? R.ok():R.error();
    }


    @GetMapping("list")
    public  R listComputer(){
        List<Computer> list = computerService.list(null);
        return  R.ok().data("list",list);
    }


}

