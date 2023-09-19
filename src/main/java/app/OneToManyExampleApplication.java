package app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.Lists;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToManyExampleApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(OneToManyExampleApplication.class, args);
    }

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Address hanoi = Address.builder()
                .city("hanoi")
                .build();
        Address hatay = Address.builder()
                .city("hatay")
                .build();

        Person person1 = Person.builder()
                .name("loda")
                .build();
        Person person2 = Person.builder()
                .name("linh")
                .build();
        hanoi.setPerson(Lists.newArrayList(person1, person2));
        hatay.setPerson(Lists.newArrayList(person1));

        addressRepository.saveAndFlush(hanoi);
        addressRepository.saveAndFlush(hatay);

        Address queryResult = addressRepository.findById(1L).get();
        System.out.println(queryResult.getCity());
        System.out.println(queryResult.getPerson());
    }
}
