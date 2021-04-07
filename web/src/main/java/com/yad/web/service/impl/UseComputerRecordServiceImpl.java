package com.yad.web.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.yad.web.entity.Computer;
import com.yad.web.entity.UseComputerRecord;
import com.yad.web.entity.constant.ComputerStatus;
import com.yad.web.exception.MyException;
import com.yad.web.mapper.UseComputerRecordMapper;
import com.yad.web.service.ComputerService;
import com.yad.web.service.UseComputerRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-04-07
 */
@Service
public class UseComputerRecordServiceImpl extends ServiceImpl<UseComputerRecordMapper, UseComputerRecord> implements UseComputerRecordService {
    @Autowired
    private ComputerService computerService;

    @Override
    public void upComputer(UseComputerRecord record) throws MyException {
        Computer computer = computerService.getById(record.getCId());
        if (!computer.getCStatus().equals(ComputerStatus.free)){
            throw new MyException(400,"设备正在使用或故障，无法使用");
        }
        computer.setCStatus(ComputerStatus.use);

        if (!this.save(record)){
            throw  new MyException(400,"上机失败");
        }
    }

    @Override
    public void downComputer(UseComputerRecord record) throws MyException {
        Computer computer = computerService.getById(record.getCId());
        if (!computer.getCStatus().equals(ComputerStatus.use)){
            throw new MyException(400,"已下机无需重复下机");
        }
        computer.setCStatus(ComputerStatus.free);

        UseComputerRecord useComputerRecord = this.getById(record.getId());
        Date date = DateUtil.date();
        useComputerRecord.setDownTime(date);

        long between = DateUtil.between(useComputerRecord.getUpTime(), date, DateUnit.MINUTE);
        useComputerRecord.setTotalTime(between);

        ;
        if (!this.updateById(useComputerRecord)){
            throw  new MyException(400,"下机失败");
        }
    }
}
