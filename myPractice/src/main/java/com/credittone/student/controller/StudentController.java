package com.credittone.student.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JerryChan
 * @date 2019/3/13 15:07
 */
@RestController
public class StudentController {

    public static void main(String[] args) throws Exception {

        String str = "{\"gps\": [{\"city\": \"泉州市\", \"address\": \"测试路\", \"country\": \"中国\", \"district\": \"测试区\", \"latitude\": \"39.960213\", \"province\": \"泉州市\", \"longitude\": \"116.302734\"}], \"loan\": {\"loanNo\": \"186518797541\", \"dueDate\": \"2018-11-05\", \"customerId\": \"188\", \"deniedTime\": \"2018-11-05 12:34:43\", \"loanStatus\": \"APPROVED\", \"returnFlag\": \"0\", \"paidOffTime\": \"2018-11-05 15:24:45\", \"effectiveDate\": \"2018-11-05\", \"approvedAmount\": \"10000\", \"deviceApproval\": \"ios\"}, \"product\": {\"productNo\": \"001\"}, \"customer\": {\"job\": \"2\", \"level\": \"1\", \"token\": \"TK000000001\", \"device\": \"IOS\", \"idCardNo\": \"82000020071217093X\", \"cellPhone\": \"17319307808\", \"education\": \"2\", \"zhimaInfo\": {\"score\": 10, \"province\": \"江苏\"}, \"idCardName\": \"测试—全部返回正确\", \"companyName\": \"奥体大街\", \"reportRefer\": \"0\", \"idCardGender\": \"F\", \"maritalStatus\": \"3\", \"householdsType\": \"1\", \"idCardBirthDate\": \"1992-08-12\", \"customerRelationships\": [{\"referName\": \"陈老师\", \"referPhone\": \"18354095***\", \"relationType\": \"1\", \"referRelationship\": \"7\"}]}, \"callHistories\": [{\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"10\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"9\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"8\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"7\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"6\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"5\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"4\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"3\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"2\"}, {\"time\": \"2018-04-02 15:59:39\", \"type\": \"1\", \"phone\": \"075523995670\", \"durationTime\": \"1\"}], \"customerAccount\": {\"bankCode\": \"ICBC\", \"cardStatus\": \"1\", \"accountPhone\": \"17319307808\", \"accountHolder\": \"张三\", \"accountNumber\": \"6214830259463***\", \"accountIdCardNo\": \"82000020071217093X\"}, \"simulatorStatus\": \"0\", \"customerLoginFlow\": {\"imei\": \"6604B0B5-A292-420D-A8A7-88B76321CCFA\", \"device\": \"ANDROID\", \"ipAddress\": \"121.225.246.19\", \"loginTime\": \"2018-08-27 14:15:14\"}}";
        String mima = AESUtil.encrypt(str, "SlZeS0SkoiJffjMi");
        System.out.println(mima);
    }

}
