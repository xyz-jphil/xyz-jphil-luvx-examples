package luvx.demo;

/**
 *
 * @
 */
public interface Cacheable<I extends Cacheable<I>> {

    default String getCacheKey() {
        return "cache_" + System.identityHashCode(this);
    }
}
