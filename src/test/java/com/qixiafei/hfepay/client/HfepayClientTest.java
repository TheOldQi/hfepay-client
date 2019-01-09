package com.qixiafei.hfepay.client;

import com.qixiafei.hfepay.client.core.HfepayClient;
import com.qixiafei.hfepay.client.params.*;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class HfepayClientTest {

    @Resource
    private HfepayClient hfepayClient;

    @Test
    public void idPerson() throws Exception {
        final HfepayIdPersonAuthParam req = new HfepayIdPersonAuthParam();
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());

        req.setHeader(header);
        req.setVector("32414111");
        req.setRealName("齐霞飞");
        req.setIdCard("152301198712096033");
        req.setImg(IOUtils.toByteArray(new FileInputStream("D:\\工作变动\\证明材料\\齐霞飞身份证反面.jpg")));
        HfepayIdPersonAuthResult hfepayIdPersonAuthResp = hfepayClient.idPersonAuth(req);
        System.out.println(hfepayIdPersonAuthResp.toString());
    }


    @Test
    public void idOcr() throws Exception {
        final HfepayIdOcrParam param = new HfepayIdOcrParam();
        param.setPhoto(IOUtils.toByteArray(new FileInputStream("D:\\工作变动\\证明材料\\齐霞飞身份证反面.jpg")));
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayIdOcrResult hfepayIdOcrResult = hfepayClient.idOcr(param);
        System.out.println("client返回=" + hfepayIdOcrResult);

    }

    @Test
    public void bankCardOcr() throws Exception {
        final HfepayBankCardOcrParam param = new HfepayBankCardOcrParam();
        param.setPhoto(IOUtils.toByteArray(new FileInputStream("D:\\工作变动\\证明材料\\bankcard.jpg")));
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayBankCardOcrResult result = hfepayClient.bankCardOcr(param);
        System.out.println("client返回=" + result);

    }

    @Test
    public void idNameAuth() throws Exception {
        final HfepayIdNameAuthParam param = new HfepayIdNameAuthParam();
        param.setRealName("齐霞飞");
        param.setIdCard("152301198712096033");
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayBaseResult result = hfepayClient.idNameAuth(param);
        System.out.println("client返回=" + result);
    }

    @Test
    public void bankCardElement2() throws Exception {
        final HfepayBankCardElement2Param param = new HfepayBankCardElement2Param();
        param.setRealName("齐霞飞");
        param.setBankCard("6214830480656661");
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayBaseResult result = hfepayClient.bankCardElement2(param);
        System.out.println("client返回=" + result);
    }

    @Test
    public void bankCardElement3() throws Exception {
        final HfepayBankCardElement3Param param = new HfepayBankCardElement3Param();
        param.setRealName("齐霞飞");
        param.setBankCard("6214830480656661");
        param.setIdCard("152301198712096033");
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayBaseResult result = hfepayClient.bankCardElement3(param);
        System.out.println("client返回=" + result);
    }

    @Test
    public void bankCardElement4() throws Exception {
        final HfepayBankCardElement4Param param = new HfepayBankCardElement4Param();
        param.setRealName("齐霞飞");
        param.setBankCard("6214830480656661");
        param.setIdCard("152301198712096033");
        param.setMobile("15210254805");
        param.setVector("12345678");
        final HfepayHeader header = new HfepayHeader();
        header.setQryBatchNo("123456");
        header.setQryReason("测试");
        header.setQryTime(new Date());
        param.setHeader(header);

        HfepayBaseResult result = hfepayClient.bankCardElement4(param);
        System.out.println("client返回=" + result);
    }

}

