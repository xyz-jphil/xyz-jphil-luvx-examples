package luvx.demo;

/**
 *
 * @
 */
public interface Timestamped<I extends Timestamped<I>> {

    default long getTimestamp() {
        return System.currentTimeMillis();
    }
    
    // Fluent default method enabled by self()!
    default I withTimestamp() {
        // Set timestamp logic here
        return self(); // Only possible with self()!
    }

    I self(); // Required for fluent default methods
    
}
