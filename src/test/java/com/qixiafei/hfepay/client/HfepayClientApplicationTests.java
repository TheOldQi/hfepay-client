package com.qixiafei.hfepay.client;

import com.qixiafei.hfepay.client.core.HfepayClient;
import com.qixiafei.hfepay.client.params.HfepayHeader;
import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthParam;
import com.qixiafei.hfepay.client.params.HfepayIdPersonAuthResult;
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
public class HfepayClientApplicationTests {

    @Resource
    private HfepayClient hfepayClient;

    @Test
    public void contextLoads() throws Exception {
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

}

