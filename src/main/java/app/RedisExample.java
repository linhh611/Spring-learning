package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisExample implements CommandLineRunner {
    @Autowired
    private RedisTemplate template;

    @Override
    public void run(String... args) throws Exception {
        template.opsForValue().set("linh", "hello world");

        System.out.println("Value of key linh: "+ template.opsForValue().get("linh"));
    }
}
