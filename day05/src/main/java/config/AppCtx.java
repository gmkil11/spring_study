package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("models")
public class AppCtx {
    @Bean
    public DataSource dataSource() {// TOMCAT jdbc 를 사용해야 한다.
        DataSource ds = new DataSource();
        // DB 연결 설정 시작
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("spring6");
        ds.setPassword("_aA123456");
        // 데이터 베이스 연결 설정 E

        // 커넥션 풀 설정
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setTimeBetweenEvictionRunsMillis(3000); // 3초 마다 연결 상태 확인
        ds.setMinEvictableIdleTimeMillis(30 * 1000);

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }
}