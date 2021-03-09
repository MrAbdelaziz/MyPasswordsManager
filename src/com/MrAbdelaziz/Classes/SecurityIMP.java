package com.MrAbdelaziz.Classes;

import com.MrAbdelaziz.Interfaces.Security;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class SecurityIMP implements Security {


    private static SecurityIMP ins = null;

    private SecurityIMP() {
    }

    public static SecurityIMP getInstance() {
        if (ins == null)
            ins = new SecurityIMP();
        return ins;
    }

    @Override
    public String getKey()  {
        String macAddress = "MrAbdelaziz-";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();

                if (hardwareAddress != null) {
                    String[] hexadecimalFormat = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    macAddress +=String.join("", hexadecimalFormat);
                }
            }
        }catch (Exception ex){
            System.out.println("FBI OPEN UP");
        }





        return  macAddress;
    }

}
