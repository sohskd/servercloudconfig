package com.profesorp.configclient;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Mysqlconfig {

  @Value(value = "${jdbc.mysql.driver}")
  private String driverName;

  @Value(value = "${jdbc.mysql.url}")
  private String mysqlUrl;

  @Value(value = "${jdbc.mysql.username}")
  private String mysqlUserName;

  @Value(value = "${jdbc.mysql.password}")
  private String mysqlPassword;

  @Value(value = "${jdbc.mysql.pool.name}")
  private String poolName;

  @Bean(name = "mysqlDataSource")
  public DataSource mysqlDataSource() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName(driverName);
    config.setJdbcUrl(mysqlUrl);
    config.setUsername(mysqlUserName);
    config.setPassword(mysqlPassword);
    config.setPoolName(poolName);
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    return new HikariDataSource(config);
  }
}
