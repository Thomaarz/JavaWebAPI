package fr.thomarz.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {

    CLICK("onclick");

    private final String event;

}
