package luvx.demo;

/**
 *
 * @
 */
public class SuperElement extends DemoContainer implements Cacheable<SuperElement>,
        Timestamped<SuperElement> {

    private long timestamp;

    public SuperElement(String tagName) {
        super(tagName);
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public SuperElement withTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return self(); // or just return this also works;
        // self() is relevant in interfaces with default, not so much in classes.
    }

    @Override
    public SuperElement self() { // this is needed
        return this;
    }

    public String getSuperPower() {
        return "composability";
    }
}
