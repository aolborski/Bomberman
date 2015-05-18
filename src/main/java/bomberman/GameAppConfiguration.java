package bomberman;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(ScreensConfiguration.class)
@ImportResource("classpath:bomberman-spring-context.xml")
public class GameAppConfiguration {

}
