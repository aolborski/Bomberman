package bomberman;

import javafx.fxml.FXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component("fxmlLoader")
public class BmFxmlLoader extends FXMLLoader implements ApplicationContextAware {

  private static final Logger LOG = LoggerFactory.getLogger(BmFxmlLoader.class);

  public BmFxmlLoader() throws MalformedURLException {

    super(BmFxmlLoader.class.getResource("/bomberman/ui/RootPane.fxml"));
  }

  @Override
  public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {

    LOG.debug("setting application context: {}", applicationContext);

    setControllerFactory(clazz -> applicationContext.getBean(clazz));
  }
}
