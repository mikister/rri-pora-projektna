package si.um.feri.zzz.sonda2022.common;

import com.badlogic.ashley.core.ComponentMapper;

import si.um.feri.zzz.sonda2022.ecs.component.BoundsComponent;
import si.um.feri.zzz.sonda2022.ecs.component.DimensionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.MovementComponent;
import si.um.feri.zzz.sonda2022.ecs.component.PositionComponent;
import si.um.feri.zzz.sonda2022.ecs.component.RotationComponent;
import si.um.feri.zzz.sonda2022.ecs.component.SondaComponent;
import si.um.feri.zzz.sonda2022.ecs.component.TextureComponent;

public final class Mappers {
    public static final ComponentMapper<PositionComponent> POSITION = ComponentMapper.getFor(PositionComponent.class);

    public static final ComponentMapper<RotationComponent> ROTATION = ComponentMapper.getFor(RotationComponent.class);

    public static final ComponentMapper<MovementComponent> MOVEMENT = ComponentMapper.getFor(MovementComponent.class);

    public static final ComponentMapper<DimensionComponent> DIMENSION = ComponentMapper
            .getFor(DimensionComponent.class);

    public static final ComponentMapper<BoundsComponent> BOUNDS = ComponentMapper.getFor(BoundsComponent.class);

    public static final ComponentMapper<TextureComponent> TEXTURE = ComponentMapper.getFor(TextureComponent.class);

    public static final ComponentMapper<SondaComponent> SONDA = ComponentMapper.getFor(SondaComponent.class);

    private Mappers() {
    }
}
