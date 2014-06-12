package by.epam.task2.service.textchange.composite;


/**
 * Created by Максим&Маша on 04.06.14.
 */
public class Particle implements IParticleComposite {

    String particle;

    public Particle(String string) {
        this.particle = string;
    }

    public String getParticle() {
        return particle;
    }

    public IParticleComposite getParticleComposite() {
        return this;
    }


}
