package com.yad.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yad.web.entity.UseComputerRecord;
import com.yad.web.exception.MyException;
import com.yad.web.service.UseComputerRecordService;
import com.yad.web.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/web/use-computer-record")
public class UseComputerRecordController {
        @Autowired
        private UseComputerRecordService useService;


        //选择机器上机
        @PostMapping("/up")
        public R  upComputer(@RequestBody UseComputerRecord record){
                try {
                    useService.upComputer(record);
                }catch (MyException e){
                    R.error().message(e.getMsg());
                }
                return  R.ok();
        }

        @PostMapping("/down")
        public  R downComputer(@RequestBody UseComputerRecord record){
                try {
                        useService.downComputer(record);
                }catch (MyException e){
                        R.error().message(e.getMsg());
                }
                return  R.ok();
        }
        //所有机器的的使用记录
        @GetMapping("list")
        public  R listUseRecord(){
                List<UseComputerRecord> list = useService.list(null);
                return  R.ok().data("list",list);
        }
        //根据编号查询 使用记录
        @GetMapping("list/{id}")
        public R listUseRecordById(@PathVariable Integer id){
                QueryWrapper<UseComputerRecord> wrapper = new QueryWrapper<>(   );
                wrapper.eq("c_id",id);
                List<UseComputerRecord> list = useService.list(wrapper);
                return  R.ok().data("list",list);
        }
}

