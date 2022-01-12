package si.um.feri.zzz.sonda2022.common;

import com.badlogic.ashley.core.ComponentMapper;

import si.um.feri.zzz.sonda2022.ecs.component.PositionComponent;

public final class Mappers {
    public static final ComponentMapper<PositionComponent> POSITION = ComponentMapper.getFor(PositionComponent.class);

    private Mappers() {
    }
}
