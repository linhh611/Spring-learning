package app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private final UserRepository userRepository;

    @Bean
    CommandLineRunner run() {
        return args -> {
          Page<User> page = userRepository.findAll(PageRequest.of(0, 5));

            System.out.println("In ra 5 user dau tien");
            page.forEach(System.out::println);
            page = userRepository.findAll(page.nextPageable());
            System.out.println("In ra 5 user tiep theo");
            page.forEach(System.out::println);

            System.out.println(page.getSize());
            System.out.println(page.getTotalElements());
            System.out.println(page.getTotalPages());

            page = userRepository.findAll(PageRequest.of(1,5, Sort.by("name").descending()));
            System.out.println("in 5 user page 1 sap xep theo ten des");
            page.forEach(System.out::println);

            List<User> list = userRepository.findAllByNameLike("name-%", (Pageable) PageRequest.of(0,5));
            System.out.println(list);
        };
    }
}
