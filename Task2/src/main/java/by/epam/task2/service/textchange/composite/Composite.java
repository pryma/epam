package by.epam.task2.service.textchange.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим&Маша on 04.06.14.
 */
public class Composite implements IParticleComposite, Comparable<Composite> {

    private List<IParticleComposite> particleList = new ArrayList<IParticleComposite>();

    public Composite() {
    }

    public void addParticle(IParticleComposite particle) {
        particleList.add(particle);
    }

    public void removeParticle(IParticleComposite part) {
        particleList.remove(part);
    }

    public List<IParticleComposite> getParticleList() {
        return particleList;
    }

    public void setParticleList(List<IParticleComposite> particleList) {
        this.particleList = particleList;
    }

    public IParticleComposite getParticleComposite() {
        IParticleComposite returnParticle = null;
        for (IParticleComposite IParticleComposite : this.particleList) {
            returnParticle = IParticleComposite.getParticleComposite();
            return returnParticle;
        }
        return returnParticle;
    }

    @Override
    public int compareTo(Composite o) {
        int oSize = o.getParticleList().size();
        return this.particleList.size() - oSize;
    }
}
