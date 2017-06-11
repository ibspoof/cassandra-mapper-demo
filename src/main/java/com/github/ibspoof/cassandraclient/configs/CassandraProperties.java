package com.github.ibspoof.cassandraclient.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
public class CassandraProperties {

    @Value("${cassandra.global.clusterName}")
    private String clusterName;

    @Value("${cassandra.global.reconnect.baseDelay}")
    private Integer reconnectBaseDelay;


    @Value("${cassandra.global.reconnect.maxDelay}")
    private Integer reconnectMaxDelay;

    @Value("${cassandra.local.hosts}")
    private String localHosts;

    @Value("${cassandra.local.port}")
    private Integer localPort;

    @Value("${cassandra.local.dcName}")
    private String localDcName;

    @Value("${cassandra.global.auth.username}")
    private String authUsername;

    @Value("${cassandra.global.auth.username}")
    private String authPassword;

    @Value("${cassandra.global.connectionsMin}")
    private Integer connectionsMin;

    @Value("${cassandra.global.connectionsMax}")
    private Integer connectionsMax;

    @Value("${cassandra.global.defaultKeyspace}")
    private String defaultKeyspace;


    public String getAuthUsername() {
        return authUsername;
    }

    public String getAuthPassword() {
        return authPassword;
    }


    public Integer getReconnectBaseDelay() {
        return reconnectBaseDelay;
    }

    public Integer getReconnectMaxDelay() {
        return reconnectMaxDelay;
    }

    public String getLocalHosts() {
        return localHosts;
    }

    public Integer getLocalPort() {
        return localPort;
    }

    public String getLocalDcName() {
        return localDcName;
    }

    public Integer getConnectionsMin() {
        return connectionsMin;
    }

    public Integer getConnectionsMax() {
        return connectionsMax;
    }


    public String getClusterName() {
        return clusterName;
    }

    public String getDefaultKeyspace() {
        return defaultKeyspace;
    }
}