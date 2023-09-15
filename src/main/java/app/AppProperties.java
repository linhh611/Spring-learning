package app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String email;
    private String googleAnalyticsId;
    private List<String> authors;
    private Map<String, String> exampleMap;
}
