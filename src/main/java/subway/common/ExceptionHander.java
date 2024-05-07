package subway.common;

public class ExceptionHander {

    public static void retryOnException(final Runnable runnable) {
        try {
            runnable.run();
        } catch (final IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            retryOnException(runnable);
        }
    }
}
