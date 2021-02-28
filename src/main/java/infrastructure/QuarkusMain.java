package infrastructure;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

import java.util.Optional;

@io.quarkus.runtime.annotations.QuarkusMain
public class QuarkusMain {

    public static void main(String... args) {
        String profile = Optional.ofNullable(System.getProperty("mode"))
                                                   .orElse("stub");
        System.setProperty("quarkus.profile", profile);
        Quarkus.run(QuarkusApp.class, args);
    }

    public static class QuarkusApp implements QuarkusApplication {
        @Override
        public int run(String... args) {
            Quarkus.waitForExit();
            return 0;
        }
    }
}
