package ec.com.kruger.performance.db.mongo;

import ec.com.kruger.performance.db.model.Customer;
import ec.com.kruger.performance.db.mongo.repository.CustomerMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
@SpringBootApplication(scanBasePackages = { "ec.com.kruger.performance.db.mongo" })
public class MongoPerformanceApplication implements CommandLineRunner {

	@Autowired
	private CustomerMongoRepository repository;

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	public static void main(String[] args) {
		SpringApplication.run(MongoPerformanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		long initTime = new Date().getTime();
		log.debug("Init Data generator:{}", initTime);
		List<Future<?>> futures = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			final int v=i;
			futures.add(threadPoolTaskExecutor.submit(()->{
				repository.save(Customer.builder().firstName("Alice"+v).lastName("Smith").build());
			}));
		}
		for (Future<?> future : futures) {
			future.get();
		}
		long endTime = new Date().getTime();
		log.debug("End Data generator:{},Time:{}", endTime, endTime - initTime);

	}

}

