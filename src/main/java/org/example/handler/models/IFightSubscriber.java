package org.example.handler.models;

import org.example.models.map.Position;

public interface IFightSubscriber {
    boolean execute(Position position);
}
