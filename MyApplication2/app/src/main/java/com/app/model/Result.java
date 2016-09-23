package com.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wafer on 2016/9/23.
 */

public class Result implements Serializable {
    private Integer result;
    private String msg;
    private List<FileInfo> resObjs;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<FileInfo> getResObjs() {
        return resObjs;
    }

    public void setResObjs(List<FileInfo> resObjs) {
        this.resObjs = resObjs;
    }

}
