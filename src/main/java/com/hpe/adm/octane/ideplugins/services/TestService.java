package com.hpe.adm.octane.ideplugins.services;

import com.hpe.adm.nga.sdk.NGA;
import com.hpe.adm.nga.sdk.model.EntityModel;

import java.util.Collection;

/**
 * Created by tothan on 11/14/2016
 */
public class TestService {

    private NGA nga;

    //Just for testing
    public TestService() {
        if(!ConnectionSettings.isInit()){
            throw new RuntimeException("ConnectionsSettings not init");
        }

        ConnectionSettings connectionSettings = ConnectionSettings.getInstance();

        NGA.Builder builder = new NGA
                .Builder(connectionSettings.getAuthorisation())
                .Server(connectionSettings.getBaseUrl())
                .sharedSpace(connectionSettings.getSharedSpaceId())
                .workSpace(connectionSettings.getWorkspaceId());

        nga = builder.build();
    }

    public Collection<EntityModel> getDefects(){
        return nga.entityList("defects").get().execute();
    }

}
