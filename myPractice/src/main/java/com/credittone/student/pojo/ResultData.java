package com.credittone.student.pojo;

/**
 * @author JerryChan
 * @date 2019/4/18 16:32
 */
public class ResultData {

    private String msg = "查询成功";
    private String status_code = "200";
    private DataModul data;
    private String id = "787cf27e-2531-46c8-9f7d-e8c3c4bbf3e4";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public DataModul getData() {
        return data;
    }

    public void setData(DataModul data) {
        this.data = data;
    }
}
