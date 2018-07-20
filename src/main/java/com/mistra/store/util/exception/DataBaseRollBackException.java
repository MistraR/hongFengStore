package com.mistra.store.util.exception;


import com.mistra.store.util.web.ResultCode;

/**
 * Author : WangRui
 * Date : 2018/5/20
 * Describe:
 */
public class DataBaseRollBackException extends BaseServiceException {
    public DataBaseRollBackException() {
        super(ResultCode.DATABASE_ERROR);
    }
}
