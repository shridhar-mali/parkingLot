package com.thoughtworks.objectBootcamp.parkingLot.event;

import com.thoughtworks.objectBootcamp.parkingLot.people.IAmASubscriber;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ParkingFullTest {

    @Test
    public void shouldNotifySubscribersIfThethresholdIsBreached(){
        IAmASubscriber firstMockSubscriber = mock(IAmASubscriber.class);
        IAmASubscriber secondMockSubscriber = mock(IAmASubscriber.class);
        ArrayList<IAmASubscriber> subscribers = new ArrayList<>();
        subscribers.add(firstMockSubscriber);
        subscribers.add(secondMockSubscriber);
        ParkingFull parkingFull = new ParkingFull(subscribers, 100);

        parkingFull.notifySubscribersIfThresholdBreached(100);

        verify(firstMockSubscriber).performAction();
        verify(secondMockSubscriber).performAction();
    }

    @Test
    public void shouldNOTNotifySubscribersIfThethresholdIsNOTBreached(){
        IAmASubscriber firstMockSubscriber = mock(IAmASubscriber.class);
        IAmASubscriber secondMockSubscriber = mock(IAmASubscriber.class);
        ArrayList<IAmASubscriber> subscribers = new ArrayList<>();
        subscribers.add(firstMockSubscriber);
        subscribers.add(secondMockSubscriber);
        ParkingFull parkingFull = new ParkingFull(subscribers, 100);

        parkingFull.notifySubscribersIfThresholdBreached(200);

        verifyZeroInteractions(firstMockSubscriber);
        verifyZeroInteractions(secondMockSubscriber);
    }

}