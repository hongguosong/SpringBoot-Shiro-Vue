package com.heeexy.example.ice;

import com.heeexy.example.config.common.Constants;
import generated.Demo.HelloPrxHelper;

/**
 *
 * @param <T>
 */
public class IceProxyFactory <T extends Ice.ObjectPrx>{

    /**
     *
     * @param proxyStr
     * @param <T>
     * @return
     */
    public static <T> T createProxy(String proxyStr) {
        Ice.ObjectPrx objectPrx = IceServiceEntrance.getInstance()
                .getCommunicator().propertyToProxy(proxyStr);
        T proxy = null;

        if (proxyStr == Constants.HELLO_PROXY) {
            proxy = (T) HelloPrxHelper.checkedCast(objectPrx);
        }
        return  proxy;
    }
}
