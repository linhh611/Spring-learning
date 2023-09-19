package app;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfig {

    private final UserRepository userRepository;

    @PostConstruct
    public void initData() {
        // Insert 100 User vào H2 Database sau khi
        // DatasourceConfig được khởi tạo
        userRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> User.builder()
                        .name("name-" + i)
                        .build())
                .collect(Collectors.toList())
        );
    }
}
