package soa;

import me.ele.huskar.adapter.HuskarHandle;
import me.ele.huskar.adapter.api.serv.ServiceHandle;
import me.ele.huskar.common.exception.HuskarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Date: 2018/11/25
 *
 * @author: Eylaine
 */
public class SoaClient {

    private static Logger LOGGER = LoggerFactory.getLogger(SoaClient.class);

    private ServiceHandle handle;

    public SoaClient() {
        handle = HuskarHandle.getInstance().getServiceHandle();
    }

    public void getService() throws HuskarException {
        System.out.println(handle.getClusters("zeus.eus"));
    }

}
