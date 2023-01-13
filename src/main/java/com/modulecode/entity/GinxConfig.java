package com.modulecode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GinxConfig {
    private String configUrl; //配置文件路径
    private String version = "1.0.0";
    private String name;
    private String host;
    private int tcpPort;
    private int maxConn;
    private String ipVersion;
    private int maxPackageSize = 10240 * 30;
    private String logoImageStr = """
                       
            ██╗  ██╗███████╗██╗     ██╗      ██████╗      ██████╗ ██╗███╗   ██╗██╗  ██╗
            ██║  ██║██╔════╝██║     ██║     ██╔═══██╗    ██╔════╝ ██║████╗  ██║╚██╗██╔╝
            ███████║█████╗  ██║     ██║     ██║   ██║    ██║  ███╗██║██╔██╗ ██║ ╚███╔╝\s
            ██╔══██║██╔══╝  ██║     ██║     ██║   ██║    ██║   ██║██║██║╚██╗██║ ██╔██╗\s
            ██║  ██║███████╗███████╗███████╗╚██████╔╝    ╚██████╔╝██║██║ ╚████║██╔╝ ██╗
            ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝      ╚═════╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝
            """;

    public void printLogoImageStr() {
        System.out.println(this.getLogoImageStr());
        System.out.printf("""
                 ===========================================================================
                 :: GINX ::                                                       (V%s)
                """, this.getVersion());

    }

}
