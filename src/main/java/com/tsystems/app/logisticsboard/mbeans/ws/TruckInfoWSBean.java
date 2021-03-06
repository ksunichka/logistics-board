package com.tsystems.app.logisticsboard.mbeans.ws;

import com.tsystems.app.logisticsboard.enums.ChannelWS;
import com.tsystems.app.logisticsboard.mbeans.data.TruckInfoData;
import com.tsystems.app.logisticsboard.mbeans.rest.TruckInfoMBean;
import com.tsystems.app.logisticscommon.MessageDto;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;
import org.primefaces.push.impl.JSONEncoder;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by ksenia on 17.11.2017.
 */
@ManagedBean(name = "truckInfoWSBean")
@RequestScoped
public class TruckInfoWSBean {

    private static final String CHANNEL = ChannelWS.TRUCK_INFO.getName();
    private final EventBus eventBus = EventBusFactory.getDefault().eventBus();
    @Inject
    private TruckInfoData truckInfoData;

    public void send(MessageDto message) {
        truckInfoData.changeData(message);
        eventBus.publish(CHANNEL, message);
    }

}
