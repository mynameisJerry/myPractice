import com.alibaba.druid.pool.DruidDataSource;
import com.credittone.student.pojo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JerryChan
 * @date 2019/4/18 16:35
 */
public class Testdemo {


    private final String YINLIAN = "银联";

    @Test
    public void test1() throws IOException {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword("wxrc@123Qwe");
        dataSource.setUsername("wxrc");
        dataSource.setUrl("jdbc:mysql://192.168.1.235:3306/crp_dev?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        StringBuffer name = new StringBuffer(YINLIAN + "_");
        ObjectMapper objectMapper = new ObjectMapper();
        ResultData resultData = new ResultData();
        DataModul dataModul = new DataModul();
        YinLian yinLian = new YinLian();

        String sql = "select * from crp_risk_base_conf_item";
        List<CrpRiskBaseConfItem> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CrpRiskBaseConfItem>(CrpRiskBaseConfItem.class));
        System.out.println(query.size());
        for (int i = 0; i < query.size(); i++) {

            //这里输入匹配的数据标号，下面的yinlian对象的set方法也要相应改变
            if ("CP0123".equals(query.get(i).getRiskBaseConfMap())) {

                /*
                //匹配数据项为“是/否”类型的数据
                StringWriter sw = new StringWriter();

                if (query.get(i).getRiskEnumKey().equals("是")) {
                    yinLian.setCP0123("是");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("否")) {
                    yinLian.setCP0123("否");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                TestAnalogueMessage tam = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName());
                }
                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }
                System.out.println("name : " + name);
                tam.setName(name.toString());
                tam.setD0501(sw.toString());
                tam.setBankCardNo("6222080509000549656");
                tam.setMobileNo("13121416929");
                String insertSql = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update = jdbcTemplate.update(insertSql, tam.getName(), tam.getMobileNo(), tam.getBankCardNo(), tam.getD0501());
                System.err.println("成功： " + update);
                name.setLength(0);
                name.append(YINLIAN + "_");

                */


                /*
                //匹配数据项类型为连续型的 分别为等于标准值 小于标准值 大于标准值
                StringWriter sw = new StringWriter();
                YinLian yinLian1 = new YinLian();
                dataModul.setQuot_value(yinLian1);
                resultData.setData(dataModul);
                objectMapper.writeValue(sw, resultData);
                System.err.println("json:   "+sw);
                TestAnalogueMessage tam = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName()+"_等于标准值");
                }
                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }
                System.out.println("name : "+name);
                tam.setName(name.toString());
                tam.setD0501(sw.toString());
                tam.setBankCardNo("6222080509000549656");
                tam.setMobileNo("13121416929");
                String insertSql = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update = jdbcTemplate.update(insertSql, tam.getName(), tam.getMobileNo(), tam.getBankCardNo(), tam.getD0501());
                System.err.println("成功： "+update);
                name.setLength(0);
                name.append(YINLIAN+"_");


                StringWriter sw1 = new StringWriter();
                YinLian yinLian2 = new YinLian();

                //这里输入小于标准值
                yinLian2.setCP0016("1月");
                dataModul.setQuot_value(yinLian2);
                resultData.setData(dataModul);
                objectMapper.writeValue(sw1, resultData);
                System.err.println("json:   "+sw1);
                TestAnalogueMessage tam1 = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName()+"_小于标准值");
                }
                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }
                System.out.println("name : "+name);
                tam1.setName(name.toString());
                tam1.setD0501(sw1.toString());
                tam1.setBankCardNo("6222080509000549656");
                tam1.setMobileNo("13121416929");
                String insertSql1 = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update1 = jdbcTemplate.update(insertSql1, tam1.getName(), tam1.getMobileNo(), tam1.getBankCardNo(), tam1.getD0501());
                System.err.println("成功： "+update1);
                name.setLength(0);
                name.append(YINLIAN+"_");

                StringWriter sw2 = new StringWriter();
                YinLian yinLian3 = new YinLian();

                //这里输入大于标准值
                yinLian3.setCP0016("2年");
                dataModul.setQuot_value(yinLian3);
                resultData.setData(dataModul);
                objectMapper.writeValue(sw2, resultData);
                System.err.println("json:   "+sw2);
                TestAnalogueMessage tam2 = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName() + "_大于标准值");
                }
                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }

                System.out.println("name : "+name);
                tam2.setName(name.toString());
                tam2.setD0501(sw1.toString());
                tam2.setBankCardNo("6222080509000549656");
                tam2.setMobileNo("13121416929");
                String insertSql2 = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update3 = jdbcTemplate.update(insertSql2, tam2.getName(), tam2.getMobileNo(), tam2.getBankCardNo(), tam2.getD0501());
                System.err.println("成功： "+update3);
                name.setLength(0);

                 */



                /*
                //这里是数据项为“高/中/低”型的
                StringWriter sw = new StringWriter();
                if (query.get(i).getRiskEnumKey().equals("")) {
                    yinLian.setCP0014("");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);


                }
                if (query.get(i).getRiskEnumKey().equals("高")) {
                    yinLian.setCP0014("高");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);

                }
                if (query.get(i).getRiskEnumKey().equals("中")) {
                    yinLian.setCP0014("中");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("低")) {
                    yinLian.setCP0014("低");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }


                TestAnalogueMessage tam = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName());
                }

                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }

                System.out.println("name : " + name);
                tam.setName(name.toString());
                tam.setD0501(sw.toString());
                tam.setBankCardNo("6222080509000549656");
                tam.setMobileNo("13121416929");
                String insertSql = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update = jdbcTemplate.update(insertSql, tam.getName(), tam.getMobileNo(), tam.getBankCardNo(), tam.getD0501());
                System.err.println("成功： " + update);
                name.setLength(0);
                name.append(YINLIAN + "_");
                 */




                /*
                //这里是数据项为“一档、二档。。。。”类型的
                StringWriter sw = new StringWriter();
                if (query.get(i).getRiskEnumKey().equals("")) {
                    yinLian.setCP0014("");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);


                }
                if (query.get(i).getRiskEnumKey().equals("一档")) {
                    yinLian.setCP0014("一档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);

                }
                if (query.get(i).getRiskEnumKey().equals("二档")) {
                    yinLian.setCP0014("二档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("三档")) {
                    yinLian.setCP0014("三档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("四档")) {
                    yinLian.setCP0014("四档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("五档")) {
                    yinLian.setCP0014("五档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("六档")) {
                    yinLian.setCP0014("六档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("七档")) {
                    yinLian.setCP0014("七档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("八档")) {
                    yinLian.setCP0014("八档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("九档")) {
                    yinLian.setCP0014("九档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }
                if (query.get(i).getRiskEnumKey().equals("十档")) {
                    yinLian.setCP0014("十档");
                    dataModul.setQuot_value(yinLian);
                    resultData.setData(dataModul);
                    objectMapper.writeValue(sw, resultData);
                    System.err.println("json:   " + sw);
                }

                TestAnalogueMessage tam = new TestAnalogueMessage();
                if (query.get(i).getRiskBaseConfName() != null) {
                    name.append(query.get(i).getRiskBaseConfName());
                }

                if (query.get(i).getRiskEnumKey() != null) {
                    name.append("_" + query.get(i).getRiskEnumKey());
                }

                System.out.println("name : " + name);
                tam.setName(name.toString());
                tam.setD0501(sw.toString());
                tam.setBankCardNo("6222080509000549656");
                tam.setMobileNo("13121416929");
                String insertSql = "INSERT INTO test_analogue_message (name,mobile_no,bank_card_no,D0501) VALUES (?,?,?,?)";
                int update = jdbcTemplate.update(insertSql, tam.getName(), tam.getMobileNo(), tam.getBankCardNo(), tam.getD0501());
                System.err.println("成功： " + update);
                name.setLength(0);
                name.append(YINLIAN + "_");
                 */
                }

        }

    }


    @Test
    public void test2() {
        Testdemo obj = new Testdemo();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/readExcel.xls");
        List excelList = obj.readExcel(file);
        System.out.println("list中的数据打印出来");
        for (int i = 0; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }

    }

    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                        System.out.print(cellinfo);
                    }
                    outerList.add(i, innerList);
                    System.out.println();
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void test3() {
        YinLian yinLian = new YinLian();
        DataModul dataModul = new DataModul();
        dataModul.setQuot_value(yinLian);
        ResultData resultData = new ResultData();
        resultData.setData(dataModul);

        StringWriter sw = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(sw, resultData);
            System.err.println(sw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
