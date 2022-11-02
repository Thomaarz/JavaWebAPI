package fr.thomarz.identifier;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WebIdentifiers {

    ID("id"),
    CLASS("class");

    private final String name;
}
