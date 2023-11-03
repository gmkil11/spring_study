package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {

    @Bean(destroyMethod = "close") // 닫힐때 자동으로 자원 해제
    public DataSource dataSource(){
        // 기본 연결 설정 시작
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("spring6");
        ds.setPassword("_aA123456");
        // 기본 연결 설정 끝

        // 연결 생명 주기 설정
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        // jdbcTemplate 설정
        return new JdbcTemplate(dataSource());
    }
}
