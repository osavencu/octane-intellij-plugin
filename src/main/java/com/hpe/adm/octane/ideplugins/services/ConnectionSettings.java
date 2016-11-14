package com.hpe.adm.octane.ideplugins.services;

import com.hpe.adm.nga.sdk.authorisation.Authorisation;

public class ConnectionSettings {

    private String baseUrl;
    private Long sharedSpaceId;
    private Long workspaceId;
    private Authorisation authorisation;

    //Singleton
    private static ConnectionSettings connectionSettings;

    private ConnectionSettings(String baseUrl, Long sharedSpaceId, Long workspaceId, Authorisation authorisation){
        this.baseUrl = baseUrl;
        this.sharedSpaceId = sharedSpaceId;
        this.workspaceId = workspaceId;
        this.authorisation = authorisation;
    }

    public static ConnectionSettings init(String baseUrl, Long sharedSpaceId, Long workspaceId, Authorisation authorisation) {
        if(isInit()){
            throw new RuntimeException("Already init");
        }
        connectionSettings = new ConnectionSettings(baseUrl, sharedSpaceId, workspaceId, authorisation);
        return connectionSettings;
    }

    public static boolean isInit() {
        return connectionSettings != null;
    }

    public static ConnectionSettings getInstance(){
        return connectionSettings;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Long getSharedSpaceId() {
        return sharedSpaceId;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public Authorisation getAuthorisation() {
        return authorisation;
    }

}