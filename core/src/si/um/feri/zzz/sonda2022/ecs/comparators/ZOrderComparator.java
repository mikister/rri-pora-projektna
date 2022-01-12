package si.um.feri.zzz.sonda2022.ecs.comparators;

import java.util.Comparator;

import com.badlogic.ashley.core.Entity;

import si.um.feri.zzz.sonda2022.common.Mappers;

public class ZOrderComparator implements Comparator<Entity> {
    public static final ZOrderComparator INSTANCE = new ZOrderComparator();

    private ZOrderComparator() {
    }

    @Override
    public int compare(Entity entity1, Entity entity2) {
        return Float.compare(
                Mappers.POSITION.get(entity1).z,
                Mappers.POSITION.get(entity2).z);
    }
}
