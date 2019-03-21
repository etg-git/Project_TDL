package com.taegyun.tdl;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.ToDoListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class TdlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdlApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ToDoListRepository toDoListRepository) throws Exception {
        return (args) -> {
            IntStream.rangeClosed(1, 1).forEach(index -> toDoListRepository.save(ToDoList.builder()
                    .status(true)
                    .description("안녕 투두리스트" + index)
                    .createdDate(LocalDateTime.now())
//                    .completedDate(LocalDateTime.now())
                    .build())
            );
        };
    }
        @Bean
        public FilterRegistrationBean filterRegistrationBean() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean();
            CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
            characterEncodingFilter.setEncoding("UTF-8");
            registrationBean.setFilter(characterEncodingFilter);
            return registrationBean;
    }
}
