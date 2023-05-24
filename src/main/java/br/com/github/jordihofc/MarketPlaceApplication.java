package br.com.github.jordihofc;

import br.com.github.jordihofc.consultaformaspagamento.FormaDePagamentoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class) // Needed by Zalando Problem lib
public class MarketPlaceApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(MarketPlaceApplication.class, args);
        var formaPagamentoRepository = applicationContext.getBean(FormaDePagamentoRepository.class);

        formaPagamentoRepository.findFormaDePagamentoEmComumEntre(1L, 1L).forEach(System.out::println);
        formaPagamentoRepository.findFormaDePagamentoEmComumEntre(1L, 1L).forEach(System.out::println);
    }

}
