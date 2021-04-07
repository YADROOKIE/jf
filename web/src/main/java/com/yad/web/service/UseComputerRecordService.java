package com.yad.web.service;

import com.yad.web.entity.UseComputerRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yad.web.exception.MyException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-04-07
 */
public interface UseComputerRecordService extends IService<UseComputerRecord> {

    void upComputer(UseComputerRecord record)  throws MyException;

    void downComputer(UseComputerRecord record) throws MyException;;
}
